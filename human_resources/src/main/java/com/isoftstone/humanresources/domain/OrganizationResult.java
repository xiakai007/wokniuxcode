package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 查询组织的结果
 */
public class OrganizationResult implements Serializable {
    private static final long serialVersionUID = 1468699076329283799L;
    private String orgName;                  //组织名称
    private String orgValue;                 //组织的值
    //为了前台获取数据的便利，添加以下几个字段
    private String BD;
    private String BU;
    private String CU;
    private String PO;
    private String projectTeam;

    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getBU() {
        return BU;
    }

    public void setBU(String BU) {
        this.BU = BU;
    }

    public String getCU() {
        return CU;
    }

    public void setCU(String CU) {
        this.CU = CU;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgValue() {
        return orgValue;
    }

    public void setOrgValue(String orgValue) {
        this.orgValue = orgValue;
    }

    public OrganizationResult(String orgName, String orgValue) {
        this.orgName = orgName;
        this.orgValue = orgValue;
    }

    public OrganizationResult() {
    }
}
