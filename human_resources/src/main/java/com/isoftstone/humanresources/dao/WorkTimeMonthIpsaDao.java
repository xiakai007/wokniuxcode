package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.workTime.WorkTimeMonthIpsaModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [员工IPSA月考勤记录dao]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface WorkTimeMonthIpsaDao{
	
	/**
	* 分页查询固定参数
	*/
	List<WorkTimeMonthIpsaModel> queryPageWorkTimeMonthIpsa(@Param("page") Page page, @Param("entity") WorkTimeMonthIpsaModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<WorkTimeMonthIpsaModel> queryListWorkTimeMonthIpsa(@Param("entity") WorkTimeMonthIpsaModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountWorkTimeMonthIpsa(@Param("entity") WorkTimeMonthIpsaModel entity);
	
	/**
	* 查询单个实体
	*/
	WorkTimeMonthIpsaModel queryWorkTimeMonthIpsaById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addWorkTimeMonthIpsa(WorkTimeMonthIpsaModel entity);

	int importWorkTimeMonth(@Param("monthTimeList") List<WorkTimeMonthIpsaModel> monthTimeList);
	
	/**
	* 修改
	*/
	int updateWorkTimeMonthIpsa(WorkTimeMonthIpsaModel entity);
	
	/**
	* 批量删除
	*/
	int removeWorkTimeMonthIpsaByIds(List code);
	
	/**
	* 删除
	*/
	int removeWorkTimeMonthIpsaById(@Param("id") Long id);

}
