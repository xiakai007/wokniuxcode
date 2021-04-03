package com.isoftstone.humanresources.domain;

import java.io.Serializable;

public class SystemConfigInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String systemID;
    private String configType;
    private String configName;
    private String configValue;
    private String createTime;
    private String updateTime;
    private String createEmployeeID;
    private String updateEmployeeID;
    private String bak;

    public String getSystemID() {
        return systemID;
    }

    public void setSystemID(String systemID) {
        this.systemID = systemID;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
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
