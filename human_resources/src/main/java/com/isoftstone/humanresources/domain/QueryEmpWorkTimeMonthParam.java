package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 查询月度考勤的请求参数
 */
public class QueryEmpWorkTimeMonthParam extends QueryEmpListParam implements Serializable {
    private static final long serialVersionUID = 8182530873344537537L;
    private  String month; //月份

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
