package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;

/**
 * <p>Description: [员工OMP月考勤记录model]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class WorkTimeMonthOmpSumByPm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String area;

	private String pm ;
	private String countnum ;
	private String holidayTimesCount ;
	private String holidaytimes ;
	private String lateTimesCount ;
	private String latetimes ;
	private String leaveEarlyTimesCount ;
	private String LeaveEarlytimes ;
	private String absenteeismTimesCount ;
	private String absenteeismtimes ;
	private String oweTimesCount ;
	private String owetimes ;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public String getCountnum() {
		return countnum;
	}

	public void setCountnum(String countnum) {
		this.countnum = countnum;
	}

	public String getHolidayTimesCount() {
		return holidayTimesCount;
	}

	public void setHolidayTimesCount(String holidayTimesCount) {
		this.holidayTimesCount = holidayTimesCount;
	}

	public String getHolidaytimes() {
		return holidaytimes;
	}

	public void setHolidaytimes(String holidaytimes) {
		this.holidaytimes = holidaytimes;
	}

	public String getLateTimesCount() {
		return lateTimesCount;
	}

	public void setLateTimesCount(String lateTimesCount) {
		this.lateTimesCount = lateTimesCount;
	}

	public String getLatetimes() {
		return latetimes;
	}

	public void setLatetimes(String latetimes) {
		this.latetimes = latetimes;
	}

	public String getLeaveEarlyTimesCount() {
		return leaveEarlyTimesCount;
	}

	public void setLeaveEarlyTimesCount(String leaveEarlyTimesCount) {
		this.leaveEarlyTimesCount = leaveEarlyTimesCount;
	}

	public String getLeaveEarlytimes() {
		return LeaveEarlytimes;
	}

	public void setLeaveEarlytimes(String leaveEarlytimes) {
		LeaveEarlytimes = leaveEarlytimes;
	}

	public String getAbsenteeismTimesCount() {
		return absenteeismTimesCount;
	}

	public void setAbsenteeismTimesCount(String absenteeismTimesCount) {
		this.absenteeismTimesCount = absenteeismTimesCount;
	}

	public String getAbsenteeismtimes() {
		return absenteeismtimes;
	}

	public void setAbsenteeismtimes(String absenteeismtimes) {
		this.absenteeismtimes = absenteeismtimes;
	}

	public String getOweTimesCount() {
		return oweTimesCount;
	}

	public void setOweTimesCount(String oweTimesCount) {
		this.oweTimesCount = oweTimesCount;
	}

	public String getOwetimes() {
		return owetimes;
	}

	public void setOwetimes(String owetimes) {
		this.owetimes = owetimes;
	}
}
