package com.isoftstone.humanresources.domain;

import java.io.Serializable;

import com.isoftstone.humanresources.domain.portraitprojectmanager.PmScoreRes;

public class EmployeeTrainProgramInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private long employeeID;					//员工编号
    private String empName;						//员工名称
    private String trainDirection;				//培训方向
    private String trainDescript;				//培训描述
    private String trainStatus;					//状态
    private double trainCompleteness;			//完成度
    private PmScoreRes train;
    private long scoreEmployeeId;				//负责人工号
    private String scoreName;					//负责人名称
    private String planStartTime;				//计划开始时间
    private String planEndTime;					//计划完成时间
    private String startTime;					//开始时间
    private String endTime;						//完成时间
    private String createTime;					//创建时间
    private String updateTime;					//修改时间
    private String bak;							//备注
    private long updateEmployeeID;				//修改人编号
    private String updateName;					//修改人名称
    
	public PmScoreRes getTrain() {
		return train;
	}
	public void setTrain(PmScoreRes train) {
		this.train = train;
	}
	public long getUpdateEmployeeID() {
		return updateEmployeeID;
	}
	public void setUpdateEmployeeID(long updateEmployeeID) {
		this.updateEmployeeID = updateEmployeeID;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getScoreName() {
		return scoreName;
	}
	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getTrainDirection() {
		return trainDirection;
	}
	public void setTrainDirection(String trainDirection) {
		this.trainDirection = trainDirection;
	}
	public String getTrainDescript() {
		return trainDescript;
	}
	public void setTrainDescript(String trainDescript) {
		this.trainDescript = trainDescript;
	}
	public String getTrainStatus() {
		return trainStatus;
	}
	public void setTrainStatus(String trainStatus) {
		this.trainStatus = trainStatus;
	}
	public double getTrainCompleteness() {
		return trainCompleteness;
	}
	public void setTrainCompleteness(double trainCompleteness) {
		this.trainCompleteness = trainCompleteness;
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
