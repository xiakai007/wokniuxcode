package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 查询CUHead的响应结果
 */
public class QueryCuheadResponse implements Serializable {
    private static final long serialVersionUID = 3986722500985745096L;
    private Integer userID;          //用户名
    private String employeename;    //员工姓名
    private Integer employeeID;     //员工编号

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }
}
