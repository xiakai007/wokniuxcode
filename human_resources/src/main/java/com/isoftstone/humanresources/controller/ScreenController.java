package com.isoftstone.humanresources.controller;

import com.isoftstone.humanresources.domain.OrganizationInformation;
import com.isoftstone.humanresources.domain.screen.*;
import com.isoftstone.humanresources.service.ScreenMapService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/hr_manager/screen")
@Api(value = "大屏显示API")
public class ScreenController {

    private final static Logger logger = LoggerFactory.getLogger(ScreenController.class);
    @Autowired
    private ScreenMapService screenMapService;

    /**
     * 获取人员分布的信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_employee_distribution")
    @ApiOperation(value="获取人员分布的信息", notes="员工的区域分布")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "organizationID", value = "组织编码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "organizationType", value = "组织类型", required = true, dataType = "String")
    })
    public ResponseEntity<List<ScreenMapEntity>> getEmployeeDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                         @RequestParam(name = "organizationType") String organizationType) {
        List<ScreenMapEntity> screenMapEntityList = screenMapService.queryUserMapEntity(organizationID, organizationType);
        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }

    /**
     * 获取项目组或部门的性别分布的信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_sex_distribution")
    public ResponseEntity<List<ScreenMapEntity>> getSexDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                    @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScreenMapEntity> screenMapEntityList = screenMapService.getSexDistribution(organizationID, organizationType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }

    /**
     * 获取项目组或部门的年龄分布的信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_age_distribution")
    public ResponseEntity<List<ScreenMapEntity>> getAgeDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                    @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScreenMapEntity> screenMapEntityList = screenMapService.getAgeDistribution(organizationID, organizationType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }

    /**
     * 获取项目组或部门的司龄分布的信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_entry_age_distribution")
    public ResponseEntity<List<ScreenMapEntity>> getEntryAgeDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                         @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScreenMapEntity> screenMapEntityList = screenMapService.getEntryAgeDistribution(organizationID, organizationType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }


    /**
     * 获取项目组或部门的技能分布的信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_skill_distribution")
    public ResponseEntity<List<ScreenMapEntity>> getSkillDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                      @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScreenMapEntity> screenMapEntityList = screenMapService.getSkillDistribution(organizationID, organizationType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }


    /**
     * 获取项目组或部门的华为级别分布的信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_huawei_level_distribution")
    public ResponseEntity<List<ScreenMapEntity>> getHuaweiLevelDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                            @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScreenMapEntity> screenMapEntityList = screenMapService.getHuaweiLevelDistribution(organizationID, organizationType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }

    /**
     * 获取项目组或部门的入职趋势信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_entry_employee")
    public ResponseEntity<List<EntryLeaveEntity>> getEntryDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                       @RequestParam(name = "organizationType") String organizationType,
                                                                       @RequestParam(name = "dateType") String dateType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)|| StringUtil.isEmpty(dateType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (CommonConstant.DATE_TYPE_MONTH.equals(dateType)&&CommonConstant.DATE_TYPE_WEEK.equals(dateType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<EntryLeaveEntity> screenMapEntityList = screenMapService.getEntryDistribution(organizationID, organizationType,dateType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }

    /**
     * 获取项目组或部门的离职趋势信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_leave_employee")
    public ResponseEntity<List<EntryLeaveEntity>> getLeaveDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                       @RequestParam(name = "organizationType") String organizationType,
                                                                       @RequestParam(name = "dateType") String dateType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)|| StringUtil.isEmpty(dateType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (CommonConstant.DATE_TYPE_MONTH.equals(dateType)&&CommonConstant.DATE_TYPE_WEEK.equals(dateType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<EntryLeaveEntity> screenMapEntityList = screenMapService.getLeaveDistribution(organizationID, organizationType,dateType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }


    /**
     * 获取人员备份信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_employee_backup")
    public ResponseEntity<List<EmployeeBackUpEntity>> getBackUpDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                            @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<EmployeeBackUpEntity> backUpEntityList = screenMapService.getBackUpDistribution(organizationID, organizationType);

        if (CollectionUtils.isEmpty(backUpEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(backUpEntityList, HttpStatus.OK);
    }


    /**
     * 获取告警信息的信息
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_screen_warn")
    public ResponseEntity<List<ScreenWarnEntity>> getScreenWarn(@RequestParam(name = "organizationID") String organizationID,
                                                                @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ScreenWarnEntity> screenMapEntityList = screenMapService.getScreenWarn(organizationID, organizationType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }

    /**
     * 获取绩效信息的分布
     *
     * @param organizationID
     * @param organizationType
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_performance_distribution")
    public ResponseEntity<List<EmployeePerformanceEntity>> getPerformanceDistribution(@RequestParam(name = "organizationID") String organizationID,
                                                                                      @RequestParam(name = "organizationType") String organizationType) {
        if (StringUtil.isEmpty(organizationID) || StringUtil.isEmpty(organizationType)) {
            logger.error(CommonConstant.REQUEST_IS_NULL);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<EmployeePerformanceEntity> screenMapEntityList = screenMapService.getPerformanceDistribution(organizationID, organizationType);

        if (CollectionUtils.isEmpty(screenMapEntityList)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(screenMapEntityList, HttpStatus.OK);
    }
    
    /**
     * 查询cu权限信息
     * @param employeeId
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/get_cu_info_list")
    public ResponseEntity<List<OrganizationInformation>> getCuInfoList(@RequestParam(name="employeeId") String employeeId){
    	List<OrganizationInformation> cuInfoList = 
    			screenMapService.getCuInfoList(employeeId);
    	 return new ResponseEntity<>(cuInfoList, HttpStatus.OK);
    }

}
