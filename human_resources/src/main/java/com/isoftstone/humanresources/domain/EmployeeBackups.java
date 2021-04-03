package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;
import java.util.Date;

/**
 * 员工备份
 */
public class EmployeeBackups implements Serializable {
    private static final long serialVersionUID = -2995730751066142705L;
    @JsonProperty("ID")
    private Integer id;
    private Integer employeeID; //备份人员编号
    private String backupType;  //备份类型
    private String backupContent; //备份编号
    private Integer backupEmployeeID; //承接人员编号
    private String organizationID;   //备份组织编码
    private String planCompleteDate;  //计划完成时间
    private String currentProgress;  //当前进展
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createDate;         //创建时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date completeDate;      //完成时间
    private String pm;              //项目经理
    private String cuHead;          //CU Head
    private String bak;             //备注
    private String employeeName;   //备份人员姓名
    private String backEmpName;   //承接人员姓名
    private String organizationName; //组织名称
    private Date updateDate;        //更新日期
    @JsonProperty(value = "CU")
    private String CU;               //CU
    private String pmName;            //PM姓名
    private String cuHeadName;       //cuhead姓名
    private String backupName;       //备份类型的值

    public String getBackupName() {
        return backupName;
    }

    public void setBackupName(String backupName) {
        this.backupName = backupName;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getCuHeadName() {
        return cuHeadName;
    }

    public void setCuHeadName(String cuHeadName) {
        this.cuHeadName = cuHeadName;
    }

    public String getCU() {
        return CU;
    }

    public void setCU(String CU) {
        this.CU = CU;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBackEmpName() {
        return backEmpName;
    }

    public void setBackEmpName(String backEmpName) {
        this.backEmpName = backEmpName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
