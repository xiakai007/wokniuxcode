package com.woniu.chapter13_abstract_2Bonus;

public abstract class Employee {
	private String empName;
	private int jobNum;
	private double salary;
	
	public Employee() {
	}

	public Employee(String empName, int jobNum, double salary) {
		this.empName = empName;
		this.jobNum = jobNum;
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getJobNum() {
		return jobNum;
	}

	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public abstract void bonus();
	public static String show() {
		return "抽象类的静态方法";
	}

}
