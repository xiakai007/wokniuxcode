package com.isoftstone.humanresources.domain.screen;

import java.io.Serializable;

public class ScreenWarnEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String warnID;
    private String warnContent;
    private String warnStatus;
    private String handlerID;
    private String handlerName;
    private String organizationID;
    private String organizationName;
    private String warnTime;
    private String bak;

    public String getWarnID() {
        return warnID;
    }

    public void setWarnID(String warnID) {
        this.warnID = warnID;
    }

    public String getHandlerID() {
        return handlerID;
    }

    public void setHandlerID(String handlerID) {
        this.handlerID = handlerID;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
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

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    public String getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(String warnTime) {
        this.warnTime = warnTime;
    }

    public String getWarnContent() {
        return warnContent;
    }

    public void setWarnContent(String warnContent) {
        this.warnContent = warnContent;
    }

    public String getWarnStatus() {
        return warnStatus;
    }

    public void setWarnStatus(String warnStatus) {
        this.warnStatus = warnStatus;
    }
}
