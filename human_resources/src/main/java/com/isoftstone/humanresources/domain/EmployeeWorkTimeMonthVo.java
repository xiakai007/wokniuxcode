package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 员工月考勤
 */
public class EmployeeWorkTimeMonthVo extends EmployeeWorkTimeMonthInfomation implements Serializable {
    private static final long serialVersionUID = 4145815670701983684L;

    private String employeeName;
    private String costCenter;
    private String organizationName;        //项目组名称

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
