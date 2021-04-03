package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class EmployeePerformanceInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long employeeID;				//员工编号
    private String startDate;				//考核开始时间
    private String endDate;					//考核结束时间
    private String type;					//考核类型
    private long score;						//绩效分数
    private String level;					//绩效等级
    private String maternityLeave;			//休产假天数
    private String isGt45;					//是否大于45天
    private String isManageAgreed;			//是否平台总经理形式行权
    private String remark;					//备注
    private String quarter;					//考核季度
    private String year;					//年度

	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMaternityLeave() {
		return maternityLeave;
	}
	public void setMaternityLeave(String maternityLeave) {
		this.maternityLeave = maternityLeave;
	}
	public String getIsGt45() {
		return isGt45;
	}
	public void setIsGt45(String isGt45) {
		this.isGt45 = isGt45;
	}
	public String getIsManageAgreed() {
		return isManageAgreed;
	}
	public void setIsManageAgreed(String isManageAgreed) {
		this.isManageAgreed = isManageAgreed;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
