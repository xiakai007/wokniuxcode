package com.isoftstone.humanresources.domain;

import java.io.Serializable;

/**
 * 员工绩效
 */
public class EmployeePerfomanceVo extends EmployeePerformanceInformation implements Serializable {
    private static final long serialVersionUID = 4967677650404915938L;

    private String employeeName;            //员工名称
    private String costCenter;              //成本中心名称
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
