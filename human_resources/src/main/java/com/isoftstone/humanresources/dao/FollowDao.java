package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.gather.FollowModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [关注表dao]</p>
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface FollowDao{
	
	/**
	* 分页查询固定参数
	*/
	List<FollowModel> queryPageFollow(@Param("page") Page page, @Param("entity") FollowModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<FollowModel> queryListFollow(@Param("entity") FollowModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountFollow(@Param("entity") FollowModel entity);
	
	/**
	* 查询单个实体
	*/
	FollowModel queryFollowById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addFollow(FollowModel entity);
	
	/**
	* 修改
	*/
	int updateFollow(FollowModel entity);
	
	/**
	* 批量删除
	*/
	int removeFollowByIds(List code);
	
	/**
	* 删除
	*/
	int removeFollowById(@Param("id") Long id);

}
