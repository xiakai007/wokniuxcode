package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.recruit.PduCostcenterModel;
import com.isoftstone.humanresources.domain.recruit.RequirementModel;
import com.isoftstone.humanresources.domain.recruit.RequirementRequest;
import com.isoftstone.humanresources.domain.recruit.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 
 * <p>Description: [招聘系统记录表dao]</p>
 * Created on 2020年03月09日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface RecruitDao {

	UserModel getUserByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

	List<RequirementModel> queryListRequirements(@Param("entity") RequirementRequest entity, @Param("pageOffset") String pageOffset, @Param("pageSize") String pageSize );

	List<String> queryDistinctParams(@Param("queryParam") String queryParam);

	List<String> queryPduCostcenter(@Param("queryParam") String queryParam ,@Param("entity") PduCostcenterModel model);

	/**
	 * 新增
	 */
	int addRequirements(RequirementModel entity);
}
