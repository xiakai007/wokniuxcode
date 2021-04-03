package com.isoftstone.humanresources.service;

import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.recruit.PduCostcenterModel;
import com.isoftstone.humanresources.domain.recruit.RequirementModel;
import com.isoftstone.humanresources.domain.recruit.RequirementRequest;
import com.isoftstone.humanresources.domain.recruit.UserModel;

import java.util.List;

/**
 * Description: [招聘服务]
 * Created on 2020年03月09日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface RecruitService {

	public UserModel getUserByUserNameAndPassword(String username, String password);

	public List<RequirementModel> queryListRequirement(RequirementRequest requirementRequest,String pageOffset ,String pageSize);

	public RequirementRequest queryDistinctParams();

	public List<String> queryPduCostcenter(String queryParam , PduCostcenterModel model);

	/**
	 * <p>Discription:[需求管理表数据新增]</p>
	 * Created on 2020年03月18日
	 * @param requirementsModel 需求管理表数据
	 * @return String 添加成功的id
	 * @author:wangchun
	 */
	public Result save(RequirementModel requirementsModel);

}
