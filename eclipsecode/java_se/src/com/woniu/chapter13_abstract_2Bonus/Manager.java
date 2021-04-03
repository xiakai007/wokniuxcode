package com.woniu.chapter13_abstract_2Bonus;

public class Manager extends Employee{
	public Manager() {
		
	}
    public Manager(String empName, int jobNum, double salary) {
    	this.setEmpName(empName);
  		this.setJobNum(jobNum);
  		this.setSalary(salary);
	}

	@Override
	public void bonus() {
		double bonusM = this.getSalary()*2;
		System.out.println("经理"+this.getEmpName()+"的工号是："+this.getJobNum()+",工资是："+this.getSalary()+"元，奖金是："+bonusM+"元。");
		
	}
	

}
