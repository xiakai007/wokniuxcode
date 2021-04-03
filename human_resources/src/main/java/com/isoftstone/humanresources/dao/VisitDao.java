package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.VisitModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [拜访记录表dao]</p>
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface VisitDao{
	
	/**
	* 分页查询固定参数
	*/
	List<VisitModel> queryPageVisit(@Param("page") Page page, @Param("entity") VisitModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<VisitModel> queryListVisit(@Param("entity") VisitModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountVisit(@Param("entity") VisitModel entity);
	
	/**
	* 查询单个实体
	*/
	VisitModel queryVisitById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addVisit(VisitModel entity);
	
	/**
	* 修改
	*/
	int updateVisit(VisitModel entity);
	
	/**
	* 批量删除
	*/
	int removeVisitByIds(List code);
	
	/**
	* 删除
	*/
	int removeVisitById(@Param("id") Long id);

}
