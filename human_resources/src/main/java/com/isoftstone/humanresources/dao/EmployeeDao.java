package com.isoftstone.humanresources.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.isoftstone.humanresources.domain.*;
import org.apache.ibatis.annotations.Param;

import com.isoftstone.humanresources.domain.screen.EmployeePerformanceEntity;
import com.isoftstone.humanresources.domain.useremployee.SkillInVO;
import com.isoftstone.humanresources.domain.useremployee.UserEmployeeVO;

public interface EmployeeDao {

    List<EmployeeInformation> queryByOrganizationID(@Param("organizationID")String organizationID, @Param("organizationType")String organizationType);

    List<EmployeePerformanceEntity> getPerformanceDistribution(@Param("list")List<OrganizationInformation> list);

    /**
     * 批量导入员工信息
     * @param listOrg
     * @return
     */
    int importExcelEmployee(@Param("listOrg") List<EmployeeInformation> listOrg);
    
    /**
     * 新增用户
     * @param userList
     * @return
     */
    int addUser(@Param("userList") List<User> userList);

    /**
     * 查询员工最近两年绩效信息
     * @param employeeID
     * @return
     */
    List<EmployeePerformanceInformation> queryPerformance(@Param("employeeID") long employeeID);
    
    /**
     * 查询员工项目经历
     * @param employeeID
     * @return
     */
    List<EmployeeProjectInformation> queryProject(@Param("employeeID") long employeeID) throws Exception;
    
    /**
     * 查询员工技能列表
     * @param employeeID
     * @return
     */
    List<SkillInVO> querySkill(@Param("employeeID") long employeeID);

    /**
     * 新增员工技能列表
     * @param skillInVOList
     * @return
     */
     int addEmployeeSkill(@Param("skillInVOList") List<SkillInVO> skillInVOList);

    /**
     * 修改员工技能
     * @param skillInVO
     * @return
     */
    int updateEmployeeSkill( SkillInVO skillInVO);
    
    /**
     * 查询员工工时列表
     * @param employeeID
     * @return
     */
    List<EmployeeWorkTimeDayInformation> queryWorkTimeDay(@Param("employeeID") long employeeID);
    
    /**
     * 查询员工信息
     * @param employeeID
     * @return
     */
    UserEmployeeVO queryUserInfo(@Param("employeeID") long employeeID);
    
    /**
     * 查询员工信息
     * @param employeeID
     * @return
     */
    EmployeeInformation queryEmployeeInfo(@Param("employeeID") long employeeID);
    
    /**
     * 查询员工月工时信息
     * @param employeeID
     * @return
     */
    List<EmployeeWorkTimeMonthInfomation> queryMonthList(@Param("employeeID") long employeeID);


    /**
     * 分页查询员工列表
     * @param queryEmpListParam
     * @return
     * @throws Exception
     */
    List<EmployeeInformation> queryEmpList(QueryEmpListParam queryEmpListParam) throws Exception;


    /** 查询员工风险列表
     ** @param employeeID
     * @return
     * @throws Exception
     */
    List<EmployeeRisk> queryRiskList(@Param("employeeID")Integer employeeID) throws Exception;


    /**
     * 增加员工风险
     * @param EmployeeRisk
     * @throws Exception
     */
    void addRisk(EmployeeRisk EmployeeRisk) throws Exception;



    /**
     * 删除员工风险
     * @param ID
     * @return
     * @throws Exception
     */
   void deleteRisk(@Param("ID")Integer ID)throws  Exception;



    /**
     * 修改员工风险
     * @param employeeRisk
     * @return
     * @throws Exception
     */
    void updateRisk(EmployeeRisk employeeRisk) throws Exception;


    /**
     * 查询员工评价列表
     * @param employeeID
     * @return
     * @throws Exception
     */
    List<EmployeeEvaluation> queryEvaluationList(@Param("employeeID")Integer employeeID) throws Exception;

    /**
     * 删除员工评价
     * @param ID
     * @return
     * @throws Exception
     */
    void deleteEvaluation(@Param("ID")Integer ID)throws  Exception;


    /**
     * 新增员工评价
     * @param employeeEvaluation
     * @throws Exception
     */
    void addEvaluation(EmployeeEvaluation employeeEvaluation) throws Exception;


    /**
     * 更新员工评价
     * @param employeeEvaluation
     * @throws Exception
     */
    void updateEvaluation(EmployeeEvaluation employeeEvaluation) throws Exception;





    /**
     * 新增项目经历
     * @param employeeProjectInformation
     * @throws Exception
     */
    void addProject(EmployeeProjectInformation employeeProjectInformation) throws Exception;



    /**
     * 修改项目经历
     * @param employeeProjectInformation
     * @throws Exception
     */
    void updateProject(EmployeeProjectInformation employeeProjectInformation) throws Exception;


    /**
     * 员工离职信息导入
     * @param listOrg
     * @return
     */
    int leaveEmployee(@Param("listOrg") List<EmployeeLossInformation> listOrg);
    
    /**
     * 修改用户状态
     * @param userList
     * @return
     */
    int updateUserStatus(@Param("userList") List<User> userList);
    
    int updateEmployeeInfo(@Param("listOrg") List<EmployeeInformation> listOrg);



    /**
     * 更改员工图片的url
     * @param employeeInformation
     * @throws Exception
     */
    void updateEmpImg(EmployeeInformation employeeInformation) throws Exception;

    
    /**
     * 查询用户全量id
     * @return
     */
    List<Integer> queryListUserId();

    /**
     * 条件分页查询员工绩效
     * @param queryEmpPerformaceParam
     * @return
     * @throws Exception
     */
    List<EmployeePerfomanceVo> queryEmpPer(QueryEmpPerformaceParam queryEmpPerformaceParam)throws Exception;


    /**
     * 条件分页查询员工考勤
     * @param queryEmpWorkTimeMonthParam
     * @return
     * @throws Exception
     */
    List<EmployeeWorkTimeMonthVo> queryEmpWorkTimeMonth(QueryEmpWorkTimeMonthParam queryEmpWorkTimeMonthParam) throws Exception;


    /**
     * 查询月份下拉框
     * @return
     * @throws Exception
     */
    List<String> queryMonth() throws Exception;


    /**
     * 查询操作日志
     * @return
     * @throws Exception
     */
    Integer queryLog(Map<String,Object> map)throws Exception;

    /**
     * 模糊查询员工信息
     * @param queryID
     * @return
     */
    EmployeeInformation getEmployeeLikeInfo(@Param("queryID") String queryID);


    /**
     * 查询员工证书
     * @return
     * @throws Exception
     */
    List<EmployeeCertificate> queryEmpCertificateList(Map<String,Object> map) throws Exception;


    /**
     * 查询证书类型下拉框
     * @return
     * @throws Exception
     */
    List<SysConfigResponse> queryCertificateType() throws Exception;


    /**
     * 新增员工证书
     * @param certificate
     * @return
     * @throws Exception
     */
    void addEmpCertificate(EmployeeCertificate certificate) throws Exception;


    /**
     * 更新员工证书
     * @param certificate
     * @return
     * @throws Exception
     */
    void updateCertificate(EmployeeCertificate certificate) throws Exception;

}
