package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 查询员工绩效的请求参数
 */
public class QueryEmpPerformaceParam extends QueryEmpListParam implements Serializable {
    private static final long serialVersionUID = 8789080903396676184L;
    private String quarter;             //绩效表的季度

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
}
