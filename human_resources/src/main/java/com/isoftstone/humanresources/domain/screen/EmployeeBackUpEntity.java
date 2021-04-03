package com.isoftstone.humanresources.domain.screen;

import java.io.Serializable;

public class EmployeeBackUpEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String employeeID;
    private String employeeName;
    private String backupType;
    private String backupContent;
    private String backupEmployeeID;
    private String backupEmployeeName;
    private String organizationID;
    private String organizationName;
    private String planCompleteDate;
    private String currentProgress;
    private String createDate;
    private String completeDate;
    private String pm;
    private String cuHead;
    private String bak;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBackupType() {
        return backupType;
    }

    public void setBackupType(String backupType) {
        this.backupType = backupType;
    }

    public String getBackupContent() {
        return backupContent;
    }

    public void setBackupContent(String backupContent) {
        this.backupContent = backupContent;
    }

    public String getBackupEmployeeID() {
        return backupEmployeeID;
    }

    public void setBackupEmployeeID(String backupEmployeeID) {
        this.backupEmployeeID = backupEmployeeID;
    }

    public String getBackupEmployeeName() {
        return backupEmployeeName;
    }

    public void setBackupEmployeeName(String backupEmployeeName) {
        this.backupEmployeeName = backupEmployeeName;
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

    public String getPlanCompleteDate() {
        return planCompleteDate;
    }

    public void setPlanCompleteDate(String planCompleteDate) {
        this.planCompleteDate = planCompleteDate;
    }

    public String getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(String currentProgress) {
        this.currentProgress = currentProgress;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getCuHead() {
        return cuHead;
    }

    public void setCuHead(String cuHead) {
        this.cuHead = cuHead;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }
}
