package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class EmployeeWorkTimeMonthInfomation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long employeeID;				//员工工号
	private String workStatus;				//考勤状态
	private String personalStatus;			//人员状态
	private String dayCount;				//班次
	private String month;					//考勤月份
	private Integer shouldDays;				//应出勤天数
	private double actualDays;				//实际出勤天数
	private double shouldTimes;				//应出勤工时
	private double actualTimes;				//工作日出勤工时
	private double holidayTimes;			//请假工时
	private double lateTimes;				//迟到工时
	private double leaveEarlyTimes;			//早退工时
	private double absenteeismTimes;		//旷工工时
	private double oweTimes;				//欠工时
	private Integer overtimeNum;			//加班次数
	private double overtimes;				//加班工时
	private double extendTimes;				//工作日延长工时
	private double notBringPcTimes;			//在岸/离岸不带主机付费总工时（人时）
	private double bringPcTimes;			//离岸带主机付费总工时（人时）
	private String inDay;					//入职时间 yyyy-MM-dd
	private String outDay;					//离职时间 yyyy-MM-dd
	private double annualLeave;				//PSA年假工时
	private double restTimes;				//PSA倒休时数
	private double marriageLeave;			//PSA婚假工时
	private double maternityLeave;			//PSA产假工时
	private double prenatalLeave;			//PSA产检假工时
	private double paternityLeave;			//PSA陪产假工时
	private double breastFeeding;			//PSA哺乳假工时
	private double sickLeave;				//PSA病假工时
	private double funeralLeave;			//PSA丧事假
	private double personalLeave;			//PSA事假工时
	private double overtimeRestTimes;		//PSA加班倒休时数
	private double outsideTimes;			//PSA因公外出时数
	private double ehs;						//ehs风险
	private String insufficientReasons;		//工时不足8小时的异常原因
	private String noWorkReasons;			//无考勤的异常原因
	private String monthInsufficientReasons;//月份不足15天的异常原因
	private String bd;						//BD
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public String getPersonalStatus() {
		return personalStatus;
	}
	public void setPersonalStatus(String personalStatus) {
		this.personalStatus = personalStatus;
	}
	public String getDayCount() {
		return dayCount;
	}
	public void setDayCount(String dayCount) {
		this.dayCount = dayCount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getShouldDays() {
		return shouldDays;
	}
	public void setShouldDays(Integer shouldDays) {
		this.shouldDays = shouldDays;
	}
	public double getActualDays() {
		return actualDays;
	}
	public void setActualDays(double actualDays) {
		this.actualDays = actualDays;
	}
	public double getShouldTimes() {
		return shouldTimes;
	}
	public void setShouldTimes(double shouldTimes) {
		this.shouldTimes = shouldTimes;
	}
	public double getActualTimes() {
		return actualTimes;
	}
	public void setActualTimes(double actualTimes) {
		this.actualTimes = actualTimes;
	}
	public double getHolidayTimes() {
		return holidayTimes;
	}
	public void setHolidayTimes(double holidayTimes) {
		this.holidayTimes = holidayTimes;
	}
	public double getLateTimes() {
		return lateTimes;
	}
	public void setLateTimes(double lateTimes) {
		this.lateTimes = lateTimes;
	}
	public double getAbsenteeismTimes() {
		return absenteeismTimes;
	}
	public void setAbsenteeismTimes(double absenteeismTimes) {
		this.absenteeismTimes = absenteeismTimes;
	}
	public double getOweTimes() {
		return oweTimes;
	}
	public void setOweTimes(double oweTimes) {
		this.oweTimes = oweTimes;
	}
	public Integer getOvertimeNum() {
		return overtimeNum;
	}
	public void setOvertimeNum(Integer overtimeNum) {
		this.overtimeNum = overtimeNum;
	}
	public double getOvertimes() {
		return overtimes;
	}
	public void setOvertimes(double overtimes) {
		this.overtimes = overtimes;
	}
	public double getExtendTimes() {
		return extendTimes;
	}
	public void setExtendTimes(double extendTimes) {
		this.extendTimes = extendTimes;
	}
	public double getNotBringPcTimes() {
		return notBringPcTimes;
	}
	public void setNotBringPcTimes(double notBringPcTimes) {
		this.notBringPcTimes = notBringPcTimes;
	}
	public double getLeaveEarlyTimes() {
		return leaveEarlyTimes;
	}
	public void setLeaveEarlyTimes(double leaveEarlyTimes) {
		this.leaveEarlyTimes = leaveEarlyTimes;
	}
	public double getBringPcTimes() {
		return bringPcTimes;
	}
	public void setBringPcTimes(double bringPcTimes) {
		this.bringPcTimes = bringPcTimes;
	}
	public String getInDay() {
		return inDay;
	}
	public void setInDay(String inDay) {
		this.inDay = inDay;
	}
	public String getOutDay() {
		return outDay;
	}
	public void setOutDay(String outDay) {
		this.outDay = outDay;
	}
	public double getAnnualLeave() {
		return annualLeave;
	}
	public void setAnnualLeave(double annualLeave) {
		this.annualLeave = annualLeave;
	}
	public double getRestTimes() {
		return restTimes;
	}
	public void setRestTimes(double restTimes) {
		this.restTimes = restTimes;
	}
	public double getMarriageLeave() {
		return marriageLeave;
	}
	public void setMarriageLeave(double marriageLeave) {
		this.marriageLeave = marriageLeave;
	}
	public double getMaternityLeave() {
		return maternityLeave;
	}
	public void setMaternityLeave(double maternityLeave) {
		this.maternityLeave = maternityLeave;
	}
	public double getPrenatalLeave() {
		return prenatalLeave;
	}
	public void setPrenatalLeave(double prenatalLeave) {
		this.prenatalLeave = prenatalLeave;
	}
	public double getPaternityLeave() {
		return paternityLeave;
	}
	public void setPaternityLeave(double paternityLeave) {
		this.paternityLeave = paternityLeave;
	}
	public double getBreastFeeding() {
		return breastFeeding;
	}
	public void setBreastFeeding(double breastFeeding) {
		this.breastFeeding = breastFeeding;
	}
	public double getSickLeave() {
		return sickLeave;
	}
	public void setSickLeave(double sickLeave) {
		this.sickLeave = sickLeave;
	}
	public double getFuneralLeave() {
		return funeralLeave;
	}
	public void setFuneralLeave(double funeralLeave) {
		this.funeralLeave = funeralLeave;
	}
	public double getPersonalLeave() {
		return personalLeave;
	}
	public void setPersonalLeave(double personalLeave) {
		this.personalLeave = personalLeave;
	}
	public double getOvertimeRestTimes() {
		return overtimeRestTimes;
	}
	public void setOvertimeRestTimes(double overtimeRestTimes) {
		this.overtimeRestTimes = overtimeRestTimes;
	}
	public double getOutsideTimes() {
		return outsideTimes;
	}
	public void setOutsideTimes(double outsideTimes) {
		this.outsideTimes = outsideTimes;
	}
	public double getEhs() {
		return ehs;
	}
	public void setEhs(double ehs) {
		this.ehs = ehs;
	}
	public String getInsufficientReasons() {
		return insufficientReasons;
	}
	public void setInsufficientReasons(String insufficientReasons) {
		this.insufficientReasons = insufficientReasons;
	}
	public String getNoWorkReasons() {
		return noWorkReasons;
	}
	public void setNoWorkReasons(String noWorkReasons) {
		this.noWorkReasons = noWorkReasons;
	}
	public String getMonthInsufficientReasons() {
		return monthInsufficientReasons;
	}
	public void setMonthInsufficientReasons(String monthInsufficientReasons) {
		this.monthInsufficientReasons = monthInsufficientReasons;
	}
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	
}
