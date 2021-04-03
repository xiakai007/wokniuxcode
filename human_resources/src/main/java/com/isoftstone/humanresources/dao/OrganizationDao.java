package com.isoftstone.humanresources.dao;
import java.util.Date;
import java.util.List;
import com.isoftstone.humanresources.domain.*;
import org.apache.ibatis.annotations.Param;
import com.isoftstone.humanresources.domain.organization.OrganizationInfoVO;
import com.isoftstone.humanresources.domain.organization.OrganizationUpdatePersonVO;
import com.isoftstone.humanresources.domain.organization.QueryLeaderVO;
import com.isoftstone.humanresources.domain.organization.QuerySkillProjectVO;
public interface OrganizationDao {
    OrganizationInformation queryOrganizationByID(@Param("organizationID") String organizationID);
    /**
     * 获取ID下的子节点
     *
     * @param organizationID
     * @return
     */
    List<OrganizationInformation> queryChildsByID(@Param("organizationID") String organizationID);
    List<HealthCheckInformation> queryHealthCheckByID(@Param("organizationID") String organizationID, @Param("ruleType") String ruleType);
    /**
     * 批量导入部门信息
     *
     * @param listOrg
     * @return
     */
    int importExcelOrganization(@Param("listOrg") List<OrganizationInformation> listOrg);
    /**
     * 查询全量部门和项目信息
     *
     * @return
     */
    List<OrganizationInformation> getTreeOrganization();
    OrganizationInformation getParentId(@Param("employeeID") String employeeID);
    /**
     * 查询BU
     *
     * @param organizationID
     * @return
     */
    List<OrganizationInformation> toObtainBU(@Param("organizationID") String organizationID);
    /**
     * 获取用户所在的组织ID
     *
     * @param employeeID
     * @return
     */
    String getOrganizationID(@Param("employeeID") String employeeID);
    /**
     * 校验组织名
     *
     * @param organizationName
     * @return
     */
    int checkOrgName(@Param("organizationName") String organizationName);
    /**
     * 校验组织是否存在
     *
     * @param organizationID
     * @return
     */
    int checkOrg(@Param("organizationID") String organizationID);
    /**
     * 查询全量部门信息
     *
     * @return
     */
    List<OrganizationInfoVO> queryOrgInforList(@Param("name") String name);
    /**
     * 组织新增
     *
     * @param organizationInfo
     * @return
     */
    int addOrganizationInfo(OrganizationInformation organizationInfo);
    /**
     * 查询负责人账号和姓名
     *
     * @return
     */
    List<QueryLeaderVO> queryLeaderList(@Param("name") String name);
    /**
     * 修改组织信息
     *
     * @param organizationInfo
     * @return
     */
    int updateOrganization(OrganizationInformation organizationInfo);
    /**
     * 组织健康度新增
     *
     * @param healthCheckInformation
     * @return
     */
    int addHealthCheckInfor(@Param("listCheck") List<HealthCheckInformation> listCheck);
    /**
     * 组织健康度修改
     *
     * @param healthCheckInformation
     * @return
     */
    int updateHealthCheckInfor(@Param("listCheck") List<HealthCheckInformation> listCheck);
    /**
     * 查询条数
     *
     * @param organizationID
     * @param ruleType
     * @param ruleName
     * @return
     */
    int healthCheckByID(@Param("organizationID") String organizationID, @Param("ruleType") String ruleType, @Param("ruleName") String ruleName);
    /**
     * 修改项目组po
     *
     * @param po
     * @param organizationID
     * @return
     */
    int updateProjectPO(@Param("orgInfo") OrganizationInformation orgInfo);
    /**
     * 查询技能列表
     *
     * @return
     */
    List<OrganizationInformation> getTreeOrganizationSkill();
    /**
     * 查询下项目组信息
     *
     * @param PO
     * @return
     */
    List<OrganizationInformation> queryProjectPO(String organizationID);
    /**
     * 查询leader下的项目信息
     *
     * @param organizationID
     * @return
     */
    List<OrganizationInformation> queryProjectLeader(String organizationID,String organizationStatus);
    /**
     * 查询技能下项目信息
     *
     * @param organizationGroupId
     * @param skill
     * @return
     */
    List<QuerySkillProjectVO> querySkillMessage(@Param("organizationGroupId") String organizationGroupId, @Param("skill") String skill, @Param("leader") String leader);
    /**
     * 查询员工信息
     *
     * @param projectTeam
     * @param skill
     * @return
     */
    List<EmployeeInformation> queryempList(@Param("projectTeam") String projectTeam, @Param("skill") String skill);
    /**
     * 分页查询人员备份信息
     *
     * @return
     * @throws Exception
     */
    List<EmployeeBackups> queryEmployeeBackups(@Param("leader") String leader) throws Exception;
    /**
     * 查询备份类型的下拉框
     *
     * @return
     * @throws Exception
     */
    List<SysConfigResponse> queryBackupName() throws Exception;
    List<OrganizationInformation> queryPOProjectInfo(@Param("PO") String PO);
    /**
     * 新增备份人员信息
     *
     * @param employeeBackups
     * @throws Exception
     */
    void addEmployeeBackups(EmployeeBackups employeeBackups) throws Exception;

