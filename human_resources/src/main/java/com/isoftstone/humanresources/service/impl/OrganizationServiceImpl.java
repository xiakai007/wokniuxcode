package com.isoftstone.humanresources.service.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.WorkTimeDao;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.util.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.isoftstone.humanresources.dao.OrganizationDao;
import com.isoftstone.humanresources.dao.SystemConfigDao;
import com.isoftstone.humanresources.domain.HealthCheckInformation;
import com.isoftstone.humanresources.domain.OrganizationInformation;
import com.isoftstone.humanresources.domain.SystemConfigInformation;
import com.isoftstone.humanresources.domain.organization.OrganizationInfoVO;
import com.isoftstone.humanresources.domain.organization.OrganizationTreeVO;
import com.isoftstone.humanresources.domain.organization.OrganizationUpdatePersonVO;
import com.isoftstone.humanresources.domain.organization.QueryLeaderVO;
import com.isoftstone.humanresources.domain.organization.QueryProjectPoVO;
import com.isoftstone.humanresources.domain.organization.QuerySkillProjectVO;
import com.isoftstone.humanresources.domain.screen.ScreenMapEntity;
import com.isoftstone.humanresources.domain.warn.HealthCheckEntity;
import com.isoftstone.humanresources.service.EmployeeService;
import com.isoftstone.humanresources.service.OrganizationService;
import com.isoftstone.humanresources.service.ScreenMapService;
@Service(value = "OrganizationService")
public class OrganizationServiceImpl implements OrganizationService {
    private final static Logger logger = LoggerFactory.getLogger(OrganizationService.class);
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private SystemConfigDao systemConfigDao;
    @Autowired
    private ScreenMapService screenMapService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WorkTimeDao workTimeDao;
    /**
     * 根据ID获取组织的基本信息
     *
     * @param organizationID
     * @return
     */
    public OrganizationInformation queryOrganizationByID(String organizationID) {
        OrganizationInformation info = organizationDao.queryOrganizationByID(organizationID);
        // 添加组织的健康度检查内容
        if (null != info) {
            //循环赋值
            String orgParentID = info.getParentID();
            if (!StringUtil.isEmpty(orgParentID)) {
                getParentInfoByID(info, orgParentID);
                //回填parentID
                info.setParentID(orgParentID);
            }
            //判断只有在组织类型是项目组的时候，再添加健康度和项目下的人员信息
            if(CommonConstant.ORGANZATION_TYPE_PROJECTTEAM.equals( info.getOrganizationType())) {
                // 现在是一个告警类别，如果有其他告警，可以用List封装一下
                info.setHealthCheckInformationList(organizationDao.queryHealthCheckByID(info.getOrganizationID(),
                        CommonConstant.HUAWEI_LEVEL_HEALTH_CHECK_TYPE));
                info.setEmployeeInformationList(
                        employeeService.queryByOrganizationID(info.getOrganizationID(), info.getOrganizationType()));
            }
        }
        return info;
    }
    /**
     * 根据parentID获取上一级的信息
     * 设置CU、BU、DU的值
     *
     * @param info
     * @return
     */
    public void getParentInfoByID(OrganizationInformation info, String parentID) {
        OrganizationInformation parentInfo = organizationDao.queryOrganizationByID(info.getParentID());
        String[] orgType = {CommonConstant.ORGANZATION_TYPE_CU, CommonConstant.ORGANZATION_TYPE_BU, CommonConstant.ORGANZATION_TYPE_BD};
        for (int i = 0; i < orgType.length; i++) {
            if (!parentID.equals(info.getParentID())) {
                parentInfo = organizationDao.queryOrganizationByID(info.getParentID());
            }
            if (CommonConstant.ORGANZATION_TYPE_BD.equals(parentInfo.getOrganizationType())) {
                info.setBD(parentInfo.getOrganizationID());
                info.setBDName(parentInfo.getOrganizationName());
                break;
            }
            if (CommonConstant.ORGANZATION_TYPE_BU.equals(parentInfo.getOrganizationType())) {
                info.setBU(parentInfo.getOrganizationID());
                info.setBUName(parentInfo.getOrganizationName());
                info.setParentID(parentInfo.getParentID());
            }
            if (CommonConstant.ORGANZATION_TYPE_CU.equals(parentInfo.getOrganizationType())) {
                info.setCU(parentInfo.getOrganizationID());
                info.setCUName(parentInfo.getOrganizationName());
                info.setParentID(parentInfo.getParentID());
            }
        }
    }
    /**
     * 根据ID获取其下边的子节点信息
     *
     * @param organizationID
     * @return
     */
    public List<OrganizationInformation> queryChildsByID(String organizationID) {
        return organizationDao.queryChildsByID(organizationID);
    }
    /**
     * 获取项目组或部门的健康度分布信息
     *
     * @param organizationID
     * @return
     */
    public List<HealthCheckEntity> queryHealthCheckByID(String organizationID) {
        List<HealthCheckEntity> healthCheckEntityList = null;
        // 先查询一次组织信息，主要是获取是否有自定义规则
        OrganizationInformation info = queryOrganizationByID(organizationID);
        if (null == info || !StringUtil.checkOrganizationType(info.getOrganizationType())) {
            return healthCheckEntityList;
        }
        healthCheckEntityList = new ArrayList<HealthCheckEntity>();
        HealthCheckEntity healthCheckEntity = null;
        // 部门的信息处理
        if (CommonConstant.ORGANZATION_TYPE_PROJECTTEAM.equals(info.getOrganizationType())) {
            // 获取单个项目组的健康度
            healthCheckEntity = getProjectHealthCheckInfo(organizationID);
            if (null != healthCheckEntity) {
                healthCheckEntityList.add(healthCheckEntity);
            }
        } else {
            List<OrganizationInformation> informations = getChildOrgInfo(organizationID);
            for (OrganizationInformation information : informations) {
                healthCheckEntity = getProjectHealthCheckInfo(information.getOrganizationID());
                if (null != healthCheckEntity) {
                    healthCheckEntityList.add(healthCheckEntity);
                }
            }
        }

        return healthCheckEntityList;
    }
    /**
     * 获取单个项目组的健康信息
     *
     * @param organizationID
     * @return
     */
    private HealthCheckEntity getProjectHealthCheckInfo(String organizationID) {

        HealthCheckEntity healthCheckEntity = null;
        // 查询组织的基本信息
        OrganizationInformation info = queryOrganizationByID(organizationID);
        // 如果没有自定义规则则直接退出
        if (null == info || CollectionUtils.isEmpty(info.getHealthCheckInformationList())) {
            return healthCheckEntity;
        }
        List<ScreenMapEntity> screenMapEntityList = screenMapService.getHuaweiLevelDistribution(organizationID,
                info.getOrganizationType());
        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return healthCheckEntity;
        }
        healthCheckEntity = new HealthCheckEntity();
        healthCheckEntity.setOrganizationID(organizationID);
        healthCheckEntity.setOrganizationName(info.getOrganizationName());
        healthCheckEntity.setRealList(screenMapEntityList);
        // 查询组织的自定义规则信息
        List<HealthCheckInformation> checkInformationList = info.getHealthCheckInformationList();
        // 查询系统配置的转换规则
        List<SystemConfigInformation> systemConfigInformationList = systemConfigDao
                .queryConfigByType(CommonConstant.HUAWEI_LEVEL_HEALTH_CHECK_TYPE);
        // 转换成可以方便查询的Map类型
        Map<String, String> configMap = systemConfigInformationList.stream().collect(
                Collectors.toMap(SystemConfigInformation::getConfigName, SystemConfigInformation::getConfigValue));
        // 健康度字段，默认为健康
        String health = CommonConstant.STRING_HEALTH;
        // 如果有自定义信息则走自定义信息，不再走默认的信息了，Modify On 20190521 修改为全部要走自定义，没有默认规则
        Map<String, Integer> healthMap = screenMapEntityList.stream()
                .collect(Collectors.toMap(ScreenMapEntity::getName, ScreenMapEntity::getValue));
        List<ScreenMapEntity> healthList = new ArrayList<ScreenMapEntity>();
        for (HealthCheckInformation information : checkInformationList) {
            ScreenMapEntity entity = new ScreenMapEntity();
            entity.setName(information.getRuleName());
            entity.setValue(Integer.parseInt(information.getRuleValue()));
            if (null != healthMap.get(information.getRuleName())
                    && Integer.parseInt(information.getRuleValue()) != healthMap.get(information.getRuleName())) {
                health = CommonConstant.STRING_UNHEALTH;
            }
            healthList.add(entity);
        }
        healthCheckEntity.setHealthList(healthList);
        healthCheckEntity.setHealthResult(health);

