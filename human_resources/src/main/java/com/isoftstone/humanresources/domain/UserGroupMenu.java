package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 用户组菜单
 */
public class UserGroupMenu implements Serializable {
    private static final long serialVersionUID = 2294787596987073429L;
    private Integer groupID;      //用户组编号
    private Integer menuID;       //菜单编号
    public Integer getMenuID() {
        return menuID;
    }
    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }
}
