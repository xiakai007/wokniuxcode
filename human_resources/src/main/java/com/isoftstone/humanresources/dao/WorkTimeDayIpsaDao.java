package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.Page;
import com.isoftstone.humanresources.domain.workTime.WorkTimeDayIpsaModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [员工IPSA日考勤记录dao]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface WorkTimeDayIpsaDao{
	
	/**
	* 分页查询固定参数
	*/
	List<WorkTimeDayIpsaModel> queryPageWorkTimeDayIpsa(@Param("page") Page page, @Param("entity") WorkTimeDayIpsaModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<WorkTimeDayIpsaModel> queryListWorkTimeDayIpsa(@Param("entity") WorkTimeDayIpsaModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountWorkTimeDayIpsa(@Param("entity") WorkTimeDayIpsaModel entity);
	
	/**
	* 查询单个实体
	*/
	WorkTimeDayIpsaModel queryWorkTimeDayIpsaById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addWorkTimeDayIpsa(WorkTimeDayIpsaModel entity);

	int importWorkTimeDay(@Param("dayTimeList") List<WorkTimeDayIpsaModel> dayTimeList);
	
	/**
	* 修改
	*/
	int updateWorkTimeDayIpsa(WorkTimeDayIpsaModel entity);
	
	/**
	* 批量删除
	*/
	int removeWorkTimeDayIpsaByIds(List code);
	
	/**
	* 删除
	*/
	int removeWorkTimeDayIpsaById(@Param("id") Long id);

}
