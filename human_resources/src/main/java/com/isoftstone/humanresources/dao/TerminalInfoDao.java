package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.workTime.TerminalInfoModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [考勤机配置表dao]</p>
 * Created on 2020年10月28日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface TerminalInfoDao{
	
	/**
	* 分页查询固定参数
	*/
	List<TerminalInfoModel> queryPageTerminalInfo(@Param("page") Page page, @Param("entity") TerminalInfoModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<TerminalInfoModel> queryListTerminalInfo(@Param("entity") TerminalInfoModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountTerminalInfo(@Param("entity") TerminalInfoModel entity);
	
	/**
	* 查询单个实体
	*/
	TerminalInfoModel queryTerminalInfoById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addTerminalInfo(TerminalInfoModel entity);
	
	/**
	* 修改
	*/
	int updateTerminalInfo(TerminalInfoModel entity);
	
	/**
	* 批量删除
	*/
	int removeTerminalInfoByIds(List code);
	
	/**
	* 删除
	*/
	int removeTerminalInfoById(@Param("id") Long id);

}
