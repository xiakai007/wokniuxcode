package com.woniu.demo;

public class Test {
	public static void main(String[] args) {
//		Employee emp = new Employee();
//		System.out.println(emp.eno);
		Teacher tch = new Teacher();
	    System.out.println(tch.eno);
	    tch.work();
	    tch.teaching();
	    Assistant ast = new Assistant();
	    ast.service();
	}

}
