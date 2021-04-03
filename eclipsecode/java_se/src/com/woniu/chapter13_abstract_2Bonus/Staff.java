package com.woniu.chapter13_abstract_2Bonus;

public class Staff extends Employee {
	public Staff() {
	}
	public Staff(String empName, int jobNum, double salary) {
		this.setEmpName(empName);
		this.setJobNum(jobNum);
		this.setSalary(salary);
	}

	@Override
	public void bonus() {
		double bonusM = this.getSalary()*1.5;
		System.out.println("员工"+this.getEmpName()+"的工号是："+this.getJobNum()+",工资是："+this.getSalary()+"元，奖金是："+bonusM+"元。");
		
	}

}
