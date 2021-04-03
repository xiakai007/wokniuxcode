package com.isoftstone.humanresources.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isoftstone.humanresources.domain.*;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.screen.EmployeePerformanceEntity;
import com.isoftstone.humanresources.domain.useremployee.SkillInVO;
import com.isoftstone.humanresources.domain.useremployee.UserEmployeeVO;
import com.isoftstone.humanresources.util.MyException;

public interface EmployeeService {
    List<EmployeeInformation> queryByOrganizationID(String organizationID,String organizationType);

    List<EmployeePerformanceEntity> getPerformanceDistribution(List<OrganizationInformation> list);
    
    /**
     * 员工录入模板下载
     * @param response
     * @param request
     * @throws IOException
     */
    void loadExclEmployee(HttpServletResponse response,HttpServletRequest request) throws IOException;
    
    /**
     * 批量导入员工信息接口
     * @param file
     * @return
     */
    Map<String, List<Object>> importExclEmployee(MultipartFile file) throws IOException;
    
    UserEmployeeVO getEmployeeInformation(long employeeID) throws MyException;

    EmployeeInformation getSimpleEmployeeInformation(long employeeID) throws MyException;
    
    void loadPicture(String pictureURL,String emplOrOrg,HttpServletResponse response) throws Exception;


    /**
     * 分页查询员工列表
     * @param queryUserParam
     * @return
     * @throws Exception
     */
    PageInfo<EmployeeInformation> queryEmpList(QueryEmpListParam queryUserParam) throws Exception;


    /**
     * 查询员工风险列表
     * @param employeeID
     * @return
     * @throws Exception
     */
    List<EmployeeRisk> queryRiskList(Integer employeeID) throws Exception;

    /**
     * 增加员工风险
     * @param employeeRisk
     * @return
     * @throws Exception
     */
    Result addRisk(EmployeeRisk employeeRisk) throws Exception;

    /**
     * 删除员工风险
     * @param ID
     * @return
     * @throws Exception
     */
    Result deleteRisk(Integer ID)throws  Exception;



    /**
     * 修改员工风险
     * @param employeeRisk
     * @return
     * @throws Exception
     */
    Result updateRisk(EmployeeRisk employeeRisk) throws Exception;




    /**
     * 查询员工评价列表
     * @param employeeID
     * @return
     * @throws Exception
     */
    List<EmployeeEvaluation> queryEvaluationList(Integer employeeID) throws Exception;


    /**
     * 删除员工评价
     * @param ID
     * @return
     * @throws Exception
     */
    Result deleteEvaluation(Integer ID)throws  Exception;


    /**
     * 增加或修改员工评价
     * @param employeeEvaluation
     * @return
     * @throws Exception
     */
    Result changeEvaluation(EmployeeEvaluation employeeEvaluation)throws Exception;


    /**
     * 查询员工评价列表
     * @param employeeID
     * @return
     * @throws Exception
     */
    List<EmployeeProjectInformation> queryProjectList(Long employeeID) throws Exception;


    /**
     * 新增项目经历
     * @param employeeProjectInformation
     * @throws Exception
     */
    Result addProject(EmployeeProjectInformation employeeProjectInformation) throws Exception;



    /**
     * 修改项目经历
     * @param employeeProjectInformation
     * @throws Exception
     */
    Result updateProject(EmployeeProjectInformation employeeProjectInformation) throws Exception;

    /**
     * 查询员工技能列表
     * @param EmployeeID
     * @return
     * @throws Exception
     */
    List<SkillInVO> querySkillList(Long EmployeeID) throws Exception;

    /**
     * 添加员工技能
     * @param skillInVOList
     * @throws Exception
     */
    Result addEmployeeSkill(List<SkillInVO> skillInVOList) ;

    /**
     * 修改员工技能
     * @param skillInVO
     * @throws Exception
     */
    Result updateEmployeeSkill(SkillInVO skillInVO) ;


    /**
     * 批量导入员工离职信息接口
     * @param file
     * @return
     */
    Map<String, List<Object>> leaveImportEmployee(MultipartFile file) throws IOException;



    /**
     * 更新员工图片信息
     * @param employeeInformation
     * @return
     * @throws Exception
     */
    Result updateEmpImg(EmployeeInformation employeeInformation) throws Exception;

    /**
     * 条件分页查询员工绩效
     * @param queryEmpPerformaceParam
     * @return
     * @throws Exception
     */
    PageInfo<EmployeePerfomanceVo> queryEmpPerList(QueryEmpPerformaceParam queryEmpPerformaceParam) throws Exception;

    /**
     * 条件分页查询员工月度考勤
     * @param queryEmpWorkTimeMonthParam
     * @return
     * @throws Exception
     */
    PageInfo<EmployeeWorkTimeMonthVo> queryEmpWorkTimeMonth(QueryEmpWorkTimeMonthParam queryEmpWorkTimeMonthParam) throws Exception;

    /**
     * 查询月份下拉框列表
     * @return
     * @throws Exception
     */
    List<String> queryMonthList() throws Exception;

    /**
     * 查询操作日志
     * @param employeeID
     * @return
     * @throws Exception
     */
    Result queryLog(Integer employeeID) throws Exception;

    /**
     * 查询证书列表
     * @return
     * @throws Exception
     */
    List<EmployeeCertificate> queryEmpCertificateList(Integer employeeID) throws Exception;

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
    Result addEmpCertificate(EmployeeCertificate certificate) throws Exception;


    /**
     * 更新员工证书
     * @param certificate
     * @return
     * @throws Exception
     */
    Result updateCertificate(EmployeeCertificate certificate) throws Exception;

}
