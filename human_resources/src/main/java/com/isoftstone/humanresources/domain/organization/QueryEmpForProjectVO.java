package com.isoftstone.humanresources.domain.organization;

import java.io.Serializable;

public class QueryEmpForProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long employeeId;					//员工id
    private String employeeName;				//员工姓名
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
