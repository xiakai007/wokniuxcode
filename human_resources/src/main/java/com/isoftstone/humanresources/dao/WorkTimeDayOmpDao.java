package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.workTime.WorkTimeDayOmpModel;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [员工OMP日考勤记录dao]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface WorkTimeDayOmpDao{
	
	/**
	* 分页查询固定参数
	*/
	List<WorkTimeDayOmpModel> queryPageWorkTimeDayOmp(@Param("page") Page page, @Param("entity") WorkTimeDayOmpModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<WorkTimeDayOmpModel> queryListWorkTimeDayOmp(@Param("entity") WorkTimeDayOmpModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountWorkTimeDayOmp(@Param("entity") WorkTimeDayOmpModel entity);
	
	/**
	* 查询单个实体
	*/
	WorkTimeDayOmpModel queryWorkTimeDayOmpById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addWorkTimeDayOmp(WorkTimeDayOmpModel entity);

	int importWorkTimeDay(@Param("dayTimeList") List<WorkTimeDayOmpModel> dayTimeList);

	List<WorkTimeDayOmpModel> queryAllWorkTimeDayOmp();

	List<WorkTimeDayOmpModel> queryAllOmpException1();
	List<WorkTimeDayOmpModel> queryAllOmpException2();

	/**
	* 修改
	*/
	int updateWorkTimeDayOmp(WorkTimeDayOmpModel entity);
	
	/**
	* 批量删除
	*/
	int removeWorkTimeDayOmpByIds(List code);
	
	/**
	* 删除
	*/
	int removeWorkTimeDayOmpById(@Param("id") Long id);

}
