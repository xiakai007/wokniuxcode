package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 用户
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4638125584727456305L;
    private Integer userID;
    private String username;             //用户名
    private String password;            // 密码
    private Integer status;             //状态  0:正常,1:冻结,2:关闭
    private String lastLoginTime;       //最后登录时间 yyyy-MM-dd HH:mm:ss
    private String userRole;            //用户角色
    private Integer employeeID;         //与t_employee中的employeeID对应
    private String creatTime;           //创建时间
    private String updateTime;          //更改时间
    private String email;               //邮箱
    private String phone;               //电话号码
    private String accessToken;
    private EmployeeInformation emp;   //员工

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeInformation getEmp() {
        return emp;
    }

    public void setEmp(EmployeeInformation emp) {
        this.emp = emp;
    }
}
