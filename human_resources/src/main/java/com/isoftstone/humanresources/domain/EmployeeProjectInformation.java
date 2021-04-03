package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class EmployeeProjectInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer ID;                  //主键
    private long employeeID;			//员工编号
    private String projectID;			//项目编号
    private String projectName;			//项目名称
    private String projectDescription;	//项目描述
    private String entryProjectDate;	//入项日期
    private String leaveProjectDate;	//离项日期
    private String projectRole;			//在项目中的角色
    private String projectContribution;	//对项目编号的贡献
    private String leaveProjectCause;	//离项原因
    private String createTime;			//创建时间
    private String updateTime;			//更新时间
    private String bak;					//备注
	private OrganizationInformation organizationInformation;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getEntryProjectDate() {
		return entryProjectDate;
	}

	public void setEntryProjectDate(String entryProjectDate) {
		this.entryProjectDate = entryProjectDate;
	}

	public String getLeaveProjectDate() {
		return leaveProjectDate;
	}

	public void setLeaveProjectDate(String leaveProjectDate) {
		this.leaveProjectDate = leaveProjectDate;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public String getProjectContribution() {
		return projectContribution;
	}

	public void setProjectContribution(String projectContribution) {
		this.projectContribution = projectContribution;
	}

	public String getLeaveProjectCause() {
		return leaveProjectCause;
	}

	public void setLeaveProjectCause(String leaveProjectCause) {
		this.leaveProjectCause = leaveProjectCause;
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

	public OrganizationInformation getOrganizationInformation() {
		return organizationInformation;
	}

	public void setOrganizationInformation(OrganizationInformation organizationInformation) {
		this.organizationInformation = organizationInformation;
	}
}
