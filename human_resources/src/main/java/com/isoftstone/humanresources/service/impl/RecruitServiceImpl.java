package com.isoftstone.humanresources.service.impl;

import com.isoftstone.humanresources.dao.RecruitDao;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.VisitModel;
import com.isoftstone.humanresources.domain.recruit.PduCostcenterModel;
import com.isoftstone.humanresources.domain.recruit.RequirementModel;
import com.isoftstone.humanresources.domain.recruit.RequirementRequest;
import com.isoftstone.humanresources.domain.recruit.UserModel;
import com.isoftstone.humanresources.service.RecruitService;
import com.isoftstone.humanresources.util.DateUtil;
import com.isoftstone.humanresources.util.MD5;
import com.isoftstone.humanresources.util.StringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** 
 * Description: [招聘服务实现]
 * Created on 2020年03月09日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {
	
	@Resource
	private RecruitDao recruitDao;
	/**
	 * <p>Discription:[根据id查询拜访记录表数据]</p>
	 * Created on 2020年03月09日
	 * @return VisitModel 单条数据
	 * @author:wangchun
	 */
	public UserModel getUserByUserNameAndPassword(String username, String password){
		UserModel model = null;
		try{
			String tmp = MD5.getMD5Code(username + ":" + password);
			model = this.recruitDao.getUserByUserNameAndPassword(username,tmp);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return model;
	}

	public List<RequirementModel> queryListRequirement(RequirementRequest requirementRequest,String pageOffset ,String pageSize){
		List<RequirementModel>  retList = null;
		List<RequirementModel>  requirementModelList = recruitDao.queryListRequirements(requirementRequest,pageOffset,pageSize) ;
		if(!CollectionUtils.isEmpty(requirementModelList)){
			retList = new ArrayList<RequirementModel>();
			for(RequirementModel model: requirementModelList){
				model.setShowDetail(model.getSkill() + "	"+ model.getStarttimestr() +"~" + model.getEndtimestr());
				retList.add(model);
			}
		}
		return retList;
	}

	/**
	 * 查询筛选信息列表
	 * @return
	 */
	public RequirementRequest queryDistinctParams(){
		RequirementRequest requirementRequest = new  RequirementRequest();
		List<String>  areaList = recruitDao.queryDistinctParams("area");
		List<String>  pduList = recruitDao.queryDistinctParams("pdu");
		List<String>  pmList = recruitDao.queryDistinctParams("project_manager");
		List<String>  skillList = recruitDao.queryDistinctParams("skill");
		requirementRequest.setArea(areaList);
		requirementRequest.setPdu(pduList);
		requirementRequest.setProjectManager(pmList);
		requirementRequest.setSkill(skillList);
		return requirementRequest;
	}

	public List<String> queryPduCostcenter(String queryParam , PduCostcenterModel model){
//		List<PduCostcenterModel> retList = new ArrayList<PduCostcenterModel>();
		List<String> retList = new ArrayList<String>();
		List<String> tmpList =  recruitDao.queryPduCostcenter(queryParam,model);
		for(String str:tmpList){
			if(!StringUtil.isEmpty(str)){
				retList.add(str);
			}
		}
		return  retList;
	}

	/**
	 * <p>Discription:[需求管理表数据新增]</p>
	 * Created on 2020年03月18日
	 * @param requirementsModel 需求管理表数据
	 * @return String 添加成功的id

	 * @author:wangchun
	 */
	public Result save(RequirementModel requirementsModel){
		Result result = new Result();
		int count = 0;
		try{
			if(!StringUtil.isEmpty(requirementsModel.getStarttimestr())) {
				requirementsModel.setStarttime(DateUtil.getTimeInMillis(DateUtil.stringToDate(requirementsModel.getStarttimestr(), "yyyy-MM-dd")));
			}
			if(!StringUtil.isEmpty(requirementsModel.getEndtimestr())){
				requirementsModel.setEndtime(DateUtil.getTimeInMillis(DateUtil.stringToDate(requirementsModel.getEndtimestr(), "yyyy-MM-dd")));
			}
			count = this.recruitDao.addRequirements(requirementsModel);
			if (0 == count) {
				result.setSuccess(false);
				result.setMessage("编辑失败！");
				return result;
			}
			result.setSuccess(true);
			result.setMessage("编辑成功！");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return result;
	}
}
