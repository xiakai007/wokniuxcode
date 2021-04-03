package com.isoftstone.humanresources.domain.organization;

import java.io.Serializable;
import java.util.List;

import com.isoftstone.humanresources.domain.OrganizationInformation;

public class OrganizationUpdatePersonVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String organizationID;			//项目组ID
	private String personStatus;			//人员状态
	private String employeeId;				//员工ID
	private List<OrganizationUpdatePersonVO> personList;	//状态改变员工列表
	private OrganizationInformation organizationInfo;		//项目信息列表
	private String updateType;
	
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
	public OrganizationInformation getOrganizationInfo() {
		return organizationInfo;
	}
	public void setOrganizationInfo(OrganizationInformation organizationInfo) {
		this.organizationInfo = organizationInfo;
	}
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public String getPersonStatus() {
		return personStatus;
	}
	public void setPersonStatus(String personStatus) {
		this.personStatus = personStatus;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public List<OrganizationUpdatePersonVO> getPersonList() {
		return personList;
	}
	public void setPersonList(List<OrganizationUpdatePersonVO> personList) {
		this.personList = personList;
	}

}
