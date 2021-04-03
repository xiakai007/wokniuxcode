package com.isoftstone.humanresources.domain;
import java.io.Serializable;
import java.util.List;
public class OrganizationInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    private String organizationID;
    private String contractID;
    private String organizationName;
    private String organizationStatus;
    private String organizationLevel;
    private String organizationMaturity;
    private String organizationType;
    private String parentID;
    private String projectType;
    private String officeSpace;
    private String cooperationModel;
    private String skill;
    private String createDate;
    private String updateDate;
    private String costCenter;
    private String leader;
    private String area;
    private String businessLine;
    private String BU;
    private String BUName;
    private String BD;
    private String BDName;
    private String CU;
    private String CUName;
    private String PDU;
    private String PDUName;
    private String PO;
    private String POName;
    private String existenceValue;
    private String planningScale;
    private String isBU;
    private String imgURL;
    //父节点名称
    private String parentName;
    //leader名字
    private String leaderName;
    //是否可点击
    private boolean isAccording;
    private String organizationAlias;
    //合同状态
    private String contractStatus;
    //预定签订合同日期,yyyy-mm-dd
    private String scheduledContractDate;
    //预计开始时间,yyyy-mm-dd
    private String scheduledStartDate;
    //预计结束时间,yyyy-mm-dd
    private String scheduledEndDate;
    //实施结项时间
    private String postProjectDate;
    //新增po项目ID
    private List<String> projectIds;
    //分组ID
    private String organizationgroupID;
	public String getOrganizationgroupID() {
		return organizationgroupID;
	}
	public void setOrganizationgroupID(String organizationgroupID) {
		this.organizationgroupID = organizationgroupID;
	}
	public List<String> getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(List<String> projectIds) {
		this.projectIds = projectIds;
	}
	public String getPostProjectDate() {
		return postProjectDate;
	}
	public void setPostProjectDate(String postProjectDate) {
		this.postProjectDate = postProjectDate;
	}
	public String getOrganizationAlias() {
		return organizationAlias;
	}
	public void setOrganizationAlias(String organizationAlias) {
		this.organizationAlias = organizationAlias;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getScheduledContractDate() {
		return scheduledContractDate;
	}
	public void setScheduledContractDate(String scheduledContractDate) {
		this.scheduledContractDate = scheduledContractDate;
	}
	public String getScheduledStartDate() {
		return scheduledStartDate;
	}
	public void setScheduledStartDate(String scheduledStartDate) {
		this.scheduledStartDate = scheduledStartDate;
	}
	public String getScheduledEndDate() {
		return scheduledEndDate;
	}
	public void setScheduledEndDate(String scheduledEndDate) {
		this.scheduledEndDate = scheduledEndDate;
	}
	public void setAccording(boolean isAccording) {
		this.isAccording = isAccording;
	}
	public boolean getIsAccording() {
		return isAccording;
	}
	public void setIsAccording(boolean isAccording) {
		this.isAccording = isAccording;
	}
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
    public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getPlanningScale() {
        return planningScale;
    }
    public void setPlanningScale(String planningScale) {
        this.planningScale = planningScale;
    }
    //健康检查列表
    private List<HealthCheckInformation> healthCheckInformationList ;

    //组织下的员工信息
    private List<EmployeeInformation> employeeInformationList ;
    public List<EmployeeInformation> getEmployeeInformationList() {
        return employeeInformationList;
    }
    public void setEmployeeInformationList(List<EmployeeInformation> employeeInformationList) {
        this.employeeInformationList = employeeInformationList;
    }
    public List<HealthCheckInformation> getHealthCheckInformationList() {
        return healthCheckInformationList;
    }
    public void setHealthCheckInformationList(List<HealthCheckInformation> healthCheckInformationList) {
        this.healthCheckInformationList = healthCheckInformationList;
    }
    public String getOrganizationID() {
        return organizationID;
    }
    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }
    public String getContractID() {
        return contractID;
    }
    public void setContractID(String contractID) {
        this.contractID = contractID;
    }
    public String getOrganizationName() {
        return organizationName;
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public String getOrganizationStatus() {
        return organizationStatus;
    }
    public void setOrganizationStatus(String organizationStatus) {
        this.organizationStatus = organizationStatus;
    }
    public String getOrganizationLevel() {
        return organizationLevel;
    }
    public void setOrganizationLevel(String organizationLevel) {
        this.organizationLevel = organizationLevel;
    }
    public String getOrganizationMaturity() {
        return organizationMaturity;
    }
    public void setOrganizationMaturity(String organizationMaturity) {
        this.organizationMaturity = organizationMaturity;
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
    public String getProjectType() {
        return projectType;
    }
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    public String getOfficeSpace() {
        return officeSpace;
    }
    public void setOfficeSpace(String officeSpace) {
        this.officeSpace = officeSpace;
    }
    public String getCooperationModel() {
        return cooperationModel;
    }
    public void setCooperationModel(String cooperationModel) {
        this.cooperationModel = cooperationModel;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    public String getCostCenter() {
        return costCenter;
    }
    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }
    public String getLeader() {
        return leader;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getBusinessLine() {
        return businessLine;
    }
    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }
    public String getBU() {
        return BU;
    }
    public void setBU(String BU) {
        this.BU = BU;
    }
    public String getBD() {
        return BD;
    }
    public void setBD(String BD) {
        this.BD = BD;
    }
    public String getBUName() {
        return BUName;
    }
    public void setBUName(String BUName) {
        this.BUName = BUName;
    }
    public String getBDName() {
        return BDName;
    }
    public void setBDName(String BDName) {
        this.BDName = BDName;
    }
    public String getCU() {
        return CU;
    }
    public void setCU(String CU) {
        this.CU = CU;
    }
    public String getCUName() {
        return CUName;
    }
    public void setCUName(String CUName) {
        this.CUName = CUName;
    }
    public String getPDUName() {
        return PDUName;
    }
    public void setPDUName(String PDUName) {
        this.PDUName = PDUName;
    }
    public String getPOName() {
        return POName;
    }
    public void setPOName(String POName) {
        this.POName = POName;
    }
    public boolean isAccording() {
        return isAccording;
    }
    public String getPDU() {
        return PDU;
    }
    public void setPDU(String PDU) {
        this.PDU = PDU;
    }
    public String getPO() {
        return PO;
    }
    public void setPO(String PO) {
        this.PO = PO;
    }
    public String getExistenceValue() {
        return existenceValue;
    }
    public void setExistenceValue(String existenceValue) {
        this.existenceValue = existenceValue;
    }
	public String getIsBU() {
		return isBU;
	}
	public void setIsBU(String isBU) {
		this.isBU = isBU;
	}
}
