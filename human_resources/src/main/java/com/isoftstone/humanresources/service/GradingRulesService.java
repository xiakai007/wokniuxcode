package com.isoftstone.humanresources.service;

import java.util.Map;

import com.isoftstone.humanresources.domain.portraitprojectmanager.GradingRulesVO;

public interface GradingRulesService {

	/**
	 * 新增打分规则service
	 * @param gradingRules
	 * @return
	 */
	public Map<String, Object> addGradingRules(GradingRulesVO gradingRules);
	
	/**
	 * 修改打分规则service
	 * @param gradingRules
	 * @return
	 */
	public Map<String, Object> updateGradingRules(GradingRulesVO gradingRules);
	
	/**
	 * 查询打分规则详情
	 * @param organizationId
	 * @return
	 */
	public GradingRulesVO queryRuleByOrgId(String bdOrBu,String orgType);
	
	/**
	 * 新增规则校验
	 * @param bdOrBu
	 * @return
	 */
	public Map<String, Object> addRuleCheck(String bdOrBu);
}
