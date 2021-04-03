package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 查询用户的请求参数
 */
public class QueryUserRequest implements Serializable {
    private static final long serialVersionUID = 4730716549216804069L;
    private String username;             //用户名
    private Integer status;             //状态  0:正常,1:冻结,2:关闭
    private String realName;            // 真实姓名
    private Integer page;             //当前页
    private Integer pageSize;         //每页显示条数
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

    private String projectTeam;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    private String employeeID;


    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