        return healthCheckEntity;
    }
    /**
     * 递归获取项目组信息
     *
     * @param organizationID
     * @return
     */
    public List<OrganizationInformation> getChildOrgInfo(String organizationID) {
        List<OrganizationInformation> retList = new ArrayList<OrganizationInformation>();
        List<OrganizationInformation> informationList = queryChildsByID(organizationID);
        for (OrganizationInformation information : informationList) {
            if (CommonConstant.ORGANZATION_TYPE_PROJECTTEAM.equals(information.getOrganizationType())) {
                retList.add(information);
            } else {
                retList.addAll(getChildOrgInfo(information.getOrganizationID()));
            }
        }
        return retList;
    }
    @Override
    public String importExcelOrganization(MultipartFile file) throws Exception {
        List<OrganizationInformation> list = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        try {
            OrganizationInformation vo = null;
            InputStream in = null;
            List<List<Object>> listob = null;
            in = file.getInputStream();
            /**
             * 获取excl表中的值
             */
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename(),0);
            in.close();
            for (int j = 0; j < listob.size(); j++) {
                vo = new OrganizationInformation();
                if (StringUtil.isEmpty(String.valueOf(listob.get(j).get(0)))) {
                    vo.setOrganizationID(UUID.randomUUID().toString().replaceAll("-", ""));
                } else {

                    vo.setOrganizationID(String.valueOf(listob.get(j).get(0)));
                }
                vo.setContractID(String.valueOf(listob.get(j).get(1)));
                vo.setOrganizationName(String.valueOf(listob.get(j).get(2)));
                vo.setOrganizationStatus(String.valueOf(listob.get(j).get(3)));
                vo.setOrganizationLevel(String.valueOf(listob.get(j).get(4)));
                vo.setOrganizationMaturity(String.valueOf(listob.get(j).get(5)));
                vo.setOrganizationType(String.valueOf(listob.get(j).get(6)));
                vo.setParentID(String.valueOf(listob.get(j).get(7)));
                vo.setProjectType(String.valueOf(listob.get(j).get(8)));
                vo.setOfficeSpace(String.valueOf(listob.get(j).get(9)));
                vo.setCooperationModel(String.valueOf(listob.get(j).get(10)));
                vo.setSkill(String.valueOf(listob.get(j).get(11)));
                vo.setCreateDate(String.valueOf(listob.get(j).get(12)));
                vo.setCostCenter(String.valueOf(listob.get(j).get(13)));
                vo.setLeader(ConversionUtils.trimPoint(String.valueOf(listob.get(j).get(14))).toString());
                vo.setArea(String.valueOf(listob.get(j).get(15)));
                vo.setBusinessLine(String.valueOf(listob.get(j).get(16)));
                vo.setBU(String.valueOf(listob.get(j).get(17)));
                vo.setBD(String.valueOf(listob.get(j).get(18)));
                vo.setCU(String.valueOf(listob.get(j).get(19)));
                vo.setPDU(String.valueOf(listob.get(j).get(20)));
                vo.setPO(String.valueOf(listob.get(j).get(21)));
                vo.setExistenceValue(String.valueOf(listob.get(j).get(22)));
                vo.setPlanningScale(String.valueOf(listob.get(j).get(23)));
                vo.setIsBU(String.valueOf(listob.get(j).get(24)));
                vo.setImgURL(loadImg(String.valueOf(listob.get(j).get(25)), "organizationimg"));
                vo.setOrganizationAlias(String.valueOf(listob.get(j).get(26)));
                vo.setContractStatus(String.valueOf(listob.get(j).get(27)));
                vo.setScheduledContractDate(ConversionUtils.dateChange(String.valueOf(listob.get(j).get(28)), CommonConstant.DATAFORMATTER));
                vo.setScheduledStartDate(ConversionUtils.dateChange(String.valueOf(listob.get(j).get(29)), CommonConstant.DATAFORMATTER));
                vo.setScheduledEndDate(ConversionUtils.dateChange(String.valueOf(listob.get(j).get(30)), CommonConstant.DATAFORMATTER));
                vo.setPostProjectDate(ConversionUtils.dateChange(String.valueOf(listob.get(j).get(31)), CommonConstant.DATAFORMATTER));
                st = this.checkImportExcl(vo, j);
                list.add(vo);
            }
            if (st.length() > 0) {
                return st.toString();
            }
            int result = organizationDao.importExcelOrganization(list);
            if (result == 0) {
                st.append("新增到数据库异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
            st.append("excl导入新增异常");
        }
        return st.toString();
    }
    @Override
    public List<OrganizationTreeVO> getTreeOrganization(String organizationID, String treeType) {
        List<OrganizationTreeVO> newList = new ArrayList<>();
        List<OrganizationInformation> list = new ArrayList<>();
        List<OrganizationInformation> list1 = new ArrayList<>();
        List<OrganizationInformation> cuInfoList = new ArrayList<>();
        try {
            if (treeType.equals("organizationTree")) {
                list = organizationDao.getTreeOrganization();
            } else if (treeType.equals("skillTree")) {
                list = organizationDao.getTreeOrganizationSkill();
            }
            if ((!StringUtil.isEmpty(organizationID)) && (!"null".equals(organizationID))) {
                OrganizationInformation organ = organizationDao.queryOrganizationByID(organizationID);
                List<String> orgConversion = new ArrayList<>();
                if ("CU".equals(organ.getOrganizationType())) {
                	cuInfoList = 
                			organizationDao.getCuInfoList(organizationID);
                	for (OrganizationInformation org : cuInfoList) {
                		orgConversion.add(org.getOrganizationID());
					}
                } else {
                    orgConversion.add(organ.getOrganizationID());
                }
                List<OrganizationInformation> parList = this.getparent(list, orgConversion.get(0), 0);
                List<OrganizationInformation> childList = new ArrayList<>();
                for (String str : orgConversion) {
                	parList.addAll(this.getparent(list, str, 0));
                	parList = this.removeDuplicate(parList);
                	childList.addAll(this.getChild(str, list, list1));
				}
                list.clear();
                list.addAll(parList);
                list.addAll(childList);
            } else {
                return newList;
            }
            if (!list.isEmpty()) {
                newList = this.constructTree(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return newList;
        }
        return newList;
    }
    /**
     * 校验excl数值
     *
     * @param
     * @return
     */
    private StringBuilder checkImportExcl(OrganizationInformation vo, int i) {
        StringBuilder stb = new StringBuilder();
        if ((!StringUtil.isEmpty(vo.getOrganizationID())) && vo.getOrganizationID().length() > 32) {
            stb.append("第" + i + "行,组织编号长度为32，实际为" + vo.getOrganizationID().length());
        } else if ((!StringUtil.isEmpty(vo.getContractID())) && vo.getContractID().length() > 32) {
            stb.append("第" + i + "行,组织合同ID为32，实际为" + vo.getContractID().length());
        } else if ((!StringUtil.isEmpty(vo.getOrganizationName())) && vo.getOrganizationName().length() > 128) {
            stb.append("第" + i + "行,组织编号名称为128，实际为" + vo.getOrganizationName().length());
        } else if ((!StringUtil.isEmpty(vo.getOrganizationStatus())) && vo.getOrganizationStatus().length() > 32) {
            stb.append("第" + i + "行,组织状态长度为32，实际为" + vo.getOrganizationStatus().length());
        } else if ((!StringUtil.isEmpty(vo.getOrganizationLevel())) && vo.getOrganizationLevel().length() > 8) {
            stb.append("第" + i + "行,组织级别长度为8，实际为" + vo.getOrganizationLevel().length());
        } else if ((!StringUtil.isEmpty(vo.getOrganizationMaturity())) && vo.getOrganizationMaturity().length() > 64) {
            stb.append("第" + i + "行,项目成熟度长度为64，实际为" + vo.getOrganizationMaturity().length());
        } else if ((!StringUtil.isEmpty(vo.getOrganizationType())) && vo.getOrganizationType().length() > 16) {
            stb.append("第" + i + "行,组织类别长度为16，实际为" + vo.getOrganizationType().length());
        } else if ((!StringUtil.isEmpty(vo.getParentID())) && vo.getParentID().length() > 32) {
            stb.append("第" + i + "行,父级长度为32，实际为" + vo.getParentID().length());
        } else if ((!StringUtil.isEmpty(vo.getProjectType())) && vo.getProjectType().length() > 64) {
            stb.append("第" + i + "行,项目类型长度为64，实际为" + vo.getProjectType().length());
        } else if ((!StringUtil.isEmpty(vo.getOfficeSpace())) && vo.getOfficeSpace().length() > 128) {
            stb.append("第" + i + "行,办公场地长度为128，实际为" + vo.getOfficeSpace().length());
        } else if ((!StringUtil.isEmpty(vo.getCooperationModel())) && vo.getCooperationModel().length() > 32) {
            stb.append("第" + i + "行,合作模式长度为32，实际为" + vo.getCooperationModel().length());
        } else if ((!StringUtil.isEmpty(vo.getSkill())) && vo.getSkill().length() > 64) {
            stb.append("第" + i + "行,技能长度为64，实际为" + vo.getSkill().length());
        } else if ((!StringUtil.isEmpty(vo.getCostCenter())) && vo.getCostCenter().length() > 32) {
            stb.append("第" + i + "行,成本中心长度为32，实际为" + vo.getCostCenter().length());
        } else if ((!StringUtil.isEmpty(vo.getLeader())) && vo.getLeader().length() > 32) {
            stb.append("第" + i + "行,负责人软通账号长度为32，实际为" + vo.getLeader().length());
        } else if ((!StringUtil.isEmpty(vo.getArea())) && vo.getArea().length() > 16) {
            stb.append("第" + i + "行,工作区域长度为16，实际为" + vo.getArea().length());
        } else if ((!StringUtil.isEmpty(vo.getBusinessLine())) && vo.getBusinessLine().length() > 16) {
            stb.append("第" + i + 1 + "行,业务线长度为16，实际为" + vo.getBusinessLine().length());
        } else if ((!StringUtil.isEmpty(vo.getBU())) && vo.getBU().length() > 16) {
            stb.append("第" + i + 1 + "行,BU长度为16，实际为" + vo.getBU().length());
        } else if ((!StringUtil.isEmpty(vo.getBD())) && vo.getBD().length() > 16) {
            stb.append("第" + i + 1 + "行,BD长度为16，实际为" + vo.getBD().length());
        } else if ((!StringUtil.isEmpty(vo.getCU())) && vo.getCU().length() > 16) {
            stb.append("第" + i + "行,DU长度为16，实际为" + vo.getCU().length());
        } else if ((!StringUtil.isEmpty(vo.getPDU())) && vo.getPDU().length() > 32) {
            stb.append("第" + i + "行,PDU长度为32，实际为" + vo.getPDU().length());
        } else if ((!StringUtil.isEmpty(vo.getExistenceValue())) && vo.getExistenceValue().length() > 32) {
            stb.append("第" + i + "行,存在价值长度为32，实际为" + vo.getExistenceValue().length());
        } else if ((!StringUtil.isEmpty(vo.getPlanningScale())) && vo.getPlanningScale().length() > 8) {
            stb.append("第" + i + "行,规划人员规模长度为8，实际为" + vo.getPlanningScale().length());
        } else if ((!StringUtil.isEmpty(vo.getIsBU())) && vo.getIsBU().length() > 1) {
            stb.append("第" + i + "行,是否部门BU长度为1，实际为" + vo.getIsBU().length());
        }
        return stb;
    }
    /**
     * 构造树
     *
     * @param listOrgan
     * @return
     */
    private List<OrganizationTreeVO> constructTree(List<OrganizationInformation> listOrgan) {
        List<OrganizationTreeVO> list1 = new ArrayList<>();
        List<OrganizationTreeVO> list;

        OrganizationTreeVO organizationTreeVO = null;
        for (OrganizationInformation organization : listOrgan) {
            organizationTreeVO = new OrganizationTreeVO();
            organizationTreeVO.setId(organization.getOrganizationID());
            organizationTreeVO.setParentId(organization.getParentID());
            organizationTreeVO.setOrganizationName(organization.getOrganizationName());
            organizationTreeVO.setTitle(organization.getOrganizationName());
            organizationTreeVO.setIsBU(organization.getIsBU());
            organizationTreeVO.setIsAccording(organization.getIsAccording());
            organizationTreeVO.setOrganizationType(organization.getOrganizationType());
            list1.add(organizationTreeVO);
        }
        list = TreeUtils.getTree(list1);
        return list;
    }
    /**
     * 递归得到父节点
     *
     * @param listOrgan
     * @param organizationID
     * @return
     */
    private List<OrganizationInformation> getparent(List<OrganizationInformation> listOrgan, String organizationID, int i) {
        List<OrganizationInformation> orgList = new ArrayList<>();
        String parid = "";
        for (OrganizationInformation org : listOrgan) {
            if (organizationID.equals(org.getOrganizationID())) {
                if (++i > 1) {
                    org.setIsAccording(false);
                } else {
                    org.setIsAccording(true);
                }
                orgList.add(org);
                if (!StringUtil.isEmpty(org.getParentID())) {
                    parid = org.getParentID();
                } else {
                    return orgList;
                }
            }
        }
        orgList.addAll((getparent(listOrgan, parid, i)));
        return orgList;
    }
    /**
     * 递归得到子节点
     *
     * @param parentId
     * @param orgList
     * @return
     */
    private List<OrganizationInformation> getChild(String parentId, List<OrganizationInformation> orgList,
                                                   List<OrganizationInformation> list) {
        for (OrganizationInformation org : orgList) {
            // 遍历出父id等于参数的id，add进子节点集合
            if (parentId.equals(org.getParentID())) {
                org.setIsAccording(true);
                list.add(org);
                // 递归遍历下一级
                getChild(org.getOrganizationID(), orgList, list);
            }
        }
        return list;
    }
    @Override
    public void loadExclOrganization(HttpServletResponse response, HttpServletRequest request, String employeeID) throws IOException {
        OutputStream outp = null;
        FileInputStream in = null;
        XSSFWorkbook workbook = null;
        HSSFSheet sheet = null;
        try {
            String fileName = "Excel_Organization.xlsx"; // 要下载的模板文件
            String ctxPath = System.getProperty(CommonConstant.USER_DIR) + "/src/main/resources/templates/";
            String filedownload = ctxPath + fileName;
            fileName = URLEncoder.encode(fileName, "UTF-8");
            // 要下载的模板所在的绝对路径
            OrganizationInformation or = organizationDao.getParentId(employeeID);
            workbook = new XSSFWorkbook(new FileInputStream(filedownload));
            //获取第一个sheet
            workbook.getSheetAt(0).createRow(1).createCell(7).setCellValue(or.getOrganizationID());
            response.reset();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
            in = new FileInputStream(filedownload);
            outp = response.getOutputStream();
            workbook.write(outp);
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = in.read(b)) > 0) {
                outp.write(b, 0, i);
            }
            outp.flush();

        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            if (in != null) {
                in.close();
                in = null;
            }
            if (outp != null) {
                outp.close();
                outp = null;
            }
        }

    }
    /**
     * 图片下载
     *
     * @param url
     * @param module
     * @return
     * @throws IOException
     */
    public static String loadImg(String url, String module) throws IOException {
        String savePath = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String savePathImg = null;
        try {
            File file = new File(url);
            if (!file.exists()) {
                return "";
            }
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int len = 0;
            savePathImg = "http:\\10.61.180.52:8180" + module + "\\" + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
            savePath = savePathImg;

            fos = new FileOutputStream(savePath);


            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
        } catch (Exception e) {
            return "";
        } finally {
            if (null != fos) {
                fos.close();
                fos = null;
            }
            if (null != fis) {
                fis.close();
                fis = null;
            }
        }
        return savePathImg;
    }
    @Override
    public List<OrganizationInformation> toObtainBU(String organizationID) {
        return organizationDao.toObtainBU(organizationID);
    }
    @Override
    public String getOrganizationID(String employeeID) {
        return organizationDao.getOrganizationID(employeeID);
    }
    @Override
    public Map<String, Object> addOrganization(OrganizationInformation organizationInfo) {
        Map<String, Object> map = new HashMap<>();
        boolean flag = false;
        try {
            int result = organizationDao.addOrganizationInfo(organizationInfo);
            if (result == 0) {
                map.put(CommonConstant.RETURN_STATUS, flag);
                map.put(CommonConstant.RETURN_MESSAGE, "新增失败");
                return map;
            }
            flag = this.addListCheck(organizationInfo.getHealthCheckInformationList());
            map.put(CommonConstant.RETURN_STATUS, flag);
            map.put(CommonConstant.RETURN_MESSAGE, "新增成功");
        } catch (Exception e) {
            logger.error(e.toString());
            map.put(CommonConstant.RETURN_STATUS, flag);
            map.put(CommonConstant.RETURN_MESSAGE, e.toString());
        }
        return map;
    }
    @Override
    public String addCheckOrg(OrganizationInformation organizationInfo) {
        String returnstr = "";
        int result = 0;

        if (!StringUtil.isEmpty(organizationInfo.getOrganizationID())) {
            result = organizationDao.checkOrg(organizationInfo.getOrganizationID());
            if (result > 0) {
                returnstr = "该组织已存在";
                return returnstr;
            }
        }
        if (!StringUtil.isEmpty(organizationInfo.getOrganizationName())) {
            result = organizationDao.checkOrgName(organizationInfo.getOrganizationName());
            if (result > 0) {
                returnstr = "该组织名已存在";
                return returnstr;
            }
        }
        return returnstr;
    }
    @Override
    public List<OrganizationInfoVO> queryOrgInforList(String name) {
        return organizationDao.queryOrgInforList(name);
    }
    @Override
    public List<QueryLeaderVO> queryLeaderList(String name) {
        return organizationDao.queryLeaderList(name);
    }

    @Override
    public List<SystemConfigInformation> queryConfig(String configType) {
        return systemConfigDao.queryConfigByType(configType);
    }
    @Override
    @Transactional
    public Map<String, Object> updateOrganization(OrganizationUpdatePersonVO organizationInfo) {
        Map<String, Object> map = new HashMap<>();
        boolean flag = false;
        try {
            if (organizationInfo.getUpdateType().equals("updateProject")) {
                flag = this.addListCheck(organizationInfo.getOrganizationInfo().getHealthCheckInformationList());
                int result = organizationDao.updateOrganization(organizationInfo.getOrganizationInfo());
                if (result > 0) {
                    flag = true;
                    map.put(CommonConstant.RETURN_STATUS, flag);
                    map.put(CommonConstant.RETURN_MESSAGE, "修改成功");
                }
            } else if (organizationInfo.getUpdateType().equals("updatePerson") && (!organizationInfo.getPersonList().isEmpty())) {
                int result = organizationDao.updateProjectPerson(organizationInfo.getPersonList());
                if (result > 0) {
                    flag = true;
                    map.put(CommonConstant.RETURN_STATUS, flag);
                    map.put(CommonConstant.RETURN_MESSAGE, "修改成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            map.put(CommonConstant.RETURN_STATUS, flag);
            map.put(CommonConstant.RETURN_MESSAGE, e.toString());
        }
        return map;
    }
    /**
     * 新增健康度信息
     *
     * @param listCheck1
     * @return
     */
    private boolean addListCheck(List<HealthCheckInformation> listCheck1) {
        List<HealthCheckInformation> listAdd = new ArrayList<>();
        List<HealthCheckInformation> listUpdate = new ArrayList<>();
        boolean flag = false;
        int judge = 0;
        for (HealthCheckInformation healthInfo : listCheck1) {
            int result = organizationDao.healthCheckByID(healthInfo.getOrganizationID(),
                    healthInfo.getRuleType(), healthInfo.getRuleName());
            if (result == 0) {
                listAdd.add(healthInfo);
                continue;
            }
            listUpdate.add(healthInfo);
        }
        if (!listUpdate.isEmpty()) {
            List<HealthCheckInformation> listCheck = listUpdate;
            judge = organizationDao.updateHealthCheckInfor(listCheck);
            if (judge == 0) {
                return flag;
            }
        }
        if (!listAdd.isEmpty()) {
            List<HealthCheckInformation> listCheck = listAdd;
            judge = organizationDao.addHealthCheckInfor(listCheck);
            if (judge == 0) {
                return flag;
            }
        }
        flag = true;
        return flag;
    }
    @Override
    @Transactional
    public Map<String, Object> addProjectPO(OrganizationInformation organizationInfo) {
        boolean flag = false;
        Map<String, Object> map = new HashMap<>();
        try {
            OrganizationInformation poInfo =
                    organizationDao.getPoInfoByLeader(organizationInfo.getLeader(), "", organizationInfo.getParentID());
            if (null != poInfo) {
                map.put(CommonConstant.RETURN_STATUS, flag);
                map.put(CommonConstant.RETURN_MESSAGE, "该PO分组已存在");
                return map;
            }
            String organizationID = "po" + ConversionUtils.getRandomNum();
            organizationInfo.setOrganizationID(organizationID);
            organizationInfo.setOrganizationType("PO");
            int result = organizationDao.addOrganizationInfo(organizationInfo);
            if (result == 0) {
                map.put(CommonConstant.RETURN_STATUS, flag);
                map.put(CommonConstant.RETURN_MESSAGE, "新增失败");
                return map;
            }
            if (!organizationInfo.getProjectIds().isEmpty()) {
                organizationInfo.setPO(organizationID);
                result = organizationDao.updateProjectPO(organizationInfo);
                if (result == 0) {
                    map.put(CommonConstant.RETURN_STATUS, flag);
                    map.put(CommonConstant.RETURN_MESSAGE, "修改项目组po失败");
                    return map;
                }
            }
            flag = true;
            map.put(CommonConstant.RETURN_STATUS, flag);
            map.put(CommonConstant.RETURN_MESSAGE, "新增po组织成功");
        } catch (Exception e) {
            logger.error(e.toString());
            map.put(CommonConstant.RETURN_STATUS, flag);
            map.put(CommonConstant.RETURN_MESSAGE, "修改项目组po失败");
            throw e;
        }
        return map;
    }
    @Override
    public List<OrganizationInformation> queryProjectPO(String organizationID, String queryType, String organizationStatus) {
        List<OrganizationInformation> orgList = new ArrayList<>();
        if (queryType.equals("PO")) {
            orgList = organizationDao.queryProjectPO(organizationID);
        } else if (queryType.equals("leader")) {
            orgList = organizationDao.queryProjectLeader(organizationID, organizationStatus);
        }
        return orgList;
    }
    @Override
    public PageInfo<EmployeeBackups> queryEmployeeBackups(Integer page, Integer pageSize, String leader) {
        logger.info("----------查询人员备份信息service接入参数------{}，{},{}", page, pageSize, leader);
        PageInfo<EmployeeBackups> employeeBackupsPageInfo = new PageInfo<>();
        try {
            PageHelper.startPage(page, pageSize);
            List<EmployeeBackups> employeeBackups = organizationDao.queryEmployeeBackups(leader);
            if (employeeBackups != null && employeeBackups.size() > 0) {
                employeeBackupsPageInfo = new PageInfo<>(employeeBackups);
            }
        } catch (Exception e) {
            logger.error("- - - 查询人员备份信息异常- - -", e);
        }
        logger.info("----------查询人员备份信息service返回参数------{}", employeeBackupsPageInfo);
        return employeeBackupsPageInfo;
    }
    @Override
    public List<SysConfigResponse> queryBackupName() {
        List<SysConfigResponse> list = new ArrayList<>();
        try {
            list = organizationDao.queryBackupName();


        } catch (Exception e) {
            logger.error("- - - 查询查询备份类型的信息异常- - -", e);
        }

        return list;
    }
    @Override
    public List<QuerySkillProjectVO> querySkillMessage(String organizationGroupId, String skill, String leader) {
        List<QuerySkillProjectVO> listSkillProject = new ArrayList<>();
        try {
            listSkillProject =
                    organizationDao.querySkillMessage(organizationGroupId, skill, leader);
            if (!listSkillProject.isEmpty()) {
                for (QuerySkillProjectVO querySkill : listSkillProject) {
                    querySkill.setEmpList(organizationDao.queryempList(querySkill.getOrganizationId(),
                            querySkill.getSkill()));
                }
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return listSkillProject;
    }
    @Override
    public Map<String, Object> updateProjectPO(OrganizationInformation organizationInfo) {
        boolean flag = false;
        Map<String, Object> map = new HashMap<>();
        try {
            //查询是否po修改是否修改了其leader
            OrganizationInformation poInfo =
                    organizationDao.getPoInfoByLeader(organizationInfo.getLeader(), organizationInfo.getOrganizationID(), organizationInfo.getParentID());
            //leader信息已经修改
            if (null == poInfo) {
                flag = this.updatePo(organizationInfo);
                if (!flag) {
                    map.put(CommonConstant.RETURN_STATUS, flag);
                    map.put(CommonConstant.RETURN_MESSAGE, "修改失败");
                    return map;
                }
                map.put(CommonConstant.RETURN_STATUS, flag);
                map.put(CommonConstant.RETURN_MESSAGE, "修改成功");
                return map;
            }
            //leader信息未修改
            int result = organizationDao.updateOrganization(organizationInfo);
            if (result == 0) {
                map.put(CommonConstant.RETURN_STATUS, flag);
                map.put(CommonConstant.RETURN_MESSAGE, "修改失败");
                return map;
            }
            if (!organizationInfo.getProjectIds().isEmpty()) {
                organizationInfo.setPO(organizationInfo.getOrganizationID());
                result = organizationDao.updateProjectPO(organizationInfo);
                if (result == 0) {
                    map.put(CommonConstant.RETURN_STATUS, flag);
                    map.put(CommonConstant.RETURN_MESSAGE, "修改项目组po失败");
                    return map;
                }
            }
            flag = true;
            map.put(CommonConstant.RETURN_STATUS, flag);
            map.put(CommonConstant.RETURN_MESSAGE, "新增po组织成功");
        } catch (Exception e) {
            logger.error(e.toString());
            map.put(CommonConstant.RETURN_STATUS, flag);
            map.put(CommonConstant.RETURN_MESSAGE, "修改项目组po失败");
            throw e;
        }
        return map;
    }
    @Override
    public QueryProjectPoVO queryProjectPOInfo(String organizationID) {
        QueryProjectPoVO queryPro = new QueryProjectPoVO();
        OrganizationInformation orgInfo =
                organizationDao.queryOrganizationByID(organizationID);
        if (null != orgInfo) {
            queryPro.setOrganizationID(orgInfo.getOrganizationID());
            queryPro.setOrganizationName(orgInfo.getOrganizationName());
            queryPro.setOrganizationType(orgInfo.getOrganizationType());
            queryPro.setBD(orgInfo.getBD());
            queryPro.setBU(orgInfo.getBU());
            queryPro.setBDName(orgInfo.getBDName());
            queryPro.setBUName(orgInfo.getBUName());
            queryPro.setPDU(orgInfo.getPDU());
            queryPro.setPDUName(orgInfo.getPDUName());
            queryPro.setExistenceValue(orgInfo.getExistenceValue());
            queryPro.setParentID(orgInfo.getParentID());
            queryPro.setParentName(orgInfo.getParentName());
            queryPro.setLeader(orgInfo.getLeader());
            queryPro.setLeaderName(orgInfo.getLeaderName());
            queryPro.setOrgInfoList(organizationDao.queryPOProjectInfo(organizationID));
        }
        return queryPro;
    }
    @Override
    public Result addEmployeeBackups(EmployeeBackups employeeBackups) {
        logger.info("----------新增备份人员接入参数------{}", employeeBackups);
        try {
            employeeBackups.setCreateDate(new Date());
            //根据pm获取cu组织
            String pm = employeeBackups.getPm();
            String cuValue = organizationDao.queryCUBypm(Integer.parseInt(pm));
            employeeBackups.setCU(cuValue);
            organizationDao.addEmployeeBackups(employeeBackups);
            organizationDao.addEmployeeBackupsHistory(employeeBackups);
            return new Result(true, "新增备份人员成功");
        } catch (Exception e) {
            logger.error("-----------新增备份人员异常--------", e);

            return new Result(false, "新增备份人员失败");
        }
    }
    @Override
    public Result updateEmployeeBackups(EmployeeBackups employeeBackups) {
        try {
            employeeBackups.setUpdateDate(new Date());
            String pm = employeeBackups.getPm();
            String cuValue = organizationDao.queryCUBypm(Integer.parseInt(pm));
            employeeBackups.setCU(cuValue);
            organizationDao.updateEmployeeBackups(employeeBackups);
            organizationDao.updateEmployeeBackupsHistory(employeeBackups);
            return new Result(true, "更新备份人员成功");
        } catch (Exception e) {
            logger.error("-----------更新备份人员异常--------", e);
            return new Result(false, "更新备份人员失败");
        }
    }
    @Override
    public List<QueryCuheadResponse> queryCuHeadList() {
        logger.info("- - -查询CuHead下拉框列表service - - -");
        List<QueryCuheadResponse> cuHeadList = null;
        try {
            cuHeadList = organizationDao.queryCuHeadList();
        } catch (Exception e) {
            logger.error("- -- -查询CuHead下拉框列表异常 - - -", e);
        }
        logger.info("- - -查询CuHead下拉框列表的返回结果 - - -{}", cuHeadList);
        return cuHeadList;
    }
    @Override
    public List<OrganizationInformation> queryCuOrg(String organizationID) {
        List<OrganizationInformation> projectInfos = null;
        try {
            projectInfos = organizationDao.queryOrg(organizationID);
        } catch (Exception e) {
            logger.error("- - -查询cu下面的项目组信息异常 - - -", e);
        }
        return projectInfos;
    }
    @Override
    public List<QueryProgressResponse> queryProjectProgress(String organizationID, String organizationType) throws Exception {
        logger.info("- - -查询项目进度的接入参数 - - -{}，{}", organizationID, organizationType);
        ArrayList<QueryProgressResponse> arrayList = new ArrayList<>();
        //BD下面的所有CU的项目进度
        if (organizationType.equals(CommonConstant.ORGANZATION_TYPE_BD)) {
            List<OrganizationInformation> bUorgList = organizationDao.queryChildsByID(organizationID);
            if (bUorgList != null && bUorgList.size() > 0) {
                for (OrganizationInformation buOrg : bUorgList) {
                    String buOrgOrganizationID = buOrg.getOrganizationID();
                    List<OrganizationInformation> cuOrgList = organizationDao.queryChildsByID(buOrgOrganizationID);
                    if (cuOrgList != null && cuOrgList.size() > 0) {
                        for (OrganizationInformation cuOrg : cuOrgList) {
                            String cuOrgOrganizationID = cuOrg.getOrganizationID();
                            String organizationName = cuOrg.getOrganizationName();
                            List<EmployeeBackups> employeeBackups = organizationDao.queryBackupDetail(cuOrgOrganizationID);
                            String progress = null;
                            progress = organizationDao.queryCuProgress(cuOrgOrganizationID);
                            if (!StringUtils.isEmpty(progress)) {
                                double aDouble = Double.parseDouble(progress);
                                DecimalFormat df = new DecimalFormat("######0.00");
                                String percentProgress = df.format(aDouble);
                                QueryProgressResponse queryProgressResponse = new QueryProgressResponse();
                                queryProgressResponse.setName(organizationName);
                                queryProgressResponse.setValue(percentProgress);
                                queryProgressResponse.setList(employeeBackups);
                                arrayList.add(queryProgressResponse);
                            }
                        }
                    }
                }
            }
            //排序
            List<QueryProgressResponse> collect = arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            return collect;
        }
        //BU下面所有CU的项目进度
        if (organizationType.equals(CommonConstant.ORGANZATION_TYPE_BU)) {
            List<OrganizationInformation> cuOrgList = organizationDao.queryChildsByID(organizationID);
            if (cuOrgList != null && cuOrgList.size() > 0) {
                for (OrganizationInformation cuOrg : cuOrgList) {
                    String cuOrgOrganizationID = cuOrg.getOrganizationID();
                    String organizationName = cuOrg.getOrganizationName();
                    String progress = organizationDao.queryCuProgress(cuOrgOrganizationID);
                    List<EmployeeBackups> employeeBackups = organizationDao.queryBackupDetail(cuOrgOrganizationID);
                    if (!StringUtils.isEmpty(progress)) {
                        double aDouble = Double.parseDouble(progress);
                        DecimalFormat df = new DecimalFormat("######0.00");
                        String percentProgress = df.format(aDouble);
                        QueryProgressResponse queryProgressResponse = new QueryProgressResponse();
                        queryProgressResponse.setName(organizationName);
                        queryProgressResponse.setValue(percentProgress);
                        queryProgressResponse.setList(employeeBackups);
                        arrayList.add(queryProgressResponse);
                    }

                }
            }
            List<QueryProgressResponse> collect = arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            return collect;
        }
        //CU下面所有项目的项目进度
        if (organizationType.equals(CommonConstant.ORGANZATION_TYPE_CU)) {
            List<OrganizationInformation> retList = new ArrayList<OrganizationInformation>();
            List<OrganizationInformation> informationList = queryChildsByID(organizationID);
            for (OrganizationInformation information : informationList) {
                if (CommonConstant.ORGANZATION_TYPE_PROJECTTEAM.equals(information.getOrganizationType())) {
                    retList.add(information);
                } else {
                    retList.addAll(getChildOrgInfo(information.getOrganizationID()));
                }
            }
            // List<OrganizationInformation> list = organizationDao.queryOrg(organizationID);

            if (retList != null && retList.size() > 0) {
                for (OrganizationInformation organizationInformation : retList) {
                    String organizationName = organizationInformation.getOrganizationName();
                    String informationOrganizationID = organizationInformation.getOrganizationID();
                    String progress = organizationDao.queryProgress(informationOrganizationID);
                    List<EmployeeBackups> employeeBackups=null;
                    if (!StringUtils.isEmpty(informationOrganizationID)) {
                      employeeBackups = organizationDao.queryBackupDetail(informationOrganizationID);
                    }
                    if (!StringUtils.isEmpty(progress)) {
                        double aDouble = Double.parseDouble(progress);
                        DecimalFormat df = new DecimalFormat("######0.00");
                        String percentProgress = df.format(aDouble);
                        QueryProgressResponse queryProgressResponse = new QueryProgressResponse();
                        queryProgressResponse.setName(organizationName);
                        queryProgressResponse.setValue(percentProgress);
                        queryProgressResponse.setList(employeeBackups);
                        arrayList.add(queryProgressResponse);
                    }
                }
            }
            List<QueryProgressResponse> collect = arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            return collect;

        }
        //项目团队下面的所有成员的备份进度
        if (organizationType.equals(CommonConstant.ORGANZATION_TYPE_PROJECTTEAM)) {
            List<EmployeeInformation> employeeInformationList = organizationDao.queryEmp(organizationID);
            for (EmployeeInformation employeeInformation : employeeInformationList) {
                Integer employeeID = employeeInformation.getEmployeeID();
                String employeeName = employeeInformation.getEmployeeName();
                String progress = organizationDao.queryPersonProgress(employeeID);
                List<EmployeeBackups> employeeBackups = organizationDao.queryBackupDetail(employeeID + "");
                if (!StringUtils.isEmpty(progress)) {
                    double aDouble = Double.parseDouble(progress);
                    DecimalFormat df = new DecimalFormat("######0.00");
                    String percentProgress = df.format(aDouble);
                    QueryProgressResponse queryProgressResponse = new QueryProgressResponse();
                    queryProgressResponse.setName(employeeName);
                    queryProgressResponse.setValue(percentProgress);
                    queryProgressResponse.setList(employeeBackups);
                    arrayList.add(queryProgressResponse);
                }
            }
            List<QueryProgressResponse> collect = arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            return collect;
        }

        return arrayList;
    }
    @Transactional
    @Override
    public Result importExcelEmpBackups(MultipartFile file) {
        logger.error("- - - 导入excel备份人员信息service接入参数- - -{}",file);
        ArrayList<EmployeeBackups> list = new ArrayList<>();
        try {
            InputStream inputStream = file.getInputStream();
            List<Integer> empList = workTimeDao.getEmployeeIds();
            //调用工具类获取员工绩效数据
            List<List<Object>> listob = new ImportExcelUtil().getBankListByExcel(inputStream, file.getOriginalFilename(),0);
            inputStream.close();                  //释放流
            for (int i = 0; i < listob.size(); i++) {
                EmployeeBackups backups = new EmployeeBackups();

                String str = (String) listob.get(i).get(0);
                Integer empID = StringUtils.isEmpty(str) ? 0 : ConversionUtils.trimPoint(str);
                if (!empList.contains(empID)) {
                    continue;
                }
                backups.setEmployeeID(empID);                     //设置员工编号
                backups.setBackupType(String.valueOf(listob.get(i).get(1)));  //设置备份类型
                backups.setBackupContent(String.valueOf(listob.get(i).get(2))); //设置备份内容
                String strEmpID = (String) listob.get(i).get(3);
                Integer backupEmployeeID = StringUtils.isEmpty(str) ? 0 : ConversionUtils.trimPoint(strEmpID);
                if (!empList.contains(backupEmployeeID)) {
                    continue;
                }
                backups.setBackupEmployeeID(backupEmployeeID);           //设备承接人员备份编号
                backups.setOrganizationID(String.valueOf(listob.get(i).get(4)));  //组织编码
                String planCompleteDate = (String) listob.get(i).get(5);
                String strplanCompleteDate = ConversionUtils.dateChange(planCompleteDate, CommonConstant.DATAFORMATTER);
                backups.setPlanCompleteDate(strplanCompleteDate);                         //计划完成时间
                String currentProgress = String.valueOf(listob.get(i).get(6));
                double aDouble = Double.parseDouble(currentProgress);
                DecimalFormat df = new DecimalFormat("######0.00");
                String percentProgress = df.format(aDouble * 100);
                backups.setCurrentProgress(percentProgress + "%");                                              //项目进度
                String createDate = (String) listob.get(i).get(7);
                String strCreateDate = ConversionUtils.dateChange(createDate, CommonConstant.DATAFORMATTER);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if (!StringUtils.isEmpty(createDate)) {
                    Date createDateResult = simpleDateFormat.parse(strCreateDate);
                    backups.setCreateDate(createDateResult);                                        //创建时间
                }
                String completeDate = (String) listob.get(i).get(8);
                if (!StringUtils.isEmpty(completeDate)) {
                    String strCompleteDate = ConversionUtils.dateChange(completeDate, CommonConstant.DATAFORMATTER);
                    Date completeDateResult = simpleDateFormat.parse(strCompleteDate);
                    backups.setCompleteDate(completeDateResult);                                      //完成时间
                }
                String strPM = (String) listob.get(i).get(9);
                Integer pm = StringUtils.isEmpty(str) ? 0 : ConversionUtils.trimPoint(strPM);
                if (!empList.contains(pm)) {
                    continue;
                }
                backups.setPm(pm + "");                                               //设置pm
                String strCuHead = (String) listob.get(i).get(10);
                Integer cuHead = StringUtils.isEmpty(str) ? 0 : ConversionUtils.trimPoint(strCuHead);
                if (!empList.contains(cuHead)) {
                    continue;
                }
                backups.setCuHead(cuHead + "");                    //cuhead

                String updateDate = (String) listob.get(i).get(11);
                if (!StringUtils.isEmpty(updateDate)) {
                    String strUpdateDate = ConversionUtils.dateChange(updateDate, CommonConstant.DATAFORMATTER);
                    Date updateDateResult = simpleDateFormat.parse(strUpdateDate);
                    backups.setUpdateDate(updateDateResult);
                }//更新时间
                String cuValue = organizationDao.queryCUBypm(pm);
                backups.setCU(cuValue);
                backups.setBak(String.valueOf(listob.get(i).get(12)));
                list.add(backups);
            }
            organizationDao.deleteEmployeeBackups();
            organizationDao.importExcelEmployeeBackups(list);
            return new Result(true, "导入人员备份数据成功");
        } catch (Exception e) {
            logger.error("- - -导入excel备份人员信息 - - -", e);
            return new Result(false, "导入人员备份数据失败");
        }

    }
    @Override
    public Result exportExcelEmpBackups(HttpServletResponse response) {
        logger.error("- - - 导出excel备份人员信息service- - -");
        //得到所有要导出的数据
        List<EmployeeBacksExportExcel> employeeBacksExportExcels = new ArrayList<>();
        try {
            List<EmployeeBackups> employeeBackups = organizationDao.queryEmployeeBackupsforExcel();
            for (EmployeeBackups employeeBackup : employeeBackups) {
                EmployeeBacksExportExcel excel = new EmployeeBacksExportExcel();
                excel.setEmployeeID(employeeBackup.getEmployeeID());
                excel.setBackupType(employeeBackup.getBackupType());
                excel.setBackupContent(employeeBackup.getBackupContent());
                excel.setBackupEmployeeID(employeeBackup.getBackupEmployeeID());
                excel.setOrganizationID(employeeBackup.getOrganizationID());
                excel.setPlanCompleteDate(employeeBackup.getPlanCompleteDate());
                excel.setCurrentProgress(employeeBackup.getCurrentProgress());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date createDate = employeeBackup.getCreateDate();
                if (null != createDate) {
                    excel.setCreateDate(format.format(createDate));
                }
                Date completeDate = employeeBackup.getCompleteDate();
                if (null != completeDate) {
                    excel.setCompleteDate(format.format(completeDate));
                }
                excel.setPm(employeeBackup.getPm());
                excel.setCuHead(employeeBackup.getCuHead());
                Date updateDate = employeeBackup.getUpdateDate();
                if (null != updateDate) {
                    excel.setUpdateDate(format.format(updateDate));
                }
                excel.setBak(employeeBackup.getBak());
                employeeBacksExportExcels.add(excel);

            }
            //定义导出的excel名字
            String excelName = "人员备份表";
            //获取需要转出的excel表头的map字段
            LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
            fieldMap.put("employeeID", "备份人员员工编号");
            fieldMap.put("backupType", "备份类型");
            fieldMap.put("backupContent", "备份内容");
            fieldMap.put("backupEmployeeID", "承接人员员工编号");
            fieldMap.put("organizationID", "组织编号");
            fieldMap.put("planCompleteDate", "计划完成日期");
            fieldMap.put("currentProgress", "当前进展(举例10%)");
            fieldMap.put("createDate", "创建日期");
            fieldMap.put("completeDate", "完成日期");
            fieldMap.put("pm", "项目经理");
            fieldMap.put("cuHead", "CUHead");
            fieldMap.put("updateDate", "更新日期");
            fieldMap.put("bak", "备注");
            //导出用户相关信息
            ExportExcelUtils.export(excelName, employeeBacksExportExcels, fieldMap, response);
            return new Result(true, "导出成功");
        } catch (Exception e) {
            logger.error("- - -导出excel备份人员信息 - - -", e);
            return new Result(false, "导出失败");
        }

    }
    /**
     * 修改PO判断
     *
     * @param organizationInfo
     * @return
     */
    private boolean updatePo(OrganizationInformation organizationInfo) {
        boolean flag = false;
        OrganizationInformation poInfo =
                organizationDao.getPoInfoByLeader(organizationInfo.getLeader(), "", organizationInfo.getParentID());
        if (null == poInfo) {
            String organizationID = "po" + ConversionUtils.getRandomNum();
            organizationInfo.setOrganizationID(organizationID);
            organizationInfo.setOrganizationType("PO");
            int result = organizationDao.addOrganizationInfo(organizationInfo);
            if (result == 0) {
                return flag;
            }
            if (!organizationInfo.getProjectIds().isEmpty()) {
                organizationInfo.setPO(organizationID);
                result = organizationDao.updateProjectPO(organizationInfo);
                if (result == 0) {
                    return flag;
                }
            }
            flag = true;
            return flag;
        }
        if (!organizationInfo.getProjectIds().isEmpty()) {
            organizationInfo.setPO(poInfo.getOrganizationID());
            int result = organizationDao.updateProjectPO(organizationInfo);
            if (result == 0) {
                return flag;
            }
        }
        flag = true;
        return flag;
    }
    /**
     * list集合去重
     * @param list
     * @return
     */
    public List<OrganizationInformation>  removeDuplicate(List<OrganizationInformation> list)  {       
    	  for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {       
    	      for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {       
    	           if  (list.get(j).equals(list.get(i)))  {       
    	              list.remove(j);       
    	            }        
    	        }        
    	      }        
    	    return list;       
    	} 
}
