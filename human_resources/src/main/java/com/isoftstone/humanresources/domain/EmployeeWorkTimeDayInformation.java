package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class EmployeeWorkTimeDayInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long employeeID;				//员工编号
    private String workStatus;				//考勤状态
    private String personalStatus;			//员工状态
    private String dayCount;				//班次
    private String workDay;					//考勤日期
    private String dayCatagray;				//日期类型
    private String firstRecordTime;			//初次打卡
    private String lastRecordTime;			//末次打卡
    private double actualTimes;				//出勤工时
    private double holidayTimes;			//请假工时
    private double outWorkTimes;			//因公外出工时
    private double absenteeismTimes;		//旷工工时
    private double workBadTimes;			//异常工时
    private double penalizeTimes;			//迟到,早退处罚工时
    private double overtimes;				//加班工时
    private double extendTimes;			//延长工时
    private double annualLeave;			//PSA年假工时
    private double restTimes;			//PSA倒休时数
    private double marriageLeave;			//PSA婚假工时
    private double maternityLeave;			//PSA产假工时
    private double paternityLeave;			//PSA陪产假工时
    private double breastFeeding;			//PSA哺乳假工时
    private double sickLeave;			//PSA病假工时
    private double funeralLeave;			//PSA丧事假
    private double personalLeave;			//PSA事假工时
    private double overtimeRestTimes;			//PSA加班倒休时数
    private double outsideTimes;			//PSA因公外出时数
    private String copCatagray;			//合作类型
    private String copModel;			//合作模式
    private String monthInShore;			//月度在岸/离岸
    private String dayBringPcOutShore;
    private double lateTimes;				//迟到工时
    
	public double getLateTimes() {
		return lateTimes;
	}
	public void setLateTimes(double lateTimes) {
		this.lateTimes = lateTimes;
	}
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
	public String getWorkDay() {
		return workDay;
	}
	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}
	public String getDayCatagray() {
		return dayCatagray;
	}
	public void setDayCatagray(String dayCatagray) {
		this.dayCatagray = dayCatagray;
	}
	public String getFirstRecordTime() {
		return firstRecordTime;
	}
	public void setFirstRecordTime(String firstRecordTime) {
		this.firstRecordTime = firstRecordTime;
	}
	public String getLastRecordTime() {
		return lastRecordTime;
	}
	public void setLastRecordTime(String lastRecordTime) {
		this.lastRecordTime = lastRecordTime;
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
	public double getOutWorkTimes() {
		return outWorkTimes;
	}
	public void setOutWorkTimes(double outWorkTimes) {
		this.outWorkTimes = outWorkTimes;
	}
	public double getAbsenteeismTimes() {
		return absenteeismTimes;
	}
	public void setAbsenteeismTimes(double absenteeismTimes) {
		this.absenteeismTimes = absenteeismTimes;
	}
	public double getWorkBadTimes() {
		return workBadTimes;
	}
	public void setWorkBadTimes(double workBadTimes) {
		this.workBadTimes = workBadTimes;
	}
	public double getPenalizeTimes() {
		return penalizeTimes;
	}
	public void setPenalizeTimes(double penalizeTimes) {
		this.penalizeTimes = penalizeTimes;
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
	public String getCopCatagray() {
		return copCatagray;
	}
	public void setCopCatagray(String copCatagray) {
		this.copCatagray = copCatagray;
	}
	public String getCopModel() {
		return copModel;
	}
	public void setCopModel(String copModel) {
		this.copModel = copModel;
	}
	public String getMonthInShore() {
		return monthInShore;
	}
	public void setMonthInShore(String monthInShore) {
		this.monthInShore = monthInShore;
	}
	public String getDayBringPcOutShore() {
		return dayBringPcOutShore;
	}
	public void setDayBringPcOutShore(String dayBringPcOutShore) {
		this.dayBringPcOutShore = dayBringPcOutShore;
	}		//离岸自带主机
	@Override
	public String toString() {
		return "EmployeeWorkTimeDayInformation [employeeID=" + employeeID + ", workStatus=" + workStatus
				+ ", personalStatus=" + personalStatus + ", dayCount=" + dayCount + ", workDay=" + workDay
				+ ", dayCatagray=" + dayCatagray + ", firstRecordTime=" + firstRecordTime + ", lastRecordTime="
				+ lastRecordTime + ", actualTimes=" + actualTimes + ", holidayTimes=" + holidayTimes + ", outWorkTimes="
				+ outWorkTimes + ", absenteeismTimes=" + absenteeismTimes + ", workBadTimes=" + workBadTimes
				+ ", penalizeTimes=" + penalizeTimes + ", overtimes=" + overtimes + ", extendTimes=" + extendTimes
				+ ", annualLeave=" + annualLeave + ", restTimes=" + restTimes + ", marriageLeave=" + marriageLeave
				+ ", maternityLeave=" + maternityLeave + ", paternityLeave=" + paternityLeave + ", breastFeeding="
				+ breastFeeding + ", sickLeave=" + sickLeave + ", funeralLeave=" + funeralLeave + ", personalLeave="
				+ personalLeave + ", overtimeRestTimes=" + overtimeRestTimes + ", outsideTimes=" + outsideTimes
				+ ", copCatagray=" + copCatagray + ", copModel=" + copModel + ", monthInShore=" + monthInShore
				+ ", dayBringPcOutShore=" + dayBringPcOutShore + ", lateTimes=" + lateTimes + "]";
	}
    
    
    

}
