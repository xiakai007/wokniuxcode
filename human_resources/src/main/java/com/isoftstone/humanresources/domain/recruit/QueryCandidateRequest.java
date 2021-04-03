package com.isoftstone.humanresources.domain.recruit;

import java.io.Serializable;

/**
 * 查询用户列表的请求参数
 */
public class QueryCandidateRequest implements Serializable {
    private static final long serialVersionUID = -1L;
    private String candidateName;      //候选人名称
    private String email;              //候选人邮箱
    private String mobile;              //候选人电话
    private String status;              //候选人状态
    private Integer page;             //当前页
    private Integer pageSize;         //每页显示条数

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
