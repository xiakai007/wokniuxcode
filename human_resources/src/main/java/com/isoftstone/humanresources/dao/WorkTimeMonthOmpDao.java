package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.workTime.*;
import com.isoftstone.humanresources.domain.Page;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
 * <p>Description: [员工OMP月考勤记录dao]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public interface WorkTimeMonthOmpDao{
	
	/**
	* 分页查询固定参数
	*/
	List<WorkTimeMonthOmpModel> queryPageWorkTimeMonthOmp(@Param("page") Page page, @Param("entity") WorkTimeMonthOmpModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询固定参数
	*/
	List<WorkTimeMonthOmpModel> queryListWorkTimeMonthOmp(@Param("entity") WorkTimeMonthOmpModel entity, @Param("queryFields") List queryFields);

	/**
	* 查询总数量
	*/
	Long queryCountWorkTimeMonthOmp(@Param("entity") WorkTimeMonthOmpModel entity);
	
	/**
	* 查询单个实体
	*/
	WorkTimeMonthOmpModel queryWorkTimeMonthOmpById(@Param("id") Long id, @Param("queryFields") List queryFields);
	
	/**
	* 新增
	*/
	int addWorkTimeMonthOmp(WorkTimeMonthOmpModel entity);

	int importWorkTimeMonth(@Param("monthTimeList") List<WorkTimeMonthOmpModel> monthTimeList);
	
	/**
	* 修改
	*/
	int updateWorkTimeMonthOmp(WorkTimeMonthOmpModel entity);
	
	/**
	* 批量删除
	*/
	int removeWorkTimeMonthOmpByIds(List code);
	
	/**
	* 删除
	*/
	int removeWorkTimeMonthOmpById(@Param("id") Long id);

	List<ExportDiffentMonth>  exportDifMonth();

	List<ExportDiffentDay>  exportDifDay();

	List<WorkTimeMonthOmpOverTimes>  exportOMPOvertimes();

	List<WorkTimeMonthOmpOverTimes>  exportOMPSumtimes();

	List<WorkTimeMonthOmpSum> exportOMPSumPdu();

	List<WorkTimeMonthOmpSum> exportOMPSumDepartment();

	List<WorkTimeMonthOmpSumByPm> exportOMPSumByPm();

	List<WorkTimeMonthOmpOverTimes> exportOMPException( @Param("changetype")String changetype) ;


}
