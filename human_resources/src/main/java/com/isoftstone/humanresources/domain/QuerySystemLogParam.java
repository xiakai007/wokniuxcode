package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 查询系统日志的请求参数
 */
public class QuerySystemLogParam implements Serializable {

    private static final long serialVersionUID = 4679434449775368762L;
    private Integer page;
    private Integer pageSize;
    private Integer employeeID;
    private String loginName;

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

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
