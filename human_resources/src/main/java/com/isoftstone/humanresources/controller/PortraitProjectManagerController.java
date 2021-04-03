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

import com.isoftstone.humanresources.domain.EmployeeBasicRecordInformation;
import com.isoftstone.humanresources.domain.ImpressionRecordInformation;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ImpressionRecordRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.PmScoreRes;
import com.isoftstone.humanresources.domain.portraitprojectmanager.ProjectMangerScoreRes;
import com.isoftstone.humanresources.service.PortraitProjectManagerService;

import io.swagger.annotations.Api;

@Controller
@RequestMapping(value = "/hr_manager/project_manager")
@Api(value = "项目经理打分API")
public class PortraitProjectManagerController {

	@Autowired
	private PortraitProjectManagerService portraitProjectManagerService;
	
	/**
	 * 新增印象接口
	 * @param impressionRecord
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/add_impression_record")
	public ResponseEntity<Map<String, Object>> addImpressionRecord(@RequestBody ImpressionRecordInformation impressionRecord){
		Map<String, Object> map = portraitProjectManagerService.addImpressionRecord(impressionRecord);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	/**
	 * 印象标签查询接口
	 * @param employeeID
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/query_impression")
	public ResponseEntity<List<ImpressionRecordRes>> queryImpression(@RequestParam(name = "employeeID") String employeeID){
		List<ImpressionRecordRes> impressionRecordRes = portraitProjectManagerService.queryImpression(employeeID);
		return new ResponseEntity<>(impressionRecordRes, HttpStatus.OK);
	}
	
	/**
	 * 新增基础加分项
	 * @param employeeBasicRecordInfo
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/add_basic_record")
	public ResponseEntity<Map<String, Object>> addBasicRecord(@RequestBody EmployeeBasicRecordInformation employeeBasicRecordInfo){
		Map<String, Object> map = portraitProjectManagerService.addBasicRecord(employeeBasicRecordInfo);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 基础加分项修改
	 * @param employeeBasicRecordInfo
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/update_basic_record")
	public ResponseEntity<Map<String, Object>> updateBasicRecord(@RequestBody EmployeeBasicRecordInformation employeeBasicRecordInfo){
		Map<String, Object> map = portraitProjectManagerService.updateBasicRecord(employeeBasicRecordInfo);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 查询加分项详情
	 * @param id
	 * @param employeeId
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path="/query_basic_info")
	public ResponseEntity<List<EmployeeBasicRecordInformation>> queryBasicInfo(@RequestParam(name="id") String id,@RequestParam(name="employeeId") String employeeId){
		List<EmployeeBasicRecordInformation> basicInfoList = 
				portraitProjectManagerService.queryBasicById(id, employeeId);
		return new ResponseEntity<>(basicInfoList, HttpStatus.OK);
	}
	
	/**
	 * 项目经理技能展示
	 * @param employeeId
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/query_project_manager_score")
	public ResponseEntity<List<PmScoreRes>> queryProjectManagerScore(@RequestParam(name="employeeId") long employeeId){
		List<PmScoreRes> pm = portraitProjectManagerService.queryProjectManagerScore(employeeId);
		return new ResponseEntity<>(pm, HttpStatus.OK);
	}
	
	/**
	 * 查询打分结果
	 * @param employeeId
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path="/query_prject_manager_score")
	public ResponseEntity<ProjectMangerScoreRes>  queryPrjectManagerScore(@RequestParam(name="employeeId") long employeeId){
		ProjectMangerScoreRes pms = portraitProjectManagerService.queryPrjectManagerScore(employeeId);
		return new ResponseEntity<>(pms, HttpStatus.OK);
	}
}
