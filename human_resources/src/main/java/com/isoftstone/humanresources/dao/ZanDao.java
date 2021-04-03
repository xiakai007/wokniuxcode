package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.gather.ZanModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [点赞表dao]</p>
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface ZanDao{
	
	/**
	* 分页查询固定参数
	*/
	List<ZanModel> queryPageZan(@Param("page") Page page, @Param("entity") ZanModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<ZanModel> queryListZan(@Param("entity") ZanModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountZan(@Param("entity") ZanModel entity);
	
	/**
	* 查询单个实体
	*/
	ZanModel queryZanById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addZan(ZanModel entity);
	
	/**
	* 修改
	*/
	int updateZan(ZanModel entity);
	
	/**
	* 批量删除
	*/
	int removeZanByIds(List code);
	
	/**
	* 删除
	*/
	int removeZanById(@Param("id") Long id);

	List<ZanModel> queryBycomposeID(@Param("zanID") String zanID,@Param("zanType") String zanType);

	int queryBycomposeIDSize(@Param("zanID") String zanID,@Param("zanType") String zanType);
}
