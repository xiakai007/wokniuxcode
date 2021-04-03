package com.isoftstone.humanresources.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isoftstone.humanresources.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.EmployeeDao;
import com.isoftstone.humanresources.dao.SystemConfigDao;
import com.isoftstone.humanresources.dao.UserDao;
import com.isoftstone.humanresources.dao.WorkTimeDao;

import com.isoftstone.humanresources.domain.EmployeeEvaluation;
import com.isoftstone.humanresources.domain.EmployeeInformation;
import com.isoftstone.humanresources.domain.EmployeeLossInformation;
import com.isoftstone.humanresources.domain.EmployeePerformanceInformation;
import com.isoftstone.humanresources.domain.EmployeeProjectInformation;
import com.isoftstone.humanresources.domain.EmployeeRisk;
import com.isoftstone.humanresources.domain.EmployeeWorkTimeDayInformation;
import com.isoftstone.humanresources.domain.EmployeeWorkTimeMonthInfomation;
import com.isoftstone.humanresources.domain.OrganizationInformation;
import com.isoftstone.humanresources.domain.QueryEmpListParam;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.User;
import com.isoftstone.humanresources.domain.SystemConfigInformation;
import com.isoftstone.humanresources.domain.screen.EmployeePerformanceEntity;
import com.isoftstone.humanresources.domain.useremployee.SkillInVO;
import com.isoftstone.humanresources.domain.useremployee.UserEmployeeVO;
import com.isoftstone.humanresources.service.EmployeeService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.ConversionUtils;
import com.isoftstone.humanresources.util.ImportExcelUtil;
import com.isoftstone.humanresources.util.MyException;
import com.isoftstone.humanresources.util.StringUtil;

@Service(value = "EmployeeService")
public class EmpoyleeServiceImpl implements EmployeeService {
    private final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private UserDao userDao;
    
    @Autowired
	private WorkTimeDao workTimeDao;
    
    @Autowired
    private SystemConfigDao systemConfigDao;

    /**
     * 根据ID获取组织的基本信息
     *
     * @param organizationID
     * @return
     */
    public List<EmployeeInformation> queryByOrganizationID(String organizationID, String organizationType) {
        return employeeDao.queryByOrganizationID(organizationID, organizationType);
    }

    public List<EmployeePerformanceEntity> getPerformanceDistribution(List<OrganizationInformation> list) {
        return employeeDao.getPerformanceDistribution(list);
    }

