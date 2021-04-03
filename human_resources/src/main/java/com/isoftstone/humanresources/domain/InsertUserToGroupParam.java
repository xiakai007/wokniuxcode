package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 用户组添加用户的请求参数
 */
public class InsertUserToGroupParam implements Serializable {
    private static final long serialVersionUID = -586271809557984303L;
    private Integer groupID;                   //用户组ID
    private Integer[] userID;                  //用户ID

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer[] getUserID() {
        return userID;
    }

    public void setUserID(Integer[] userID) {
        this.userID = userID;
    }
}
