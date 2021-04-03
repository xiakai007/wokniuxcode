package com.isoftstone.humanresources.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftstone.humanresources.dao.EmployeeDao;
import com.isoftstone.humanresources.dao.GradingRulesDao;
import com.isoftstone.humanresources.domain.EmployeeInformation;
import com.isoftstone.humanresources.domain.GradingRulesInformation;
import com.isoftstone.humanresources.domain.portraitprojectmanager.GradingRulesVO;
import com.isoftstone.humanresources.service.GradingRulesService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.StringUtil;

/**
 * 打分规则
 * @author bwning
 *
 */
@Service(value = "GradingRulesService")
public class GradingRulesServiceImpl implements GradingRulesService{
	
	private final Logger logger = LoggerFactory.getLogger(GradingRulesServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private GradingRulesDao gradingRulesDao;
	
	@Override
	public Map<String, Object> addGradingRules(GradingRulesVO gradingRules) {
		boolean flag = false;
        Map<String, Object> map = new HashMap<>();
		try {
			int result = gradingRulesDao.addGradingRules(gradingRules);
			if(result == 0){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "新增失败");
				return map;
			}
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "新增成功");
		} catch (Exception e) {
			logger.error(e.toString());
			flag = false;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, e.toString());
		}
		return map;
	}

	@Override
	public Map<String, Object> updateGradingRules(GradingRulesVO gradingRules) {
		boolean flag = false;
        Map<String, Object> map = new HashMap<>();
		try {
			int result = gradingRulesDao.updateGradingRules(gradingRules);
			if(result == 0){
				map.put(CommonConstant.RETURN_STATUS, flag);
				map.put(CommonConstant.RETURN_MESSAGE, "修改失败");
				return map;
			}
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, "修改成功");
		} catch (Exception e) {
			logger.error(e.toString());
			flag = false;
			map.put(CommonConstant.RETURN_STATUS, flag);
			map.put(CommonConstant.RETURN_MESSAGE, e.toString());
		}
		return map;
	}

	@Override
	public GradingRulesVO queryRuleByOrgId(String bdOrBu,String orgType) {
		GradingRulesVO rules = new GradingRulesVO();
		List<GradingRulesInformation> ruleList = new ArrayList<>();
		if((!orgType.equals("BU"))&&(!orgType.equals("BD"))){
			EmployeeInformation emp = employeeDao.queryEmployeeInfo(Long.parseLong(bdOrBu));
			ruleList = 
					gradingRulesDao.queryRuleInfo(emp.getBU(), "BU");
			if(ruleList.isEmpty()){
				ruleList = 
						gradingRulesDao.queryRuleInfo(emp.getBD(), "BD");
			}
		}else{
			ruleList = 
					gradingRulesDao.queryRuleInfo(bdOrBu, orgType);
		}
		if(!ruleList.isEmpty()){
			if("BD".equals(orgType)){
				rules.setBd(ruleList.get(0).getBD());
				rules.setBdName(ruleList.get(0).getBdName());
			}else{
				rules.setBu(ruleList.get(0).getBU());
				rules.setBuName(ruleList.get(0).getBuName());
			}
			if(!StringUtil.isEmpty(ruleList.get(0).getBak())){
				rules.setBak(ruleList.get(0).getBak());
			}
			if(!StringUtil.isEmpty(ruleList.get(0).getCreateName())){
				rules.setCreateemployeeID(ruleList.get(0).getCreateemployeeID());
				rules.setCreateName(ruleList.get(0).getCreateName());
			}
			if(!StringUtil.isEmpty(ruleList.get(0).getUpdateName())){
				rules.setCreateemployeeID(ruleList.get(0).getUpdateEmployeeID());
				rules.setCreateName(ruleList.get(0).getUpdateName());
			}
			rules.setRuleList(ruleList);
			if(orgType.equals("BU")){
				rules.setParentId(gradingRulesDao.queryParent(bdOrBu));
			}
		}
		return rules;
	}

	@Override
	public Map<String, Object> addRuleCheck(String bdOrBu) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<>();
		int result = gradingRulesDao.queryRuleCount(bdOrBu);
		if(result == 0){
			flag = true;
			map.put(CommonConstant.RETURN_STATUS, flag);
			return map;
		}
		map.put(CommonConstant.RETURN_STATUS, flag);
		map.put(CommonConstant.RETURN_MESSAGE, "该组织下已存在规则,如需制定新的规则，请前往修改");
		return map;
	}
}
