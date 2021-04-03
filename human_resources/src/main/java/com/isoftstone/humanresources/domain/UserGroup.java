package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 用户组
 */
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 5259370685358419989L;
    private Integer groupID;              //用户组ID
    private String groupName;              //用户组名称
    private String creatTime;              //创建时间
    private String status;               //状态
    private String updateTime;            // 更新时间
    private String bak;                   //备份
    private String desc;                   //描述
    private String organization;          //组织

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