    @Override
    public void loadExclEmployee(HttpServletResponse response, HttpServletRequest request) throws IOException {
        OutputStream outp = null;
        FileInputStream in = null;
        try {
            String fileName = "Excel_Employee.xlsx"; //要下载的模板文件
            String ctxPath = System.getProperty("user.dir") + "\\src\\main\\resources\\templates\\";
            String filedownload = ctxPath + fileName;
            fileName = URLEncoder.encode(fileName, "UTF-8");
            // 要下载的模板所在的绝对路径
            response.reset();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType("application/octet-stream;charset=UTF-8");
            outp = response.getOutputStream();
            in = new FileInputStream(filedownload);
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


    @Override
    public Map<String, List<Object>> importExclEmployee(MultipartFile file) throws IOException {
        List<EmployeeInformation> list = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        Map<String, List<Object>> map = new HashMap<>();
		List<Object> listReturn = new ArrayList<>();
        List<Object> listReturnError = new ArrayList<>();
        try {

            EmployeeInformation vo = null;
            InputStream in = null;
            List<List<Object>> listob = null;
            in = file.getInputStream();
            List<Integer> empId = employeeDao.queryListUserId();
            /**
             * 获取excl表中的值
             */
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename(),0);
            in.close();
            for (int i = 0; i < listob.size(); i++) {
                vo = new EmployeeInformation();
                vo.setEmployeeID(StringUtil.isEmpty(String.valueOf(listob.get(i).get(0))) ? 0 : ConversionUtils.trimPoint(String.valueOf(listob.get(i).get(0))));
                if(empId.contains(vo.getEmployeeID())){
                	listReturn.add(listob.get(i));
                	continue;
                }
                vo.setEmployeeName(String.valueOf(listob.get(i).get(1)));
                vo.setCardID(String.valueOf(listob.get(i).get(2)));
                vo.setIssStatus(String.valueOf(listob.get(i).get(3)));
                vo.setIsImportant(String.valueOf(listob.get(i).get(4)));
                vo.setIsImportantCore(String.valueOf(listob.get(i).get(5)));
                vo.setIsOnShore(String.valueOf(listob.get(i).get(6)));
                vo.setOfficeSpace(String.valueOf(listob.get(i).get(7)));
                vo.setCooperationModel(String.valueOf(listob.get(i).get(8)));
                vo.setSkill(getSkill(String.valueOf(listob.get(i).get(9))));
                vo.setEntryDate(tobEntryDate(vo.getEmployeeID(), String.valueOf(listob.get(i).get(10))));
                vo.setCostCenter(String.valueOf(listob.get(i).get(12)));
                vo.setEntryLong(StringUtil.isEmpty(String.valueOf(listob.get(i).get(13))) ? "0" : String.valueOf(listob.get(i).get(13)));
                vo.setWorkLong(StringUtil.isEmpty(String.valueOf(listob.get(i).get(14))) ? "0" : String.valueOf(listob.get(i).get(14)));
                vo.setBirthday(String.valueOf(listob.get(i).get(15)));
                vo.setGraducationSchool(String.valueOf(listob.get(i).get(16)));
                vo.setHuaweiLevel(String.valueOf(listob.get(i).get(17)));
                vo.setIs211(String.valueOf(listob.get(i).get(18)));
                vo.setReporter(String.valueOf(listob.get(i).get(19)));
                vo.setReporter_workid(String.valueOf(listob.get(i).get(20)));
                vo.setArea(String.valueOf(listob.get(i).get(21)));
                vo.setMobile(String.valueOf(listob.get(i).get(22)));
                vo.setBusinessLine(String.valueOf(listob.get(i).get(23)));
                vo.setPosition(String.valueOf(listob.get(i).get(24)));
                vo.setEmail(String.valueOf(listob.get(i).get(25)));
                vo.setNameCard(String.valueOf(listob.get(i).get(26)));
                vo.setBG(String.valueOf(listob.get(i).get(27)));
                vo.setBD(String.valueOf(listob.get(i).get(28)));
                vo.setBU(String.valueOf(listob.get(i).get(29)));
                vo.setCU(String.valueOf(listob.get(i).get(30)));
                vo.setPDU(String.valueOf(listob.get(i).get(31)));
                vo.setPO(String.valueOf(listob.get(i).get(32)));
                vo.setSex(String.valueOf(listob.get(i).get(33)));
                vo.setOrganizationID(String.valueOf(listob.get(i).get(34)));
                vo.setProjectTeam(String.valueOf(listob.get(i).get(35)));
                vo.setBak(String.valueOf(listob.get(i).get(36)));
                vo.setImgURL(OrganizationServiceImpl.loadImg(String.valueOf(listob.get(i).get(37)), "employeeimg"));
                vo.setRank(String.valueOf(listob.get(i).get(38)));
                st = this.checkExcl(vo, i);
                if(st.length() > 0){
                	listReturn.add(listob.get(i));
                }
                list.add(vo);
            }
            map.put("importFailure", listReturn);
            if (st.length() > 0) {
                listReturnError.add(st.toString());
            	map.put("error", listReturnError);
            }
            if(!list.isEmpty()){
            	
            	int result = employeeDao.importExcelEmployee(list);
            	if (result == 0) {
            		st.append("新增到数据库失败");
            		listReturnError.add(st.toString());
            		map.put("error", listReturnError);
            		return map;
            	}
            }
            User user = null;
            List<User> userList = new ArrayList<>();
            
            for (EmployeeInformation emp : list) {
            	if(empId.contains(emp.getEmployeeID())){
            		continue;
            	}
                user = new User();
                user.setUsername(ConversionUtils.getName(emp.getEmail()));
                //user.setPassword(AESUtil.encryptBasedDes("Rt123456"));
                user.setStatus(0);
                user.setEmail(emp.getEmail());
                user.setEmployeeID(emp.getEmployeeID());
                user.setPhone(emp.getMobile());
                userList.add(user);
            }
            if(!userList.isEmpty()){
            	
            	int result = employeeDao.addUser(userList);
            	if (result == 0) {
            		st.append("添加用户失败");
            		listReturnError.add(st.toString());
            		map.put("error", listReturnError);
            		return map;
            	}
            }
        } catch (Exception e) {
        	e.printStackTrace();
            st.append("excl导入新增异常");
            st.append(e.toString());
            listReturnError.add(st.toString());
        	map.put("error", listReturnError);
            return map;
        }
        return map;
    }
    @Override
    public EmployeeInformation getSimpleEmployeeInformation(long employeeID) throws MyException{
        return employeeDao.queryEmployeeInfo(employeeID);
    }

    @Override
    public UserEmployeeVO getEmployeeInformation(long employeeID) throws MyException {
        UserEmployeeVO userEmployeeVO = null;
        List<SkillInVO> skilList = new ArrayList<>();
        List<EmployeeProjectInformation> projectList = new ArrayList<>();
        List<EmployeePerformanceInformation> performanceList = new ArrayList<>();
        List<EmployeeWorkTimeDayInformation> workTimeList = new ArrayList<>();
        List<EmployeeWorkTimeMonthInfomation> queryMonthList = new ArrayList<>();
        EmployeeInformation queryEmployee = null;
        try {
            skilList = employeeDao.querySkill(employeeID);
            projectList = employeeDao.queryProject(employeeID);
            performanceList = employeeDao.queryPerformance(employeeID);
            workTimeList = employeeDao.queryWorkTimeDay(employeeID);
            userEmployeeVO = employeeDao.queryUserInfo(employeeID);
            queryEmployee = employeeDao.queryEmployeeInfo(employeeID);
            queryMonthList = employeeDao.queryMonthList(employeeID);
            if ((!skilList.isEmpty())) {
                userEmployeeVO.setSkilList(skilList);
            }
            if ((!projectList.isEmpty())) {
                userEmployeeVO.setProjectList(projectList);
            }
            if ((!performanceList.isEmpty())) {
                userEmployeeVO.setPerformanceList(performanceList);
            }
            if ((!workTimeList.isEmpty())) {
                userEmployeeVO.setWorkTimeList(workTimeList);
            }
            if (!StringUtils.isEmpty(queryEmployee)) {
                userEmployeeVO.setEmployeeInformation(queryEmployee);
            }
            if (!queryMonthList.isEmpty()) {
                userEmployeeVO.setMothList(queryMonthList);
            }
        } catch (Exception e) {
            throw new MyException(e.toString());
        }
        return userEmployeeVO;
    }

    private StringBuilder checkExcl(EmployeeInformation vo, int i) {
        StringBuilder str = new StringBuilder();
        if ((!StringUtil.isEmpty(String.valueOf(vo.getEmployeeID()))) && String.valueOf(vo.getEmployeeID()).length() > 12) {
            str.append("第" + i + "行,员工编号长度最大为12，实际为" + String.valueOf(vo.getEmployeeID()).length());
        } else if (vo.getEmployeeID() == 0) {
            str.append("第" + i + "行,员工编号不能为空，实际为" + vo.getEmployeeID());
        } else if ((!StringUtil.isEmpty(vo.getEmployeeName())) && vo.getEmployeeName().length() > 32) {
            str.append("第" + i + "行,姓名长度最大为32，实际为" + vo.getEmployeeName().length());
        } else if ((!StringUtil.isEmpty(vo.getCardID())) && vo.getCardID().length() > 32) {
            str.append("第" + i + "行,身份证号长度最大为20，实际为" + vo.getCardID().length());
        } else if ((!StringUtil.isEmpty(vo.getIssStatus())) && vo.getIssStatus().length() > 8) {
            str.append("第" + i + "行,软通状态长度最大为8，实际为" + vo.getIssStatus().length());
        } else if ((!StringUtil.isEmpty(vo.getIsImportant())) && vo.getIsImportant().length() > 4) {
            str.append("第" + i + "行,是否骨干长度最大为4，实际为" + vo.getIsImportant().length());
        } else if ((!StringUtil.isEmpty(vo.getIsImportantCore())) && vo.getIsImportantCore().length() > 4) {
            str.append("第" + i + "行,是否核心骨干长度最大为4，实际为" + vo.getIsImportantCore().length());
        } else if ((!StringUtil.isEmpty(vo.getIsOnShore())) && vo.getIsOnShore().length() > 4) {
            str.append("第" + i + "行,是否是否在岸长度最大为4，实际为" + vo.getIsOnShore().length());
        } else if ((!StringUtil.isEmpty(vo.getOfficeSpace())) && vo.getOfficeSpace().length() > 64) {
            str.append("第" + i + "行,办公场地长度最大为64，实际为" + vo.getOfficeSpace().length());
        } else if ((!StringUtil.isEmpty(vo.getCooperationModel())) && vo.getCooperationModel().length() > 32) {
            str.append("第" + i + "行,合作模式长度最大为32，实际为" + vo.getCooperationModel().length());
        } else if ((!StringUtil.isEmpty(vo.getSkill())) && vo.getSkill().length() > 24) {
            str.append("第" + i + "行,技能长度最大为24，实际为" + vo.getSkill().length());
        } else if ((!StringUtil.isEmpty(vo.getCostCenter())) && vo.getCostCenter().length() > 32) {
            str.append("第" + i + "行,成本中心长度最大为32，实际为" + vo.getCostCenter().length());
        } else if (!ConversionUtils.isDoubleOrFloat(vo.getEntryLong())) {
            str.append("第" + i + "行,司龄（月）格式错误应为double型，实际为" + vo.getEntryLong());
        } else if (!ConversionUtils.isDoubleOrFloat(vo.getWorkLong())) {
            str.append("第" + i + "行,工龄（年）格式错误应为double型，实际为" + vo.getWorkLong());
        } else if ((!StringUtil.isEmpty(vo.getBirthday())) && vo.getBirthday().length() > 24) {
            str.append("第" + i + "行,生日长度最大为24，实际为" + vo.getBirthday().length());
        } else if ((!StringUtil.isEmpty(vo.getGraducationSchool())) && vo.getGraducationSchool().length() > 64) {
            str.append("第" + i + "行,毕业院校长度最大为64，实际为" + vo.getGraducationSchool().length());
        } else if ((!StringUtil.isEmpty(vo.getHuaweiLevel())) && vo.getHuaweiLevel().length() > 8) {
            str.append("第" + i + "行,华为职级长度最大为8，实际为" + vo.getHuaweiLevel().length());
        } else if ((!StringUtil.isEmpty(vo.getIs211())) && vo.getIs211().length() > 8) {
            str.append("第" + i + "行,是否211长度最大为8，实际为" + vo.getIs211().length());
        } else if ((!StringUtil.isEmpty(vo.getReporter())) && vo.getReporter().length() > 32) {
            str.append("第" + i + "行,直接汇报人姓名长度最大为32，实际为" + vo.getReporter().length());
        } else if ((!StringUtil.isEmpty(vo.getReporter_workid())) && vo.getReporter_workid().length() > 32) {
            str.append("第" + i + "行,直接汇报人工号长度最大为32，实际为" + vo.getReporter_workid().length());
        } else if ((!StringUtil.isEmpty(vo.getArea())) && vo.getArea().length() > 16) {
            str.append("第" + i + "行,工作区域长度最大为16，实际为" + vo.getArea().length());
        } else if ((!StringUtil.isEmpty(vo.getMobile())) && vo.getMobile().length() > 32) {
            str.append("第" + i + "行,手机号码长度最大为32，实际为" + vo.getMobile().length());
        } else if ((!StringUtil.isEmpty(vo.getBusinessLine())) && vo.getBusinessLine().length() > 16) {
            str.append("第" + i + "行,业务线长度最大为16，实际为" + vo.getBusinessLine().length());
        } else if ((!StringUtil.isEmpty(vo.getPosition())) && vo.getPosition().length() > 16) {
            str.append("第" + i + "行,职位长度最大为16，实际为" + vo.getPosition().length());
        } else if (!ConversionUtils.checkEmil(vo.getEmail())) {
            str.append("第" + i + "行,邮箱格式不规范，实际为" + vo.getPosition());
        } else if (vo.getEmail().length() > 32) {
            str.append("第" + i + "行,邮箱长度最大为32，实际为" + vo.getPosition().length());
        } else if ((!StringUtil.isEmpty(vo.getNameCard())) && vo.getNameCard().length() > 32) {
            str.append("第" + i + "行,姓名+身份证前3+身份证后4长度最大为32，实际为" + vo.getNameCard().length());
        } else if ((!StringUtil.isEmpty(vo.getBG())) && vo.getBG().length() > 32) {
            str.append("第" + i + "行,BG长度最大为32，实际为" + vo.getBG().length());
        } else if ((!StringUtil.isEmpty(vo.getBD())) && vo.getBD().length() > 32) {
            str.append("第" + i + "行,BD长度最大为32，实际为" + vo.getBD().length());
        } else if ((!StringUtil.isEmpty(vo.getBU())) && vo.getBU().length() > 32) {
            str.append("第" + i + "行,BU长度最大为32，实际为" + vo.getBU().length());
        } else if ((!StringUtil.isEmpty(vo.getCU())) && vo.getCU().length() > 32) {
            str.append("第" + i + "行,CU长度最大为32，实际为" + vo.getCU().length());
        } else if ((!StringUtil.isEmpty(vo.getPDU())) && vo.getPDU().length() > 32) {
            str.append("第" + i + "行,PDU长度最大为32，实际为" + vo.getPDU().length());
        } else if ((!StringUtil.isEmpty(vo.getPO())) && vo.getPO().length() > 32) {
            str.append("第" + i + "行,PO长度最大为32，实际为" + vo.getPO().length());
        } else if ((!StringUtil.isEmpty(vo.getSex())) && vo.getSex().length() > 4) {
            str.append("第" + i + "行,性别长度最大为4，实际为" + vo.getSex().length());
        } else if ((!StringUtil.isEmpty(vo.getOrganizationID())) && vo.getOrganizationID().length() > 32) {
            str.append("第" + i + "行,对应组织ID长度最大为32，实际为" + vo.getOrganizationID().length());
        } else if ((!StringUtil.isEmpty(vo.getProjectTeam())) && vo.getProjectTeam().length() > 32) {
            str.append("第" + i + "行,员工所在的项目组ID长度最大为32，实际为" + vo.getProjectTeam().length());
        } else if ((!StringUtil.isEmpty(vo.getBak())) && vo.getBak().length() > 255) {
            str.append("第" + i + "行,备份长度最大为255，实际为" + vo.getBak().length());
        }
        return str;
    }

    /**
     * 获取入职时间
     *
     * @param employeeID
     * @param entryDate
     * @return
     */
    private String tobEntryDate(Integer employeeID, String entryDate) {
        String newDate;
        EmployeeInformation empl = userDao.queryEmployeeById(employeeID);
        if (StringUtils.isEmpty(empl) || StringUtil.isEmpty(empl.getEntryDate())) {
            newDate = ConversionUtils.dateChange(entryDate, CommonConstant.DATAFORMATTER);
        } else {
            newDate = empl.getEntryDate();
        }
        return newDate;
    }


    @Override
    public void loadPicture(String pictureURL, String emplOrOrg, HttpServletResponse response) throws Exception {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        //获取图片存放路径
        String imgPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\" + emplOrOrg + "\\" + pictureURL;
        try {
            ips = new FileInputStream(new File(imgPath));
            response.reset();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Content-Disposition", "attachment; filename=" + pictureURL);
            response.setContentType("application/octet-stream;charset=UTF-8");
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            throw new MyException("图片下载失败");
        } finally {
            if (null != ips) {
                ips.close();
            }
        }

    }


    @Override
    public PageInfo<EmployeeInformation> queryEmpList(QueryEmpListParam queryEmpListParam) {
        logger.info("----------查询员工列表信息service接入参数------{}", queryEmpListParam);
        PageInfo<EmployeeInformation> empPageInfo = new PageInfo<>();
        try {
            Integer page = queryEmpListParam.getPage();
            Integer pageSize = queryEmpListParam.getPageSize();
            if (page != null && pageSize != null) {
                PageHelper.startPage(page, pageSize);                     //分页
                //调用dao接口查询员工列表
                List<EmployeeInformation> empList = null;

                empList = employeeDao.queryEmpList(queryEmpListParam);
                empPageInfo = new PageInfo<>(empList);
            }
        } catch (Exception e) {
            logger.error("-----查询员工列表信息异常--------", e);
        }
        logger.info("----------查询员工列表信息service返回参数------{}", queryEmpListParam);
        return empPageInfo;
    }

    @Override
    public List<EmployeeRisk> queryRiskList(Integer employeeID) {
        logger.info("----------查询员工风险列表信息service接入参数------{}", employeeID);
        List<EmployeeRisk> riskList = null;
        try {
            riskList = employeeDao.queryRiskList(employeeID);
        } catch (Exception e) {
            logger.error("-----查询员工风险列表信息异常--------", e);
        }
        logger.info("----------查询员工风险列表信息service返回参数------{}", riskList);
        return riskList;
    }

    @Override
    public Result addRisk(EmployeeRisk employeeRisk) {
        logger.info("----------新增风险信息service接入参数------{}", employeeRisk);
        try {
            employeeRisk.setCreateTime(new Date());
            employeeDao.addRisk(employeeRisk);
            return new Result(true, "新增风险成功");
        } catch (Exception e) {
            logger.error("-----新增风险信息异常--------", e);
            return new Result(false, "新增风险失败");
        }
    }

    @Override
    public Result deleteRisk(Integer ID) {
        logger.info("----------删除风险信息service接入参数------{}", ID);
        try {
            employeeDao.deleteRisk(ID);
            return new Result(true, "删除风险成功");
        } catch (Exception e) {
            logger.error("-----删除风险信息异常--------", e);
            return new Result(false, "删除风险失败");
        }

    }

    @Override
    public Result updateRisk(EmployeeRisk employeeRisk) {
        logger.info("----------修改风险信息service接入参数------{}", employeeRisk);
        try {
            employeeRisk.setModifyTime(new Date());
            employeeDao.updateRisk(employeeRisk);
            return new Result(true, "修改员工风险成功");
        } catch (Exception e) {
            logger.error("-----修改员工风险信息异常--------", e);
            return new Result(false, "修改员工失败");
        }

    }

    @Override
    public List<EmployeeEvaluation> queryEvaluationList(Integer employeeID) {
        logger.info("----------查询员工评价列表信息service接入参数------{}", employeeID);
        List<EmployeeEvaluation> evaluationList = null;
        try {
            evaluationList = employeeDao.queryEvaluationList(employeeID);
        } catch (Exception e) {
            logger.error("-----查询员工评价列表信息异常--------", e);
        }
        logger.info("----------查询员工评价列表信息service返回参数------{}", evaluationList);
        return evaluationList;
    }

    @Override
    public Result deleteEvaluation(Integer ID) {
        logger.info("----------删除员工评价信息service接入参数------{}", ID);
        try {
            employeeDao.deleteEvaluation(ID);
            return new Result(true, "删除员工评价信息成功");
        } catch (Exception e) {
            logger.error("-----删除员工评价信息信息异常--------", e);
            return new Result(false, "删除员工评价信息失败");
        }

    }

    @Override
    public Result changeEvaluation(EmployeeEvaluation employeeEvaluation) {
        logger.info("----------新增或修改员工评价信息service接入参数------{}", employeeEvaluation);
        try {
            Integer id = employeeEvaluation.getID();
            if (null == id) {
                employeeEvaluation.setCreateTime(new Date());
                //调用dao接口新增评价
                employeeDao.addEvaluation(employeeEvaluation);
                return new Result(true, "新增员工评价成功");
            } else {
                employeeEvaluation.setModifyTime(new Date());
                //调用dao接口修改评价
                employeeDao.updateEvaluation(employeeEvaluation);
                return new Result(true, "修改员工评价成功");

            }
        } catch (Exception e) {
            logger.error("-----新增或修改员工评价信息信息异常--------", e);
            return new Result(false, "新增或修改评价失败");
        }
    }

    @Override
    public List<EmployeeProjectInformation> queryProjectList(Long employeeID) {
        logger.info("----------查询员工项目经历信息service接入参数------{}", employeeID);
        List<EmployeeProjectInformation> projectList = null;
        try {
            projectList = employeeDao.queryProject(employeeID);
        } catch (Exception e) {
            logger.error("-----查询员工项目经历信息异常--------", e);
        }
        logger.info("----------查询员工评价列表信息service返回参数------{}", projectList);
        return projectList;
    }

    @Override
    public Result addProject(EmployeeProjectInformation employeeProjectInformation) {
        logger.info("----------新增员工项目经历信息service接入参数------{}", employeeProjectInformation);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String creatTime = format.format(new Date());
            employeeProjectInformation.setCreateTime(creatTime);
            employeeDao.addProject(employeeProjectInformation);
            return new Result(true, "新增员工项目经历成功");

        } catch (Exception e) {
            logger.error("-----新增员工项目经历异常--------", e);
            return new Result(false, "新增员工项目经历失败");
        }
    }

