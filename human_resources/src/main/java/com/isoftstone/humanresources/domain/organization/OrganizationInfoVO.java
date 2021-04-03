package com.isoftstone.humanresources.domain.organization;
import java.io.Serializable;
public class OrganizationInfoVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String organizationID;				//组织编号
	private String organizationName;			//部门名称
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}
