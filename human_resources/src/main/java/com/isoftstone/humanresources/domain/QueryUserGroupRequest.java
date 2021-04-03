package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 查询用户列表的请求参数
 */
public class QueryUserGroupRequest implements Serializable {
    private static final long serialVersionUID = 7222168399570695852L;
    private String groupName;              //用户组名称
    private String status;               //状态
    private Integer page;             //当前页
    private Integer pageSize;         //每页显示条数

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