    @Override
    public Result updateProject(EmployeeProjectInformation employeeProjectInformation) {
        logger.info("----------更新员工项目经历信息service接入参数------{}", employeeProjectInformation);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String updateTime = format.format(new Date());
            employeeProjectInformation.setUpdateTime(updateTime);
            employeeDao.updateProject(employeeProjectInformation);
            return new Result(true, "更新员工经历成功");
        } catch (Exception e) {
            logger.error("-----更新员工项目经历异常--------", e);
            return new Result(false, "更新员工项目经历失败");
        }

    }

    @Override
    public List<SkillInVO> querySkillList(Long employeeID) {
        logger.info("----------查询员工技能信息service接入参数------{}", employeeID);
        List<SkillInVO> skillList = null;
        try {
            skillList = employeeDao.querySkill(employeeID);
        } catch (Exception e) {
            logger.error("-----查询员工技能信息异常--------", e);
        }
        logger.info("----------查询员工技能信息service返回参数------{}", skillList);
        return skillList;
    }

    @Override
    public Result addEmployeeSkill(List<SkillInVO> skillInVOList) {
        logger.info("----------新增员工技能信息service接入参数------{}", skillInVOList);
        try {
            employeeDao.addEmployeeSkill(skillInVOList);
            return new Result(true, "新增员工技能成功");
        } catch (Exception e) {
            logger.error("-----新增员工技能异常--------", e);
            return new Result(false, "新增员工技能失败");
        }
    }

    @Override
    public Result updateEmployeeSkill(SkillInVO skillInVO) {
        logger.info("----------更新员工技能信息service接入参数------{}", skillInVO);
        try {
            employeeDao.updateEmployeeSkill(skillInVO);
            return new Result(true, "更新员工技能成功");
        } catch (Exception e) {
            logger.error("-----更新员工技能异常--------", e);
            return new Result(false, "更新员工技能失败");
        }
    }

	@Override
	public Map<String, List<Object>> leaveImportEmployee(MultipartFile file) throws IOException {

        List<EmployeeLossInformation> list = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        Map<String, List<Object>> map = new HashMap<>();
        List<Object> listReturn = new ArrayList<>();
        List<Object> listReturnError = new ArrayList<>();
        try {

        	EmployeeLossInformation vo = null;
            InputStream in = null;
            List<List<Object>> listob = null;
            in = file.getInputStream();

            List<Integer> empList = workTimeDao.getEmployeeIds();
            /**
             * 获取excl表中的值
             */
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename(),0);
            in.close();
            for (int i = 0; i < listob.size(); i++) {
            	if(!empList.contains(StringUtil.isEmpty(String.valueOf(listob.get(i).get(0)))?0:ConversionUtils.trimPoint(String.valueOf(listob.get(i).get(0))))){
            		listReturn.add(listob.get(i));
					continue;
				}
                vo = new EmployeeLossInformation();
                vo.setEmployeeID(StringUtil.isEmpty(String.valueOf(listob.get(i).get(0))) ? 0 : ConversionUtils.trimPoint(String.valueOf(listob.get(i).get(0))));
                vo.setLeaveDate(ConversionUtils.dateChange(String.valueOf(listob.get(i).get(1)), CommonConstant.DATAFORMATTER));
                vo.setLeaveType(String.valueOf(listob.get(i).get(2)));
                vo.setLeaveCauseSort(String.valueOf(listob.get(i).get(3)));
                vo.setLeaveCause(String.valueOf(listob.get(i).get(4)));
                vo.setLeaveCauseDetial(String.valueOf(listob.get(i).get(4)));
                vo.setCreateTime(String.valueOf(listob.get(i).get(5)));
                vo.setBak(String.valueOf(listob.get(i).get(6)));
                list.add(vo);
            }
            map.put("importFailure", listReturn);
            if (st.length() > 0) {
            	listReturnError.add(st.toString());
            	map.put("error", listReturnError);
                return map;
            }
            int result = employeeDao.leaveEmployee(list);
            if (result == 0) {
                st.append("新增到数据库失败");
                listReturnError.add(st.toString());
            	map.put("error", listReturnError);
                return map;
            }
            User user = null;
            List<User> userList = new ArrayList<>();
            List<EmployeeInformation> listOrg = new ArrayList<>();
            EmployeeInformation empInfo = null;
            for (EmployeeLossInformation emp : list) {
                user = new User();
                empInfo = new EmployeeInformation();
                empInfo.setLeaveDate(emp.getLeaveDate());
                empInfo.setIssStatus("离职");
                empInfo.setEmployeeID(emp.getEmployeeID());
                user.setEmployeeID(emp.getEmployeeID());
                listOrg.add(empInfo);
                userList.add(user);
            }
            result = employeeDao.updateUserStatus(userList);
            
            if (result == 0) {
                st.append("修改用户信息失败");
            }
            result = employeeDao.updateEmployeeInfo(listOrg);
            if (result == 0) {
                st.append("修改员工信息");
            }
        } catch (Exception e) {
        	e.printStackTrace();
            listReturnError.add(e.toString());
        	map.put("error", listReturnError);
        }
        listReturnError.add(st.toString());
    	map.put("error", listReturnError);
        return map;
	}

    @Override
    public Result updateEmpImg(EmployeeInformation employeeInformation)  {
        logger.info("----------更新员工图片信息service接入参数------{}", employeeInformation);
        try {
            employeeDao.updateEmpImg(employeeInformation);
            return new Result(true,"更新员工图片信息成功");
        } catch (Exception e) {
            logger.error("-----更新员工图片信息异常--------", e);
            return new Result(false,"更新员工信息失败");
        }
    }




    @Override
    public PageInfo<EmployeePerfomanceVo> queryEmpPerList(QueryEmpPerformaceParam queryEmpPerformaceParam)  {

        logger.info("----------查询员工绩效列表信息service接入参数------{}", queryEmpPerformaceParam);
        PageInfo<EmployeePerfomanceVo> employeePerformanceInformationPageInfo  = new PageInfo<>();
        try {
            Integer page = queryEmpPerformaceParam.getPage();
            Integer pageSize = queryEmpPerformaceParam.getPageSize();
            if (page != null && pageSize != null) {
                PageHelper.startPage(page, pageSize);                     //分页
                //调用dao接口查询员工绩效列表

                List<EmployeePerfomanceVo> employeePerformanceInformations = employeeDao.queryEmpPer(queryEmpPerformaceParam);

                if (employeePerformanceInformations != null & employeePerformanceInformations.size() > 0) {
                   employeePerformanceInformationPageInfo = new PageInfo<>(employeePerformanceInformations);
                }
            }
        } catch (Exception e) {
            logger.error("-----查询员工列表信息异常--------", e);
        }
        logger.info("----------查询员工列表信息service返回参数------{}", employeePerformanceInformationPageInfo);
        return employeePerformanceInformationPageInfo;
    }

    @Override
    public PageInfo<EmployeeWorkTimeMonthVo> queryEmpWorkTimeMonth(QueryEmpWorkTimeMonthParam queryEmpWorkTimeMonthParam) throws Exception {
        logger.info("----------查询员工月度考勤列表信息service接入参数------{}", queryEmpWorkTimeMonthParam);
        PageInfo<EmployeeWorkTimeMonthVo>  employeeWorkTimeMonthVoPageInfo = new PageInfo<>();
        try {
            Integer page = queryEmpWorkTimeMonthParam.getPage();
            Integer pageSize = queryEmpWorkTimeMonthParam.getPageSize();
            if (page != null && pageSize != null) {
                PageHelper.startPage(page, pageSize);                     //分页
                //调用dao接口查询员工考勤列表
                List<EmployeeWorkTimeMonthVo> employeeWorkTimeMonthVos = employeeDao.queryEmpWorkTimeMonth(queryEmpWorkTimeMonthParam);

                if (employeeWorkTimeMonthVos != null & employeeWorkTimeMonthVos.size() > 0) {
                   employeeWorkTimeMonthVoPageInfo = new PageInfo<>(employeeWorkTimeMonthVos);
                }
            }
        } catch (Exception e) {
            logger.error("-----查询员工考勤列表信息异常--------", e);
        }
        logger.info("----------查询员工考勤列表信息service返回参数------{}", employeeWorkTimeMonthVoPageInfo);
        return employeeWorkTimeMonthVoPageInfo;
    }

    @Override
    public List<String> queryMonthList()  {
        List<String> monthList=null;
        try {
           monthList = employeeDao.queryMonth();
        } catch (Exception e) {
            logger.error("-----查询月份列表信息异常--------", e);
        }
        logger.info("----------查询月份列表信息service返回参数------{}", monthList);
        return monthList;
    }

    @Override
    public Result queryLog(Integer employeeID) throws Exception {

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String startDate = sd.format(date);
        long startTime = date.getTime();
        long endTime= startTime-20*60*1000;
        date.setTime(endTime);
        String endDate = sd.format(date);
        HashMap<String, Object> map = new HashMap<>();
        map.put("employeeID",employeeID);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        Integer count = employeeDao.queryLog(map);
        if (count>0){
            return new Result(true,"用户正在操作");
        }
        return new Result(false,"用户终止操作");
    }

    @Override
    public List<EmployeeCertificate> queryEmpCertificateList(Integer employeeID){
        logger.info("- - - 查询员工证书信息service- - -");
        List<EmployeeCertificate> employeeCertificates=null;
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("employeeID",employeeID);
            map.put("date",new Date());
            employeeCertificates = employeeDao.queryEmpCertificateList(map);
        } catch (Exception e) {
            logger.error("- - - 查询员工证书信息异常- - -",e);
        }
        logger.info("----------查询员工证书信息service返回参数------{}", employeeCertificates);
        return employeeCertificates;
    }

    @Override
    public List<SysConfigResponse> queryCertificateType()  {
        logger.info("- - - 查询证书类型下拉框service- - -");
        List<SysConfigResponse> sysConfigResponses=null;
        try {
            sysConfigResponses = employeeDao.queryCertificateType();
        } catch (Exception e) {
           logger.info("- - -查询证书类型下拉框异常 - - ");
        }
        logger.info("----------查询证书类型下拉框service返回参数------{}", sysConfigResponses);
        return sysConfigResponses;
    }

    @Override
    public Result addEmpCertificate(EmployeeCertificate certificate) {
        logger.info("- - - 新增证书信息service的请求参数- - -{}",certificate);
        try {
            certificate.setCreateDate(new Date());
            employeeDao.addEmpCertificate(certificate);
            return new Result(true,"新增证书信息成功");
        } catch (Exception e) {
           logger.error("- - -新增证书信息异常 - - -",e);
            return new Result(false,"新增证书信息失败");
        }

    }

    @Override
    public Result updateCertificate(EmployeeCertificate certificate)  {
        logger.info("----------修改证书信息service接入参数------{}", certificate);
        try {
            certificate.setUpdateDate(new Date());
            employeeDao.updateCertificate(certificate);
            return new Result(true,"修改证书信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改证书信息失败");
        }

    }


    /**
     * 获取Skill枚举值
     * @param skill
     * @return
     */
    private String getSkill(String skill){
    	String returnStr = "";
    	if(StringUtil.isEmpty(skill))
    	{
    		returnStr = "skill4";
    		return returnStr;
    	}
    	SystemConfigInformation systemCon= systemConfigDao.queryConfigByValue("skill", skill);
    	if(null != systemCon)
    	{
    		returnStr = systemCon.getConfigName();
    	}
    	return returnStr;
    }

}
