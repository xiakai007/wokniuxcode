package com.isoftstone.humanresources.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.domain.useremployee.SkillInVO;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.isoftstone.humanresources.domain.useremployee.UserEmployeeVO;
import com.isoftstone.humanresources.service.EmployeeService;
import com.isoftstone.humanresources.util.MyException;

@Controller
@RequestMapping(value = "/hr_manager/employee")
@Api(value = "员工管理API")
public class EmployeeController {
	
	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	/**
     * 下载excl文件
     * @return
     */
    @GetMapping(path = "/loadExclEmployee")
    public ResponseEntity<String> loadExclEmployee(HttpServletResponse response,HttpServletRequest request){
        String returnStr = null;
        try {
        	employeeService.loadExclEmployee(response, request);
        } catch (IOException e) {
            returnStr = e.toString();
            logger.error(e.toString());
        }
        return new ResponseEntity<>(returnStr, HttpStatus.OK);
    }
    
    /**
     * 员工信息批量导入
     * @param file
     * @param request
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/importExclEmployee")
    public ResponseEntity<Map<String, List<Object>>> importExclEmployee(@RequestParam("file") MultipartFile file,HttpServletRequest request){
    	String returnStr;
    	Map<String, List<Object>> map = new HashMap<>();
        List<Object> listReturn = new ArrayList<>();
		 try
	        {
	            if(file.isEmpty()){
	            	returnStr = "文件不存在！";
	            	listReturn.add(returnStr);
	            	map.put("error", listReturn);
	            	return new ResponseEntity<>(map, HttpStatus.OK);
	            }
            map = employeeService.importExclEmployee(file);
        }catch (Exception e){
            returnStr = e.toString();
            listReturn.add(returnStr);
        	map.put("error", listReturn);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
    /**
     * 查询员工信息
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/getEmployeeInformation")
    public ResponseEntity<UserEmployeeVO> getEmployeeInformation(@RequestParam(name = "employeeID") long employeeID){
    	UserEmployeeVO userEmployeeVO = null;
		try {
			userEmployeeVO = employeeService.getEmployeeInformation(employeeID);
		} catch (MyException e) {
			logger.error(e.toString());
		}
    	return new ResponseEntity<>(userEmployeeVO, HttpStatus.OK);
    }

    /**
     * 查询简单的员工信息
     * @return
     */
    @CrossOrigin
    @GetMapping(path = "/get_simple_employee_information")
    public ResponseEntity<EmployeeInformation> getSimpleInformation(@RequestParam(name = "employeeID") long employeeID){
        EmployeeInformation userEmployeeVO = null;
        try {
            userEmployeeVO = employeeService.getSimpleEmployeeInformation(employeeID);
        } catch (MyException e) {
            logger.error(e.toString());
        }
        return new ResponseEntity<>(userEmployeeVO, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping(path = "/loadPicture")
    public ResponseEntity<String> loadPicture(@RequestParam(name = "pictureURL") String pictureURL,@RequestParam(name = "emplOrOrg") String emplOrOrg,HttpServletResponse response) throws Exception{
    	String loadqw = null;
			employeeService.loadPicture(pictureURL,emplOrOrg, response);
    	return new ResponseEntity<>(loadqw, HttpStatus.OK);
    }

    /**
     * 条件分页查询员工列表
     * @param queryEmpListParam
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryEmpList", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<EmployeeInformation>> queryEmpList(@RequestBody QueryEmpListParam queryEmpListParam) {
        logger.info("- - -查询员工列表的请求参数- - -{}", queryEmpListParam);
        PageInfo<EmployeeInformation>  empPageInfo= null;
        try {
            if (null == queryEmpListParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询员工列表接口查询用户列表
            empPageInfo = employeeService.queryEmpList(queryEmpListParam);
            if (null == empPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询员工列表异常", e);
        }
        logger.info("- - -查询员工列表的结果- - -{}", empPageInfo);
        return new ResponseEntity<>(empPageInfo, HttpStatus.OK);
    }

    /**
     * 查询员工风险列表
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryRiskList", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeRisk>> queryRiskList(@RequestParam("employeeID") Integer employeeID) {
        logger.info("- - -查询员工风险列表的请求参数- - -{}", employeeID);
        List<EmployeeRisk> riskList= null;
        try {
            if (null == employeeID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询员工风险接口查询用户列表
            riskList = employeeService.queryRiskList(employeeID);
            if (CollectionUtils.isEmpty(riskList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询员工风险列表异常", e);
        }
        logger.info("- - -查询员工风险列表的结果- - -{}", riskList);
        return new ResponseEntity<>(riskList, HttpStatus.OK);
    }

    /**
     * 新增员工风险
     * @param employeeRisk
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/addRisk", method = RequestMethod.POST)
    public ResponseEntity<Result> addRisk(@RequestBody EmployeeRisk employeeRisk) {
        logger.info("- - -新增员工风险的请求参数- - -{}", employeeRisk);
        Result result= null;
        try {
            if (null == employeeRisk) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用新增员工风险接口查询用户列表
           result = employeeService.addRisk(employeeRisk);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增员工风险异常", e);
        }
        logger.info("- - -新增员工风险的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 删除员工风险
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteRisk", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteRisk(@RequestParam("ID") Integer ID) {
        logger.info("- - -删除员工风险的请求参数- - -{}", ID);
        Result result= null;
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工风险接口查询用户列表
            result = employeeService.deleteRisk(ID);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除员工风险异常", e);
        }
        logger.info("- - -删除员工风险的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 修改员工风险
     * @param employeeRisk
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/updateRisk", method = RequestMethod.POST)
    public ResponseEntity<Result> updateRisk(@RequestBody EmployeeRisk employeeRisk) {
        logger.info("- - -修改员工风险的请求参数- - -{}", employeeRisk);
        Result result= null;
        try {
            if (null == employeeRisk) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用修改员工风险接口查询用户列表
            result = employeeService.updateRisk(employeeRisk);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("修改员工风险异常", e);
        }
        logger.info("- - -修改员工风险的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 查询员工评价列表
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryEvaluationList", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeEvaluation>> queryEvaluationList(@RequestParam("employeeID") Integer employeeID) {
        logger.info("- - -查询员工评价列表的请求参数- - -{}", employeeID);
        List<EmployeeEvaluation> evaluationList= null;
        try {
            if (null == employeeID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询员工风险接口查询用户列表
           evaluationList = employeeService.queryEvaluationList(employeeID);
            if (CollectionUtils.isEmpty(evaluationList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询员工评价列表异常", e);
        }
        logger.info("- - -查询员工评价列表的结果- - -{}", evaluationList);
        return new ResponseEntity<>(evaluationList, HttpStatus.OK);
    }

    /**
     * 删除员工评价信息
     * @param ID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteEvaluation", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteEvaluation(@RequestParam("ID") Integer ID) {
        logger.info("- - -删除员工评价信息的请求参数- - -{}", ID);
        Result result= null;
        try {
            if (null == ID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工评价信息接口查询用户列表
            result = employeeService.deleteEvaluation(ID);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除员工评价信息异常", e);
        }
        logger.info("- - -删除员工评价信息的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 新增或修改员工评价信息
     * @param employeeEvaluation
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/changeEvaluation", method = RequestMethod.POST)
    public ResponseEntity<Result> changeEvaluation(@RequestBody EmployeeEvaluation employeeEvaluation) {
        logger.info("- - -新增或修改员工评价信息的请求参数- - -{}", employeeEvaluation);
        Result result= null;
        try {
            if (null == employeeEvaluation) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工评价信息接口查询用户列表
            result = employeeService.changeEvaluation(employeeEvaluation);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增或修改员工评价信息异常", e);
        }
        logger.info("- - -新增或修改员工评价信息的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 查询员工项目经历列表
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryProjectList", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeProjectInformation>> queryProjectList(@RequestParam("employeeID") Long employeeID) {
        logger.info("- - -查询员工项目经历列表的请求参数- - -{}", employeeID);
        List<EmployeeProjectInformation> projectList= null;
        try {
            if (null == employeeID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询员工风险接口查询用户列表
          projectList = employeeService.queryProjectList(employeeID);
            if (CollectionUtils.isEmpty(projectList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询员工项目经历异常", e);
        }
        logger.info("- - -查询员工项目经历的结果- - -{}", projectList);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    /**
     * 新增员工项目经历
     * @param employeeProjectInformation
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ResponseEntity<Result> addProject(@RequestBody EmployeeProjectInformation employeeProjectInformation) {
        logger.info("- - -新增员工项目经历信息的请求参数- - -{}", employeeProjectInformation);
        Result result= null;
        try {
            if (null == employeeProjectInformation) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工评价信息接口查询用户列表
            result = employeeService.addProject(employeeProjectInformation);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增员工项目经历的信息异常", e);
        }
        logger.info("- - -新增员工项目经历的信息的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新项目经历信息
     * @param employeeProjectInformation
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/updateProject", method = RequestMethod.POST)
    public ResponseEntity<Result> updateProject(@RequestBody EmployeeProjectInformation employeeProjectInformation) {
        logger.info("- - -更新员工项目经历信息的请求参数- - -{}", employeeProjectInformation);
        Result result= null;
        try {
            if (null == employeeProjectInformation) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工评价信息接口查询用户列表
            result = employeeService.updateProject(employeeProjectInformation);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("更新员工项目经历的信息异常", e);
        }
        logger.info("- - -更新员工项目经历的信息的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 查询员工技能列表
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/employee_skill", method = RequestMethod.GET)
    public ResponseEntity<List<SkillInVO>> querySkillList(@RequestParam("employeeID") Long employeeID) {
        logger.info("- - -查询员工技能列表的请求参数- - -{}", employeeID);
        List<SkillInVO> skillList=null;
        try {
            if (null == employeeID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询员工技能列表接口查询技能列表
            skillList = employeeService.querySkillList(employeeID);
            if (CollectionUtils.isEmpty(skillList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询员工技能信息异常", e);
        }
        logger.info("- - -查询员工技能信息的结果- - -{}", skillList);
        return new ResponseEntity<>(skillList, HttpStatus.OK);
    }

    /**
     * 添加员工技能信息
     * @param skillInVOList
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/employee_skill", method = RequestMethod.POST)
    public ResponseEntity<Result> addEmployeeSkill(@RequestBody List<SkillInVO> skillInVOList) {
        logger.info("- - -新增员工技能信息的请求参数- - -{}", skillInVOList);
        Result result= null;
        try {
            if (null == skillInVOList) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工评价信息接口查询用户列表
            result = employeeService.addEmployeeSkill(skillInVOList);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增员工技能的信息异常", e);
        }
        logger.info("- - -新增员工技能的信息的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新员工技能信息
     * @param skillInVO
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/employee_skill", method = RequestMethod.PUT)
    public ResponseEntity<Result> updateEmployeeSkill(@RequestBody SkillInVO skillInVO) {
        logger.info("- - -更新员工技能信息的请求参数- - -{}", skillInVO);
        Result result= null;
        try {
            if (null == skillInVO) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工评价信息接口查询用户列表
            result = employeeService.updateEmployeeSkill(skillInVO);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("更新员工技能的信息异常", e);
        }
        logger.info("- - -更新员工技能的信息的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 员工信息批量导入
     * @param file
     * @param request
     * @return
     */
    @CrossOrigin
    @PostMapping(path = "/leave_import_employee")
    public ResponseEntity<Map<String, List<Object>>> leaveImportEmployee(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        String returnStr;
        Map<String, List<Object>> map = new HashMap<>();
        List<Object> listReturn = new ArrayList<>();
        try
        {
            if(file.isEmpty()){
            	returnStr = "文件不存在！";
            	listReturn.add(returnStr);
            	map.put("error", listReturn);
            	return new ResponseEntity<>(map, HttpStatus.OK);
            }
            map = employeeService.leaveImportEmployee(file);
        }catch (Exception e){
            returnStr = e.toString();
            listReturn.add(returnStr);
        	map.put("error", listReturn);
            logger.error(e.toString());
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }




    @CrossOrigin
    @RequestMapping(value = "/update_employee_img", method = RequestMethod.POST)
    public ResponseEntity<Result> updateEmployeeImg(@RequestBody EmployeeInformation employeeInformation) {
        logger.info("- - -更新员工图片信息的请求参数- - -{}", employeeInformation);
        Result result= null;
        try {
            if (null == employeeInformation ||(null == employeeInformation.getImgURL()&& null == employeeInformation.getCoverImg())) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用删除员工评价信息接口查询用户列表
            result = employeeService.updateEmpImg(employeeInformation);
            if (null==result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("更新员工图片信息异常", e);
        }
        logger.info("- - -更新员工图片信息的结果- - -{}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 条件分页查询员工绩效列表
     * @param queryEmpPerformaceParam
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_emp_per_list", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<EmployeePerfomanceVo>> queryEmpPerList(@RequestBody QueryEmpPerformaceParam queryEmpPerformaceParam) {
        logger.info("- - -查询员工绩效列表的请求参数- - -{}", queryEmpPerformaceParam);
        PageInfo<EmployeePerfomanceVo>  empPageInfo= null;
        try {
            if (null == queryEmpPerformaceParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询员工列表接口查询用户列表
            empPageInfo = employeeService.queryEmpPerList(queryEmpPerformaceParam);
            if (null == empPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询员工绩效列表异常", e);
        }
        logger.info("- - -查询员工绩效列表的结果- - -{}", empPageInfo);
        return new ResponseEntity<>(empPageInfo, HttpStatus.OK);
    }

    /**
     * 条件分页查询考勤列表
     * @param queryEmpWorkTimeMonthParam
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_emp_work_time", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<EmployeeWorkTimeMonthVo>> queryEmpWorkTime(@RequestBody QueryEmpWorkTimeMonthParam queryEmpWorkTimeMonthParam  ) {
        logger.info("- - -查询员工考勤列表的请求参数- - -{}",queryEmpWorkTimeMonthParam);
        PageInfo<EmployeeWorkTimeMonthVo> employeeWorkTimeMonthVoPageInfo=null;
        try {
            if (null == queryEmpWorkTimeMonthParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
             employeeWorkTimeMonthVoPageInfo= employeeService.queryEmpWorkTimeMonth(queryEmpWorkTimeMonthParam);
            if (null == employeeWorkTimeMonthVoPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
           logger.info("- - - 查询员工的考勤列表异常- - - ",e);
        }
        logger.info("- - -查询员工考勤列表的结果- - -{}", employeeWorkTimeMonthVoPageInfo);
        return new ResponseEntity<>(employeeWorkTimeMonthVoPageInfo,HttpStatus.OK);
    }

    /**
     * 查询月份列表
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_month", method = RequestMethod.GET)
    public ResponseEntity<List<String>> queryMonth(){
        List<String> monthList=null;
        try {
          monthList = employeeService.queryMonthList();
          if (CollectionUtils.isEmpty(monthList)){
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
        } catch (Exception e) {
            logger.info("- - -查询月份列表异常- - -",e);
        }
        return new ResponseEntity<>(monthList,HttpStatus.OK);
    }

    /**
     * 查询日志
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_log", method = RequestMethod.GET)
    public ResponseEntity<Result> queryLog(Integer employeeID){
        logger.info("- - -查询日志的请求参数- - -{}",employeeID);
        Result result=null;
        try {
            if (null == employeeID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = employeeService.queryLog(employeeID);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - -查询日志异常-  - -",e);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    /**
     * 查询证书信息
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_emp_certificate", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeCertificate>> queryEmpCertificate(Integer employeeID){
        logger.info("- - -查询员工证书信息controller - - -");
        List<EmployeeCertificate> employeeCertificates=null;
        try {
             employeeCertificates = employeeService.queryEmpCertificateList(employeeID);
             if (CollectionUtils.isEmpty(employeeCertificates)){
                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
        } catch (Exception e) {
            logger.error("- - - 查询员工证书信息异常- - -",e);
        }
        return new ResponseEntity<>(employeeCertificates,HttpStatus.OK);
    }


    /**
     * 查询证书类型下拉框
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_certificate_type", method = RequestMethod.GET)
    public ResponseEntity<List<SysConfigResponse>> queryCertificateType(){
        logger.info("- - -查询员工证书类型下拉框信息controller - - -");
        List<SysConfigResponse> sysConfigResponses=null;
        try {
            sysConfigResponses = employeeService.queryCertificateType();
            if (CollectionUtils.isEmpty(sysConfigResponses)){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("- - - 查询员工证书类型下拉框异常- - -",e);
        }
        return new ResponseEntity<>(sysConfigResponses,HttpStatus.OK);

    }

    /**
     * 新增员工的证书信息
     * @param certificate
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_emp_certificate", method = RequestMethod.POST)
    public ResponseEntity<Result> addEmpCertificate(@RequestBody EmployeeCertificate certificate){
        logger.info("- - -新增员工证书信息的请求参数 - - -{}",certificate);
        Result result=null;
        try {
             result = employeeService.addEmpCertificate(certificate);
             if (null==result){
                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
        } catch (Exception e) {
            logger.info("- - -新增员工证书信息异常 - - -",e);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    /**
     * 新增员工的证书信息
     * @param certificate
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_emp_certificate", method = RequestMethod.POST)
    public ResponseEntity<Result> updateEmpCertificate(@RequestBody EmployeeCertificate certificate){
        logger.info("- - -更新员工证书信息的请求参数 - - -{}",certificate);
        Result result=null;
        try {
            result = employeeService.updateCertificate(certificate);
            if(null==result){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.info("- - -更新员工证书信息异常 - - -",e);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
