package com.isoftstone.humanresources.domain.organization;

import java.io.Serializable;
import java.util.List;

import com.isoftstone.humanresources.domain.OrganizationInformation;

public class QueryProjectPoVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String organizationID;
    private String organizationName;
    private String organizationType;
    private String parentID;
    private String parentName;
    private String leader;
    private String BU;
    private String BUName;
    private String BD;
    private String BDName;
    private String PDU;
    private String PDUName;
    private List<OrganizationInformation> orgInfoList;
    private String existenceValue;
    private String leaderName;
    
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
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
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public String getParentID() {
		return parentID;
	}
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getBU() {
		return BU;
	}
	public void setBU(String bU) {
		BU = bU;
	}
	public String getBUName() {
		return BUName;
	}
	public void setBUName(String bUName) {
		BUName = bUName;
	}
	public String getBD() {
		return BD;
	}
	public void setBD(String bD) {
		BD = bD;
	}
	public String getBDName() {
		return BDName;
	}
	public void setBDName(String bDName) {
		BDName = bDName;
	}
	public String getPDU() {
		return PDU;
	}
	public void setPDU(String pDU) {
		PDU = pDU;
	}
	public String getPDUName() {
		return PDUName;
	}
	public void setPDUName(String pDUName) {
		PDUName = pDUName;
	}
	public List<OrganizationInformation> getOrgInfoList() {
		return orgInfoList;
	}
	public void setOrgInfoList(List<OrganizationInformation> orgInfoList) {
		this.orgInfoList = orgInfoList;
	}
	public String getExistenceValue() {
		return existenceValue;
	}
	public void setExistenceValue(String existenceValue) {
		this.existenceValue = existenceValue;
	}
    

}
