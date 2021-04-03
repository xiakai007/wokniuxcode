package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 查询员工列表的请求参数
 */
public class QueryEmpListParam implements Serializable {
    private static final long serialVersionUID = -3431561968680122482L;
    private Integer page;               //当前页
    private Integer pageSize;           //每页显示条数
    private String employeeName;        //员工姓名
    private String costCenter;          //成本中心
    private String issStatus;           //软通状态
    private String certificateName;     //证书名称
    private String organizationName; //项目组名称
    private String riskStatus;       //是否有风险

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    @JsonProperty(value = "BD")
    private String bD;
    @JsonProperty(value = "BU")
    private String bU;
    @JsonProperty(value = "CU")
    private String cU;
    @JsonProperty(value = "PDU")
    private String pDU;
    @JsonProperty(value = "PO")
    private String pO;
    private String projectTeam;         //项目组
    private String employeeID;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getIssStatus() {
        return issStatus;
    }

    public void setIssStatus(String issStatus) {
        this.issStatus = issStatus;
    }

    public String getbD() {
        return bD;
    }

    public void setbD(String bD) {
        this.bD = bD;
    }

    public String getbU() {
        return bU;
    }

    public void setbU(String bU) {
        this.bU = bU;
    }

    public String getcU() {
        return cU;
    }

    public void setcU(String cU) {
        this.cU = cU;
    }

    public String getpDU() {
        return pDU;
    }

    public void setpDU(String pDU) {
        this.pDU = pDU;
    }

    public String getpO() {
        return pO;
    }

    public void setpO(String pO) {
        this.pO = pO;
    }


}
