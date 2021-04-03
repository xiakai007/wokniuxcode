package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 用户组添加权限的请求参数
 */
public class InsertMenuToGroupParam implements Serializable {
    private static final long serialVersionUID = 8580609058325065687L;
    private Integer[] menuIDs;                //权限ID
    private Integer groupID;                //用户组ID

    public Integer[] getMenuIDs() {
        return menuIDs;
    }

    public void setMenuIDs(Integer[] menuIDs) {
        this.menuIDs = menuIDs;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }
}
