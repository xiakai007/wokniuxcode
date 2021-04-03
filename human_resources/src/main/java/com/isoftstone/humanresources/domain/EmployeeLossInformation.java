package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class EmployeeLossInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer employeeID;			//员工ID
    private String leaveDate;			//离职日期
    private String leaveType;			//离职类型
    private String leaveCauseSort;		//离职原因分类
    private String leaveCause;			//离职原因
    private String leaveCauseDetial;	//离职详情
    private String createTime;			//创建日期
    private String updateTime;			//修改日期
    private String bak;					//备注
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveCauseSort() {
		return leaveCauseSort;
	}
	public void setLeaveCauseSort(String leaveCauseSort) {
		this.leaveCauseSort = leaveCauseSort;
	}
	public String getLeaveCause() {
		return leaveCause;
	}
	public void setLeaveCause(String leaveCause) {
		this.leaveCause = leaveCause;
	}
	public String getLeaveCauseDetial() {
		return leaveCauseDetial;
	}
	public void setLeaveCauseDetial(String leaveCauseDetial) {
		this.leaveCauseDetial = leaveCauseDetial;
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
