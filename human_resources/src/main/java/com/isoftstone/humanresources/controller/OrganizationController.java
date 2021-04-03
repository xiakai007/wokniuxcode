package com.isoftstone.humanresources.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.isoftstone.humanresources.domain.organization.OrganizationInfoVO;
import com.isoftstone.humanresources.domain.organization.OrganizationTreeVO;
import com.isoftstone.humanresources.domain.organization.OrganizationUpdatePersonVO;
import com.isoftstone.humanresources.domain.organization.QueryLeaderVO;
import com.isoftstone.humanresources.domain.organization.QueryProjectPoVO;
import com.isoftstone.humanresources.domain.organization.QuerySkillProjectVO;
import com.isoftstone.humanresources.domain.warn.HealthCheckEntity;
import com.isoftstone.humanresources.service.OrganizationService;
import com.isoftstone.humanresources.util.StringUtil;
import io.swagger.annotations.Api;

@ResponseBody
@Controller
@RequestMapping(value = "/hr_manager/organization")
@Api(value = "组织管理API")
public class OrganizationController {

    private final static Logger logger = LoggerFactory.getLogger(OrganizationController.class);
    @Autowired
    private OrganizationService organizationService;

    /**
     * 根据organizationID获取组织的基本信息
     *
     * @param organizationID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/organization_info", method = RequestMethod.GET)
    public ResponseEntity<OrganizationInformation> getUserInfo(@RequestParam(name = "organizationID") String organizationID) {

        if (StringUtil.isEmpty(organizationID)) {
            logger.error("request param is null !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        OrganizationInformation information = organizationService.queryOrganizationByID(organizationID);
        if (null == information) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(information, HttpStatus.OK);
    }

    /**
     * 根据ID获取其下边的子节点信息
     *
     * @param organizationID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/get_child_organization_infos", method = RequestMethod.GET)
    public ResponseEntity<List<OrganizationInformation>> queryChildsByID(@RequestParam(name = "organizationID") String organizationID) {

        if (StringUtil.isEmpty(organizationID)) {
            logger.error("request param is null !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<OrganizationInformation> informationList = organizationService.queryChildsByID(organizationID);
        if (CollectionUtils.isEmpty(informationList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    /**
     * 根据ID获取该组织的健康度信息
     *
     * @param organizationID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/health_check", method = RequestMethod.GET)
    public ResponseEntity<List<HealthCheckEntity>> queryHealthByID(@RequestParam(name = "organizationID") String organizationID) {

        if (StringUtil.isEmpty(organizationID)) {
            logger.error("request param is null !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<HealthCheckEntity> informationList = organizationService.queryHealthCheckByID(organizationID);
        if (CollectionUtils.isEmpty(informationList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    /**
     * 批量导入部门信息
     *
     * @param file
     * @param request
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/importExclOrganization")
    public ResponseEntity<String> importExclOrganization(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String returnStr;
        try {
            if (file.isEmpty()) {
                returnStr = "文件不存在！";
                return new ResponseEntity<>(returnStr, HttpStatus.OK);
            }
            returnStr = organizationService.importExcelOrganization(file);
            returnStr += "导入成功";
        } catch (Exception e) {
            returnStr = e.toString();
            logger.error(e.toString());
        }
        return new ResponseEntity<>(returnStr, HttpStatus.OK);
    }

    /**
     * 获取组织树
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/getTreeOrganization", method = RequestMethod.GET)
    public ResponseEntity<List<OrganizationTreeVO>> getTreeOrganization(@RequestParam(name = "organizationID") String organizationID, @RequestParam(name = "treeType") String treeType) {
        List<OrganizationTreeVO> newList = organizationService.getTreeOrganization(organizationID, treeType);
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    /**
     * 下载excl文件
     *
     * @return
     */
    @RequestMapping(value = "/loadExclOrganization", method = RequestMethod.GET)
    public ResponseEntity<String> loadExclOrganization(@RequestParam(name = "employeeID") String employeeID, HttpServletResponse response, HttpServletRequest request) {
        String returnStr = null;
        try {
            organizationService.loadExclOrganization(response, request, employeeID);
        } catch (IOException e) {
            returnStr = e.toString();
            logger.error(e.toString());
        }
        return new ResponseEntity<>(returnStr, HttpStatus.OK);
    }

