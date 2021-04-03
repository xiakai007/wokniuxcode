package com.isoftstone.humanresources.service;

import java.util.List;

import com.isoftstone.humanresources.domain.OrganizationInformation;
import com.isoftstone.humanresources.domain.screen.EmployeeBackUpEntity;
import com.isoftstone.humanresources.domain.screen.EmployeePerformanceEntity;
import com.isoftstone.humanresources.domain.screen.EntryLeaveEntity;
import com.isoftstone.humanresources.domain.screen.ScreenMapEntity;
import com.isoftstone.humanresources.domain.screen.ScreenWarnEntity;

public interface ScreenMapService {

    List<ScreenMapEntity> queryUserMapEntity(String organizationID,String organizationType);

    List<ScreenMapEntity> getSexDistribution(String organizationID,String organizationType);

    List<ScreenMapEntity> getAgeDistribution(String organizationID,String organizationType);

    List<ScreenMapEntity> getEntryAgeDistribution(String organizationID,String organizationType);

    List<ScreenMapEntity> getSkillDistribution(String organizationID, String organizationType);

    List<ScreenMapEntity> getHuaweiLevelDistribution(String organizationID,String organizationType);

    List<EntryLeaveEntity> getEntryDistribution(String organizationID, String organizationType,String dateType);

    List<EntryLeaveEntity> getLeaveDistribution(String organizationID, String organizationType,String dateType);

    List<EmployeeBackUpEntity> getBackUpDistribution(String organizationID, String organizationType);

    List<ScreenWarnEntity> getScreenWarn(String organizationID , String organizationType);

    List<EmployeePerformanceEntity> getPerformanceDistribution(String organizationID, String organizationType);

    /**
     * 查询cu权限
     * @param employeeId
     * @return
     */
    List<OrganizationInformation> getCuInfoList(String employeeId);
}
