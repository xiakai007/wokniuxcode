package com.isoftstone.humanresources.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.isoftstone.humanresources.domain.EmployeeWorkTimeDayInformation;
import com.isoftstone.humanresources.domain.EmployeeWorkTimeMonthInfomation;

public interface WorkTimeDao {

	/**
	 * 导入月考勤
	 * @param monthTimeList
	 * @return
	 */
	int importWorkTimeMonth(@Param("monthTimeList") List<EmployeeWorkTimeMonthInfomation> monthTimeList);
	
	/**
	 * 获取员工ID集合
	 * @return
	 */
	List<Integer> getEmployeeIds();
	
	/**
	 * 导入日考勤
	 * @param dayTimeList
	 * @return
	 */
	int importWorkTimeDay(@Param("dayTimeList") List<EmployeeWorkTimeDayInformation> dayTimeList);
}
