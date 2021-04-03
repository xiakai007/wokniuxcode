package com.isoftstone.humanresources.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isoftstone.humanresources.domain.EmployeeTrainProgramInformation;
import com.isoftstone.humanresources.domain.organization.QueryEmpForProjectVO;
import com.isoftstone.humanresources.service.StaffTrainProgrammeService;

import io.swagger.annotations.Api;

@Controller
@RequestMapping(value = "/hr_manager/staff_train_programme")
@Api(value = "员工培训计划API")
public class StaffTrainProgrammeController {

	@Autowired
	private StaffTrainProgrammeService staffTrainProgrammeService;
	
	/**
	 * 培训计划新增接口
	 * @param etpInfo
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/add_train_program")
	public ResponseEntity<Map<String, Object>> addTrainProgram(@RequestBody EmployeeTrainProgramInformation etpInfo){
		Map<String, Object> map = 
				staffTrainProgrammeService.addTrainProgram(etpInfo);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 培训计划修改接口
	 * @param etpInfo
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/update_train_program")
	public ResponseEntity<Map<String, Object>> updateTrainProgram(@RequestBody EmployeeTrainProgramInformation etpInfo){
		Map<String, Object> map = 
				staffTrainProgrammeService.updateTrainProgram(etpInfo);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 查询计划详情
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/query_plan_by_id")
	public ResponseEntity<List<EmployeeTrainProgramInformation>> queryPlanById(@RequestParam(name="id") String id,@RequestParam(name = "projectTeam") String projectTeam){
		List<EmployeeTrainProgramInformation> etpInfoList = 
				staffTrainProgrammeService.queryPlanById(id,projectTeam);
		return new ResponseEntity<>(etpInfoList, HttpStatus.OK);
	}
	
	/**
	 * 查询leader下的员工
	 * @param leader
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/query_Emp_Project")
	public ResponseEntity<List<QueryEmpForProjectVO>> queryEmpProject(@RequestParam(name = "leader") String leader){
		List<QueryEmpForProjectVO> emplyeeList = 
				staffTrainProgrammeService.queryEmpProject(leader);
		return new ResponseEntity<>(emplyeeList, HttpStatus.OK);
	}
}
