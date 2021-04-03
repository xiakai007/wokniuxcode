package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.GroupActivities;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [活动风采表dao]</p>
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface GroupActivitiesDao{
	
	/**
	* 分页查询固定参数
	*/
	List<GroupActivities> queryPageGroupActivities(@Param("page") Page page, @Param("entity") GroupActivities entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<GroupActivities> queryListGroupActivities(@Param("entity") GroupActivities entity, @Param("queryFields") List queryFields);

	GroupActivities querySingleGroupActivities(@Param("id") Integer id);

	/**
	* 查询总数量
	*/
	Long queryCountGroupActivities(@Param("entity") GroupActivities entity);
	
	/**
	* 查询单个实体
	*/
	GroupActivities queryGroupActivitiesById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addGroupActivities(GroupActivities entity);
	
	/**
	* 修改
	*/
	int updateGroupActivities(GroupActivities entity);
	
	/**
	* 批量删除
	*/
	int removeGroupActivitiesByIds(List code);
	
	/**
	* 删除
	*/
	int removeGroupActivitiesById(@Param("id") int id);

}