    String queryCUBypm(Integer pm) throws Exception;
    /**
     * 更新备份人员信息
     * @param employeeBackups
     * @throws Exception
     */
    void updateEmployeeBackups(EmployeeBackups employeeBackups) throws Exception;
    /**
     * 新增人员入历史表
     * @param employeeBackups
     * @return
     * @throws Exception
     */
    void addEmployeeBackupsHistory(EmployeeBackups employeeBackups) throws Exception;
    /**
     * 修改人员入历史表
     * @param employeeBackups
     * @return
     * @throws Exception
     */
    void updateEmployeeBackupsHistory(EmployeeBackups employeeBackups) throws Exception;
    /**
     * 修改项目人员组成
     * @param organizationInfo
     * @return
     */
    int updateProjectPerson(@Param("personList") List<OrganizationUpdatePersonVO> personList);
    /**
     * 根据leader查询PO信息
     * @param leader
     * @return
     */
    OrganizationInformation getPoInfoByLeader(@Param("leader") String leader,
    		@Param("organizationID") String organizationID,@Param("parentID") String parentID);
    /**
     * 查询cuhead下拉框列表
     * @return
     * @throws Exception
     */
    List<QueryCuheadResponse> queryCuHeadList() throws Exception;
    /**
     * BD BU根据cu字段查询项目备份进度
     * @param organizationID
     * @return
     * @throws Exception
     */
    String queryCuProgress(@Param("organizationID") String organizationID) throws Exception;
    /**
     * 查询CU下面的项目组信息
     * @param organizationID
     * @return
     * @throws Exception
     */
    List<OrganizationInformation> queryOrg(@Param("organizationID") String organizationID) throws Exception;
    /**
     * 根据项目id查询项目备份进度
     * @param organizationID
     * @return
     * @throws Exception
     */
    String queryProgress(@Param("organizationID") String organizationID) throws Exception;

    /**
     * 查询项目组下面的成员
     * @param organizationID
     * @return
     * @throws Exception
     */
    List<EmployeeInformation> queryEmp(@Param("organizationID")String organizationID) throws Exception;
    /**
     * 查询成员的项目备份进度
     * @param employeeID
     * @return
     * @throws Exception
     */
    String queryPersonProgress(@Param("employeeID") Integer employeeID)throws Exception;
    /**
     * 查询备份详情
     * @param organizationID
     * @return
     * @throws Exception
     */
    List<EmployeeBackups> queryBackupDetail(@Param("organizationID")String organizationID)throws Exception;
    /**
     * 批量插入备份数据
     * @param list
     * @throws Exception
     */
    void importExcelEmployeeBackups(@Param("list") List<EmployeeBackups> list) throws Exception;
    /**
     * 删除备份表
     * @throws Exception
     */
    void deleteEmployeeBackups()throws Exception;
    /**
     * 查询备份信息
     * @return
     * @throws Exception
     */
    List<EmployeeBackups> queryEmployeeBackupsforExcel() throws Exception;
    /**
     * 查询备份完成的信息
     * @return
     * @throws Exception
     */
    List<EmployeeBackups> queryCompleteEmployeeBackups(String date) throws Exception;
    /**
     * 查询cu权限
     * @param employeeId
     * @return
     */
    List<OrganizationInformation> getCuInfoList(@Param("organizationID") String organizationID);
}
