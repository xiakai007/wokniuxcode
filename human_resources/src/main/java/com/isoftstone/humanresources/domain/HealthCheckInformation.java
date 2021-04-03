package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class HealthCheckInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String organizationID;
    private String ruleType;
    private String ruleName;
    private String ruleValue;
    private String createTime;
    private String updateTime;
    private String createEmployeeID;
    private String updateEmployeeID;
    private String bak;

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateEmployeeID() {
        return createEmployeeID;
    }

    public void setCreateEmployeeID(String createEmployeeID) {
        this.createEmployeeID = createEmployeeID;
    }

    public String getUpdateEmployeeID() {
        return updateEmployeeID;
    }

    public void setUpdateEmployeeID(String updateEmployeeID) {
        this.updateEmployeeID = updateEmployeeID;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }
}
