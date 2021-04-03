package com.isoftstone.humanresources.domain;

import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 * 查询工单的请求参数
 */
public class QueryOrderParam implements Serializable {
    private static final long serialVersionUID = 3477977123098616857L;
    private Integer page;         //当前页
    private Integer pageSize;     //每页显示的条数
    private Integer creator;     //创建者
    private Integer designator; //指派者
    private Integer solver;     //解决者
    private String status;      //状态

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

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getDesignator() {
        return designator;
    }

    public void setDesignator(Integer designator) {
        this.designator = designator;
    }

    public Integer getSolver() {
        return solver;
    }

    public void setSolver(Integer solver) {
        this.solver = solver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
