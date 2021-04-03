package com.woniu.test;

public class StudentTest {
	public static void main(String[] args) {
		Student<String> stu=new Student<String>();
		stu.setName("tom");
		System.out.println(stu.getName());
		stu.setCode("001");
		System.out.println(stu.getCode());
	}

}
