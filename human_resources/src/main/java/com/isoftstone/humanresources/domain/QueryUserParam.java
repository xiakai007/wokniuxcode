package com.isoftstone.humanresources.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 查询用户组下的用户列表的请求参数
 */
public class QueryUserParam implements Serializable {

    private static final long serialVersionUID = -8403491604223598623L;
    private Integer groupID;             //用户组ID
    private Integer page;             //当前页
    private Integer pageSize;         //每页显示条数
    private String employeeName;

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

    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
