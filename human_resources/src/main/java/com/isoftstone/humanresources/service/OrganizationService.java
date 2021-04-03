package com.isoftstone.humanresources.service;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isoftstone.humanresources.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.organization.OrganizationInfoVO;
import com.isoftstone.humanresources.domain.organization.OrganizationTreeVO;
import com.isoftstone.humanresources.domain.organization.OrganizationUpdatePersonVO;
import com.isoftstone.humanresources.domain.organization.QueryLeaderVO;
import com.isoftstone.humanresources.domain.organization.QueryProjectPoVO;
import com.isoftstone.humanresources.domain.organization.QuerySkillProjectVO;
import com.isoftstone.humanresources.domain.warn.HealthCheckEntity;
public interface OrganizationService {
    OrganizationInformation queryOrganizationByID(String organizationID);
    List<OrganizationInformation> queryChildsByID(String organizationID);
    List<HealthCheckEntity> queryHealthCheckByID(String organizationID);
    List<OrganizationInformation> getChildOrgInfo(String organizationID);
    /**
     * 批量导入部门信息接口
     * @param file
     * @return
     */
    String importExcelOrganization(MultipartFile file) throws Exception;
    /**
     * 查询组织树接口.
     * @return
     */
    List<OrganizationTreeVO> getTreeOrganization(String employeeID,String treeType);
    /**
     * 模板下载接口
     * @param response
     * @param request
     */
    void loadExclOrganization(HttpServletResponse response,HttpServletRequest request,String employeeID) throws IOException;
    /**
     * 查询部门BU信息
     * @param organizationID
     * @return
     */
    List<OrganizationInformation> toObtainBU(String organizationID);
    /**
     * 获取用户所在的组织ID
     * @param employeeID
     * @return
     */
    String getOrganizationID(String employeeID);
    /**
     * 新增组织
     * @param organizationInfo
     * @return
     */
    Map<String, Object> addOrganization(OrganizationInformation organizationInfo);
    /**
     * 新增组织校验
     * @param organizationInfo
     * @return
     */
    String addCheckOrg(OrganizationInformation organizationInfo);
    /**
     * 查询全量部门信息
     * @return
     */
    List<OrganizationInfoVO> queryOrgInforList(String name);
    /**
     * 查询负责人账号和姓名
     * @return
     */
    List<QueryLeaderVO> queryLeaderList(String name);
    /**
     * 查询配置信息
     * @return
     */
    List<SystemConfigInformation> queryConfig(String configType);
    /**
     * 修改组织信息
     * @param organizationInfo
     * @return
     */
    Map<String, Object> updateOrganization(OrganizationUpdatePersonVO organizationUpdatePersonVO);
    /**
     * 新增项目组po
     * @param po
     * @param organizationID
     * @return
     */
    Map<String, Object> addProjectPO(OrganizationInformation organizationInfo);
    /**
     * 查询下项目组信息
     * @param PO
     * @return
     */
    List<OrganizationInformation> queryProjectPO(String organizationID,String queryType,String organizationStatus);
    /**
     * 查询技能下项目信息
     * @param organizationGroupId
     * @param skill
     * @return
     */
    List<QuerySkillProjectVO> querySkillMessage(String organizationGroupId,String skill,String leader);
    /**
     * 分页查询人员备份信息
     * @return
     * @throws Exception
     */
    PageInfo<EmployeeBackups> queryEmployeeBackups(Integer page,Integer pageSize,String leader) throws Exception;
    /**
     * 查询备份类型下拉框
     * @return
     * @throws Exception
     */
    List<SysConfigResponse> queryBackupName()throws Exception;
    /**
     * 修改项目组po
     * @param po
     * @param organizationID
     * @return
     */
    Map<String, Object> updateProjectPO(OrganizationInformation organizationInfo);
    /**
     * 修改po信息回填
     * @param organizationID
     * @return
     */
    QueryProjectPoVO queryProjectPOInfo(String organizationID);
    /**
     * 新增人员备份
     * @param employeeBackups
     * @throws Exception
     */
    Result addEmployeeBackups(EmployeeBackups employeeBackups) throws Exception;
    /**
     * 更改人员备份
     * @param employeeBackups
     * @return
     * @throws Exception
     */
    Result updateEmployeeBackups(EmployeeBackups employeeBackups) throws Exception;
    /**
     * 查询cuhead下拉框
     * @return
     * @throws Exception
     */
    List<QueryCuheadResponse> queryCuHeadList() throws Exception;

    /**
     * 查询cu下面的项目组信息
     * @param organizationID
     * @return
     * @throws Exception
     */
    List<OrganizationInformation> queryCuOrg(@Param("organizationID") String organizationID) throws Exception;
    /**
     * 查询项目组的名称和值
     * @param organizationID
     * @param organizationType
     * @return
     * @throws Exception
     */
    List<QueryProgressResponse> queryProjectProgress(String organizationID, String organizationType)throws Exception;
    /**
     * 导出人员备份信息
     * @param file
     * @return
     * @throws IOException
     */
    Result importExcelEmpBackups(MultipartFile file) throws IOException;
    /**
     * 导入人员备份信息
     * @param response
     * @return
     * @throws Exception
     */
    Result exportExcelEmpBackups(HttpServletResponse response) throws Exception;
}
