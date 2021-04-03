package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 修改密码的请求参数
 */
public class UpdatePasswordRequest implements Serializable {

    private static final long serialVersionUID = 4363332027387885430L;
    private Integer userID;              //用户的ID
    private String repeatPassword;       //用户输入的原始密码
    private String newPassword;         //用户新的密码
    private String repeatNewPassword;   //用户再次输入的新密码
    private String updateTime;          //更新时间

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatNewPassword() {
        return repeatNewPassword;
    }

    public void setRepeatNewPassword(String repeatNewPassword) {
        this.repeatNewPassword = repeatNewPassword;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
