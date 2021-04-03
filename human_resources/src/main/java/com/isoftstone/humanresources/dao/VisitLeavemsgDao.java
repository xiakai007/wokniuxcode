package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.VisitLeavemsgModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [遗留问题记录表dao]</p>
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface VisitLeavemsgDao{
	
	/**
	* 分页查询固定参数
	*/
	List<VisitLeavemsgModel> queryPageVisitLeavemsg(@Param("page") Page page, @Param("entity") VisitLeavemsgModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<VisitLeavemsgModel> queryListVisitLeavemsg(@Param("entity") VisitLeavemsgModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountVisitLeavemsg(@Param("entity") VisitLeavemsgModel entity);
	
	/**
	* 查询单个实体
	*/
	VisitLeavemsgModel queryVisitLeavemsgById(@Param("id") Long id, @Param("queryFields") List queryFields);

	/**
	 * 查询根据拜访ID查询所有的遗留问题记录
	 */
	List<VisitLeavemsgModel> queryByVisitId(@Param("visitID") Long id);
	/**
	* 新增
	*/
	int addVisitLeavemsg(VisitLeavemsgModel entity);
	
	/**
	* 修改
	*/
	int updateVisitLeavemsg(VisitLeavemsgModel entity);
	
	/**
	* 批量删除
	*/
	int removeVisitLeavemsgByIds(List code);
	
	/**
	* 删除
	*/
	int removeVisitLeavemsgById(@Param("id") Long id);

}
