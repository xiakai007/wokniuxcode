package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.gather.DepartmentNewsModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [部门新鲜事dao]</p>
 * Created on 2020年05月29日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface DepartmentNewsDao{
	
	/**
	* 分页查询固定参数
	*/
	List<DepartmentNewsModel> queryPageDepartmentNews(@Param("page") Page page, @Param("entity") DepartmentNewsModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<DepartmentNewsModel> queryListDepartmentNews(@Param("entity") DepartmentNewsModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountDepartmentNews(@Param("entity") DepartmentNewsModel entity);
	
	/**
	* 查询单个实体
	*/
	DepartmentNewsModel queryDepartmentNewsById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addDepartmentNews(DepartmentNewsModel entity);
	
	/**
	* 修改
	*/
	int updateDepartmentNews(DepartmentNewsModel entity);
	
	/**
	* 批量删除
	*/
	int removeDepartmentNewsByIds(List code);
	
	/**
	* 删除
	*/
	int removeDepartmentNewsById(@Param("id") Long id);

}
