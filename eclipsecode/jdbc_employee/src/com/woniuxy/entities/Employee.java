package com.woniuxy.entities;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer emp_id;
	private String emp_name;
	private Integer emp_age;
	private String emp_status;
	private Integer emp_type;
	public Employee() {
		super();
	}
	public Employee(Integer emp_id, String emp_name, Integer emp_age, String emp_status, Integer emp_type) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.emp_status = emp_status;
		this.emp_type = emp_type;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Integer getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(Integer emp_age) {
		this.emp_age = emp_age;
	}
	public String getEmp_status() {
		return emp_status;
	}
	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}
	public Integer getEmp_type() {
		return emp_type;
	}
	public void setEmp_type(Integer emp_type) {
		this.emp_type = emp_type;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_age=" + emp_age + ", emp_status="
				+ emp_status + ", emp_type=" + emp_type + "]";
	}
	


}
