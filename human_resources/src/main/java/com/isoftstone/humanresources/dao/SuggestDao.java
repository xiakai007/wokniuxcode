package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.Suggest;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [意见建议表dao]</p>
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface SuggestDao{
	
	/**
	* 分页查询固定参数
	*/
	List<Suggest> queryPageSuggest(@Param("page") Page page, @Param("entity") Suggest entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<Suggest> queryListSuggest(@Param("entity") Suggest entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountSuggest(@Param("entity") Suggest entity);
	
	/**
	* 查询单个实体
	*/
	Suggest querySuggestById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addSuggest(Suggest entity);
	
	/**
	* 修改
	*/
	int updateSuggest(Suggest entity);
	
	/**
	* 批量删除
	*/
	int removeSuggestByIds(List code);
	
	/**
	* 删除
	*/
	int removeSuggestById(@Param("id") Long id);

}
