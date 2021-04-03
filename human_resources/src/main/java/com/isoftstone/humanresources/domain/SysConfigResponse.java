package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 查询枚举表响应结果
 */
public class SysConfigResponse implements Serializable {
    private static final long serialVersionUID = 1854345873150808641L;
    private String configName;
    private String configValue;

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
}
