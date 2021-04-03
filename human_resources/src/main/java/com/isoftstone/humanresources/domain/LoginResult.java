package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 用户登录的响应参数
 */
public class LoginResult implements Serializable {
    private static final long serialVersionUID = -1271021118361177150L;
    private Boolean success;                               //是否成功
    private String message;                                //提示信息
    private User user;                                     //用户信息
    private EmployeeInformation employeeInformation;       //员工信息


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EmployeeInformation getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    public LoginResult(Boolean success, String message, User user, EmployeeInformation employeeInformation) {
        this.success = success;
        this.message = message;
        this.user = user;
        this.employeeInformation = employeeInformation;
    }

    public LoginResult() {
    }
}
