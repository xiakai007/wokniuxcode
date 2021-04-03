package com.isoftstone.humanresources.domain;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件
 */
public class SendMessageInfo implements Serializable {
    private static final long serialVersionUID = 5734135734563952953L;
    private Integer mailID;
    private String title;
    private String content;
    private String dealUser;
    private String toUser;
    private String toEmail;
    private String ccUser;
    private String ccEmail;
    private Integer status;
    private Date createTime;
    private Date sendTime;
    private Integer messageType;
    private String department;

    public Integer getMailID() {
        return mailID;
    }

    public void setMailID(Integer mailID) {
        this.mailID = mailID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDealUser() {
        return dealUser;
    }

    public void setDealUser(String dealUser) {
        this.dealUser = dealUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getCcUser() {
        return ccUser;
    }

    public void setCcUser(String ccUser) {
        this.ccUser = ccUser;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
