package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 基础活动记录表
 * @author bwning
 *
 */
public class EmployeeBasicRecordInformation implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private long employeeID;								//员工编号
	private String employeeName;							//员工姓名
	private String basicType;								//类型
	private double basicScore;								//得分
	private long scoreEmployeeId;							//打分人工号
	private String scoreName;								//打分人姓名
	private String planStartTime;							//计划开始时间
	private String planEndTime;								//计划完成时间
	private String startTime;								//开始时间
	private String endTime;									//完成时间
	private String createTime;								//创建时间
	private String updateTime;								//修改时间
	private String bak;										//备注
	private long updateEmployeeID;							//修改人编码
	private String updateName;								//修改人姓名
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getScoreName() {
		return scoreName;
	}
	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUpdateEmployeeID() {
		return updateEmployeeID;
	}
	public void setUpdateEmployeeID(long updateEmployeeID) {
		this.updateEmployeeID = updateEmployeeID;
	}
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getBasicType() {
		return basicType;
	}
	public void setBasicType(String basicType) {
		this.basicType = basicType;
	}
	public double getBasicScore() {
		return basicScore;
	}
	public void setBasicScore(double basicScore) {
		this.basicScore = basicScore;
	}
	public long getScoreEmployeeId() {
		return scoreEmployeeId;
	}
	public void setScoreEmployeeId(long scoreEmployeeId) {
		this.scoreEmployeeId = scoreEmployeeId;
	}
	public String getPlanStartTime() {
		return planStartTime;
	}
	public void setPlanStartTime(String planStartTime) {
		this.planStartTime = planStartTime;
	}
	public String getPlanEndTime() {
		return planEndTime;
	}
	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
}
