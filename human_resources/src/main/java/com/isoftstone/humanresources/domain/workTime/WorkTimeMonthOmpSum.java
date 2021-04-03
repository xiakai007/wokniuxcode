package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Description: [员工OMP月考勤记录model]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class WorkTimeMonthOmpSum implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String num;

	private String extraTimes;

	private String overTimes;

	private String extraTimesAvg;

	private String extraTimesAvgPerDay;

	private String pdu;

	private String department;

	public String getPdu() {
		return pdu;
	}

	public void setPdu(String pdu) {
		this.pdu = pdu;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getExtraTimes() {
		return extraTimes;
	}

	public void setExtraTimes(String extraTimes) {
		this.extraTimes = extraTimes;
	}

	public String getOverTimes() {
		return overTimes;
	}

	public void setOverTimes(String overTimes) {
		this.overTimes = overTimes;
	}

	public String getExtraTimesAvg() {
		return extraTimesAvg;
	}

	public void setExtraTimesAvg(String extraTimesAvg) {
		this.extraTimesAvg = extraTimesAvg;
	}

	public String getExtraTimesAvgPerDay() {
		return extraTimesAvgPerDay;
	}

	public void setExtraTimesAvgPerDay(String extraTimesAvgPerDay) {
		this.extraTimesAvgPerDay = extraTimesAvgPerDay;
	}
}
