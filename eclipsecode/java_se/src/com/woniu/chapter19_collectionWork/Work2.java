package com.woniu.chapter19_collectionWork;

import org.junit.Test;

class Employees implements Comparable<Employees>{
	String name;
	String eno;
	int gender;//0男 1女
	float salary;
	int deptId;
	public Employees(String name, String eno, int gender, float salary, int deptId) {
		super();
		this.name = name;
		this.eno = eno;
		this.gender = gender;
		this.salary = salary;
		this.deptId = deptId;
	}
	
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public int compareTo(Employees o) {
		return (int)(o.salary-this.getSalary());
	}
	
	
}
public class Work2 {
	@Test
	public void test1() {
		
	}

}
