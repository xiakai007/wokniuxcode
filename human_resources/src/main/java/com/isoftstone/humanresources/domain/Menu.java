package com.isoftstone.humanresources.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = 3465552102474426242L;
    private Integer menuCode;             //菜单项编号
    private String parentCode;            //上一级菜单编号
    private String parentCodes;            //所有父菜单编号，当前节点所有父节点使用,拼接后的字符串
    private String authorityValue;       //功能权限值，对应接口权限
    private String menuName;             //菜单名称
    private String desc;                 //菜单描述
    private String path;                 //菜单路径
    private Integer status;             //状态 0：正常、1：关闭、2：不展示；默认值：0
    private String creatTime;           //创建时间
    private String updateTime;          //更新时间
    private List<Menu> childrens;

    public Integer getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(Integer menuCode) {
        this.menuCode = menuCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCodes() {
        return parentCodes;
    }

    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }

    public String getAuthorityValue() {
        return authorityValue;
    }

    public void setAuthorityValue(String authorityValue) {
        this.authorityValue = authorityValue;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<Menu> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Menu> childrens) {
        this.childrens = childrens;
    }
}
