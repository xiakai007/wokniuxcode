package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 结果
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 4664139767218297192L;
    private Boolean success;             //成功 失败
    private String message;             //提示信息

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

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result() {
    }
}
