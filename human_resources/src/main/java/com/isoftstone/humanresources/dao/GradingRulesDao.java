package com.isoftstone.humanresources.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.isoftstone.humanresources.domain.GradingRulesInformation;
import com.isoftstone.humanresources.domain.portraitprojectmanager.GradingRulesVO;

public interface GradingRulesDao {

	/**
	 * 新增打分规则
	 * @param gradingRulesInfo
	 * @return
	 */
	int addGradingRules(@Param("gradingRules") GradingRulesVO gradingRules);
	
	/**
	 * 修改打分规则
	 * @param gradingRulesInfo
	 * @return
	 */
	int updateGradingRules(@Param("gradingRules") GradingRulesVO gradingRules);
	
	/**
	 * 新增规则校验
	 * @param bdOrBu
	 * @return
	 */
	int queryRuleCount(@Param("bdOrBu") String bdOrBu);
	
	/**
	 * 查询打分规则详情
	 * @param bdOrBu
	 * @return
	 */
	List<GradingRulesInformation> queryRuleInfo(@Param("bdOrBu") String bdOrBu,@Param("orgType") String orgType);
	
	/**
	 * 查询组织父ID
	 * @param organzationId
	 * @return
	 */
	String queryParent(@Param("organzationId") String organzationId);
}
