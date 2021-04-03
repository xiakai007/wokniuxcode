package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.gather.KmsModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [知识管理表dao]</p>
 * Created on 2020年05月29日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface KmsDao{
	
	/**
	* 分页查询固定参数
	*/
	List<KmsModel> queryPageKms(@Param("page") Page page, @Param("entity") KmsModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<KmsModel> queryListKms(@Param("entity") KmsModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountKms(@Param("entity") KmsModel entity);
	
	/**
	* 查询单个实体
	*/
	KmsModel queryKmsById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addKms(KmsModel entity);
	
	/**
	* 修改
	*/
	int updateKms(KmsModel entity);
	
	/**
	* 批量删除
	*/
	int removeKmsByIds(List code);
	
	/**
	* 删除
	*/
	int removeKmsById(@Param("id") Long id);

}
