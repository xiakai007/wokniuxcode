package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.LuckDrawModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [抽奖信息表dao]</p>
 * Created on 2019年12月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public interface LuckDrawDao{
	
	/**
	* 查询固定参数
	*/
	List<LuckDrawModel> queryListLuckDraw(@Param("entity") LuckDrawModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountLuckDraw(@Param("entity") LuckDrawModel entity);
	
	/**
	* 查询单个实体
	*/
	LuckDrawModel queryLuckDrawById(@Param("id") Integer id, @Param("queryFields") List queryFields);

	int queryLuckDrawByName(@Param("employeeName") String employeeName);
	
	/**
	* 新增
	*/
	int addLuckDraw(LuckDrawModel entity);
	
	/**
	* 修改
	*/
	int updateLuckDraw(LuckDrawModel entity);
	
	/**
	* 批量删除
	*/
	int removeLuckDrawByIds(List code);
	
	/**
	* 删除
	*/
	int removeLuckDrawById(@Param("id") Long id);

}
