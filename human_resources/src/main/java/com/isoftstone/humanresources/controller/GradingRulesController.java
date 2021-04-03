package com.isoftstone.humanresources.controller;

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

import com.isoftstone.humanresources.domain.portraitprojectmanager.GradingRulesVO;
import com.isoftstone.humanresources.service.GradingRulesService;

import io.swagger.annotations.Api;

@Controller
@RequestMapping(value = "/hr_manager/grading_rules")
@Api(value = "打分规则API")
public class GradingRulesController {

	@Autowired
	private GradingRulesService gradingRulesService;
	
	/**
	 * 新增比分规则接口
	 * @param gradingRules
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/add_grading_rules")
	public ResponseEntity<Map<String, Object>> addGradingRules(@RequestBody GradingRulesVO gradingRules){
		 Map<String, Object> map = gradingRulesService.addGradingRules(gradingRules);
		   return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 修改比分规则接口
	 * @param gradingRules
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/update_grading_rules")
	public ResponseEntity<Map<String, Object>> updateGradingRules(@RequestBody GradingRulesVO gradingRules){
		 Map<String, Object> map = gradingRulesService.updateGradingRules(gradingRules);
		   return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 新增比分规则校验接口
	 * @param bdOrBu
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/add_rule_check")
	public ResponseEntity<Map<String, Object>> addRuleCheck(@RequestParam(name = "bdOrBu") String bdOrBu){
		Map<String, Object> map = gradingRulesService.addRuleCheck(bdOrBu);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	/**
	 * 查询比分规则详情
	 * @param bdOrBu
	 * @param orgType
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/query_rule_by_orgid")
	public ResponseEntity<GradingRulesVO> queryRuleByOrgId(@RequestParam(name = "bdOrBu") String bdOrBu,@RequestParam(name = "orgType") String orgType){
		GradingRulesVO rules = gradingRulesService.queryRuleByOrgId(bdOrBu, orgType);
		return new ResponseEntity<>(rules, HttpStatus.OK);
	}
}
