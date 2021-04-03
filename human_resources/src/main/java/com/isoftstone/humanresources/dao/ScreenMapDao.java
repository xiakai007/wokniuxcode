package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.OrganizationInformation;
import com.isoftstone.humanresources.domain.screen.EmployeeBackUpEntity;
import com.isoftstone.humanresources.domain.screen.EntryLeaveTopEntity;
import com.isoftstone.humanresources.domain.screen.ScreenMapEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScreenMapDao {
    /**
     * 获取人员分布信息，地图
     * @param organizationType
     * @param organizationID
     * @return
     */
    List<ScreenMapEntity> queryScreenMapEntity(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);

    /**
     * 获取性别比例信息
     * @param organizationType
     * @param organizationID
     * @return
     */
    List<ScreenMapEntity> getSexDistribution(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);

    /**
     * 获取技能分布信息
     * @param organizationType
     * @param organizationID
     * @return
     */
    List<ScreenMapEntity> getSkillDistribution(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);

    /**
     * 获取华为等级分布信息
     * @param organizationType
     * @param organizationID
     * @return
     */

    List<ScreenMapEntity> getHuaweiLevelDistribution(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);

    /**
     * 按月统计离职信息
     * @param organizationType
     * @param organizationID
     * @return
     */
    List<ScreenMapEntity> getLeaveDistributionByMonth(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);
    /**
     * 按月统计入职信息
     * @param organizationType
     * @param organizationID
     * @return
     */
    List<ScreenMapEntity> getEntryDistributionByMonth(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);

    /**
     * 按周统计离职信息
     * @param organizationType
     * @param organizationID
     * @return
     */

    List<ScreenMapEntity> getLeaveDistributionByWeek(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);

    /**
     * 按周统计入职信息
     * @param organizationType
     * @param organizationID
     * @return
     */

    List<ScreenMapEntity> getEntryDistributionByWeek(@Param("organizationType")String organizationType, @Param("organizationID")String organizationID);

    /**
     * 获取人员备份计划
     * @param list
     * @return
     */

    List<EmployeeBackUpEntity> getBackUpDistribution(@Param("list")List<OrganizationInformation> list);

    /**
     * 获取入职的Top信息，按月
     * @param leaveOrEntryMonth
     * @param leaveOrEntryStr
     * @param organizationType
     * @return
     */
    List<EntryLeaveTopEntity> getEntryTopByMonth(@Param("leaveOrEntryMonth")String leaveOrEntryMonth, @Param("leaveOrEntryStr")String leaveOrEntryStr,@Param("organizationType")String organizationType,@Param("organizationID")String organizationID,@Param("childOrgType")String childOrgType);

    /**
     * 获取离职的Top信息，按月
     * @param leaveOrEntryMonth
     * @param leaveOrEntryStr
     * @param organizationType
     * @return
     */
    List<EntryLeaveTopEntity> getLeaveTopByMonth(@Param("leaveOrEntryMonth")String leaveOrEntryMonth, @Param("leaveOrEntryStr")String leaveOrEntryStr,@Param("organizationType")String organizationType,@Param("organizationID")String organizationID,@Param("childOrgType")String childOrgType);

    /**
     * 获取入职的Top信息，按周
     * @param leaveOrEntryWeek
     * @param leaveOrEntryStr
     * @param organizationType
     * @return
     */
    List<EntryLeaveTopEntity> getEntryTopByWeek(@Param("leaveOrEntryWeek")String leaveOrEntryWeek, @Param("leaveOrEntryStr")String leaveOrEntryStr,@Param("organizationType")String organizationType,@Param("organizationID")String organizationID,@Param("childOrgType")String childOrgType);

    /**
     * 获取离职的Top信息，按周
     * @param leaveOrEntryWeek
     * @param leaveOrEntryStr
     * @param organizationType
     * @return
     */
    List<EntryLeaveTopEntity> getLeaveTopByWeek(@Param("leaveOrEntryWeek")String leaveOrEntryWeek, @Param("leaveOrEntryStr")String leaveOrEntryStr,@Param("organizationType")String organizationType,@Param("organizationID")String organizationID,@Param("childOrgType")String childOrgType);

    /**
     * 查询cu权限
     * @param employeeId
     * @return
     */
    List<OrganizationInformation> getCuInfoList(@Param("employeeId") String employeeId);
}