    /**
     * 获取BU信息
     *
     * @param organizationID
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/toObtainBU")
    public ResponseEntity<List<OrganizationInformation>> toObtainBU(@RequestParam(name = "organizationID") String organizationID) {
        List<OrganizationInformation> orgList = null;
        orgList = organizationService.toObtainBU(organizationID);
        return new ResponseEntity<>(orgList, HttpStatus.OK);
    }

    /**
     * 获取员工所在的部门ID
     *
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/getOrganizationID")
    public ResponseEntity<String> getOrganizationID(@RequestParam(name = "employeeID") String employeeID) {
        String organizationID = null;
        organizationID = "\"" + organizationService.getOrganizationID(employeeID) + "\"";
        return new ResponseEntity<>(organizationID, HttpStatus.OK);
    }

    /**
     * 组织新增
     *
     * @param organizationInfo
     * @param response
     * @param request
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/addOrganization")
    public ResponseEntity<Map<String, Object>> addOrganization(@RequestBody OrganizationInformation organizationInfo, HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = organizationService.addOrganization(organizationInfo);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 新增组织校验
     *
     * @param organizationInfo
     * @param response
     * @param request
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/addCheckOrg")
    public ResponseEntity<Map<Object, Object>> addCheckOrg(@RequestBody OrganizationInformation organizationInfo, HttpServletResponse response, HttpServletRequest request) {
        Map<Object, Object> returnMap = new HashMap<>();
        String returnStr = organizationService.addCheckOrg(organizationInfo);
        if (StringUtil.isEmpty(returnStr)) {
            returnMap.put("Status", true);
            return new ResponseEntity<>(returnMap, HttpStatus.OK);
        }
        returnMap.put("Status", false);
        returnMap.put("returnStr", returnStr);
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }

    /**
     * 查询部门列表
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/queryOrgInforList")
    public ResponseEntity<List<OrganizationInfoVO>> queryOrgInforList(@RequestParam(name = "name") String name) {
        List<OrganizationInfoVO>
                orgList = organizationService.queryOrgInforList(name);
        return new ResponseEntity<>(orgList, HttpStatus.OK);
    }

    /**
     * 查询负责人工号和姓名
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/queryLeader")
    public ResponseEntity<List<QueryLeaderVO>> queryLeader(@RequestParam(name = "name") String name) {
        List<QueryLeaderVO> queryLeaderList = organizationService.queryLeaderList(name);
        return new ResponseEntity<>(queryLeaderList, HttpStatus.OK);
    }

    /**
     * 查询项目状态配置信息
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/getConfigInfo")
    public ResponseEntity<List<SystemConfigInformation>> getConfigInfo(@RequestParam(name = "configType") String configType) {
        List<SystemConfigInformation> queryConfigList = organizationService.queryConfig(configType);
        return new ResponseEntity<>(queryConfigList, HttpStatus.OK);
    }

    /**
     * 修改项目信息
     *
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/update_organization")
    public ResponseEntity<Map<String, Object>> updateOrganization(@RequestBody OrganizationUpdatePersonVO organizationUpdatePersonVO, HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = organizationService.updateOrganization(organizationUpdatePersonVO);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 新增po项目
     *
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/add_project_po")
    public ResponseEntity<Map<String, Object>> addProjectPO(@RequestBody OrganizationInformation organizationInfo, HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = organizationService.addProjectPO(organizationInfo);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 查询po下项目
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/query_project_po")
    public ResponseEntity<List<OrganizationInformation>> queryProjectPO(@RequestParam(name = "organizationID") String organizationID, @RequestParam(name = "queryType") String queryType, @RequestParam(name = "organizationStatus") String organizationStatus) {
        List<OrganizationInformation> orgList = organizationService.queryProjectPO(organizationID, queryType, organizationStatus);
        return new ResponseEntity<>(orgList, HttpStatus.OK);
    }

    /**
     * 查询个技能分组下项目信息
     *
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/query_skill_message")
    public ResponseEntity<List<QuerySkillProjectVO>> querySkillMessage(@RequestBody OrganizationInformation organizationInfo, HttpServletResponse response, HttpServletRequest request) {
        List<QuerySkillProjectVO> listSkillProject =
                organizationService.querySkillMessage(organizationInfo.getOrganizationgroupID(), organizationInfo.getSkill(), organizationInfo.getLeader());
        return new ResponseEntity<>(listSkillProject, HttpStatus.OK);
    }

    /**
     * 查询人员备份信息
     *
     * @param page
     * @param pageSize
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_employee_backups", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<EmployeeBackups>> queryEmployeeBackups(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam("leader") String leader) {
        logger.info("- - -查询人员备份的请求参数- - -{},{}，{}", page, pageSize, leader);
        PageInfo<EmployeeBackups> employeeBackupsPageInfo = null;
        try {
            if (null == page || null == pageSize) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            employeeBackupsPageInfo = organizationService.queryEmployeeBackups(page, pageSize, leader);
            if (null == employeeBackupsPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询日志异常-  - -", e);
        }
        return new ResponseEntity<>(employeeBackupsPageInfo, HttpStatus.OK);
    }

    /**
     * 查询备份类型下拉框
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_backup_name", method = RequestMethod.GET)
    public ResponseEntity<List<SysConfigResponse>> queryBackupName() {
        List<SysConfigResponse> responseList = null;
        try {
            responseList = organizationService.queryBackupName();
            if (CollectionUtils.isEmpty(responseList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询备份类型异常-  - -", e);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    /**
     * 新增人员备份列表
     *
     * @param employeeBackups
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_employee_backups", method = RequestMethod.POST)
    public ResponseEntity<Result> addEmployeeBackups(@RequestBody EmployeeBackups employeeBackups) {
        logger.info("- - -新增人员备份的的请求参数- - -{}", employeeBackups);
        Result result = null;
        try {
            if (null == employeeBackups) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = organizationService.addEmployeeBackups(employeeBackups);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - - 新增人员备份异常- - -", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新人员备份信息
     *
     * @param employeeBackups
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_employee_backups", method = RequestMethod.POST)
    public ResponseEntity<Result> updateEmployeeBackups(@RequestBody EmployeeBackups employeeBackups) {
        Result result = null;
        try {
            if (null == employeeBackups) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = organizationService.updateEmployeeBackups(employeeBackups);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - - 更新人员备份异常- - -", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 查询CuHead下拉框列表
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_cuhead_list", method = RequestMethod.GET)
    public ResponseEntity<List<QueryCuheadResponse>> queryCuHeadList() {
        logger.info("- - - 查询CuHead下拉框列表controller- - -");
        List<QueryCuheadResponse> cuHeadList = null;
        try {
            cuHeadList = organizationService.queryCuHeadList();
            if (StringUtils.isEmpty(cuHeadList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - - 查询CuHead下拉框列表异常- - -", e);
        }
        return new ResponseEntity<>(cuHeadList, HttpStatus.OK);
    }

    /**
     * 查询po项目详情
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/query_project_po_info")
    public ResponseEntity<QueryProjectPoVO> queryProjectPOInfo(@RequestParam(name = "organizationID") String organizationID) {
        QueryProjectPoVO querypro = organizationService.queryProjectPOInfo(organizationID);
        return new ResponseEntity<>(querypro, HttpStatus.OK);
    }

    /**
     * 修改po项目
     *
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/update_project_po")
    public ResponseEntity<Map<String, Object>> updateProjectPO(@RequestBody OrganizationInformation organizationInfo, HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = organizationService.updateProjectPO(organizationInfo);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 查询项目进度
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/query_progress")
    public ResponseEntity<List<QueryProgressResponse>> queryProgress(String organizationID, String organizationType) {
        logger.info("- - - 查询项目进度- - -{}，{}", organizationID, organizationType);
        List<QueryProgressResponse> list = null;
        try {
            if (StringUtils.isEmpty(organizationID) || StringUtils.isEmpty(organizationType)) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            list = organizationService.queryProjectProgress(organizationID, organizationType);
            if (CollectionUtils.isEmpty(list)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - - 查询项目进度异常- - -", e);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    /**
     * 查询CU下面的项目信息
     *
     * @param organizationID
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/query_cu_progress")
    public ResponseEntity<List<OrganizationInformation>> queryCuProgress(String organizationID) {
        logger.info("- - -查询CU下面的项目信息 - - -，{}", organizationID);
        List<OrganizationInformation> cuOrg = null;
        try {
            cuOrg = organizationService.queryCuOrg(organizationID);
            if (StringUtils.isEmpty(cuOrg)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - - 查询CU下面的项目信息 - - -", e);
        }

        return new ResponseEntity<>(cuOrg, HttpStatus.OK);

    }

    /**
     * 导入excel备份人员信息
     *
     * @param file
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/import_excel_empBackups", method = RequestMethod.POST)
    public ResponseEntity<Result> importExcelEmpBackups(MultipartFile file) {
        logger.error("- - - 导入excel备份人员信息controller接入参数- - -{}", file);
        Result result = null;
        try {
            if (null == file) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = organizationService.importExcelEmpBackups(file);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (IOException e) {
            logger.error("- - -导入excel备份人员信息 - - -", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 导出excel备份人员信息
     *
     * @param request
     * @param response
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/export_excel_empBackups", method = RequestMethod.GET)
    public ResponseEntity<Result> exportExcelEmpBackups(HttpServletRequest request, HttpServletResponse response) {
        logger.error("- - - 导出excel备份人员信息controller- - -");
        request.getSession();
        Result result = null;
        try {
            result = organizationService.exportExcelEmpBackups(response);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -导出excel备份人员信息 - - -", e);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
