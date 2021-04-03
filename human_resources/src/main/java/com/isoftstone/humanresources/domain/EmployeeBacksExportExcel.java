package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工备份excel导出
 */
public class EmployeeBacksExportExcel implements Serializable {

    private static final long serialVersionUID = -4163978632620365506L;
    private Integer employeeID;

    private String backupType;

    private String backupContent;

    private Integer backupEmployeeID;

    private String organizationID;

    private String planCompleteDate;

    private String currentProgress;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String createDate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String completeDate;

    private String pm;

    private String cuHead;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String updateDate;

    private String bak;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
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

    public Integer getBackupEmployeeID() {
        return backupEmployeeID;
    }

    public void setBackupEmployeeID(Integer backupEmployeeID) {
        this.backupEmployeeID = backupEmployeeID;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
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

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }
}
