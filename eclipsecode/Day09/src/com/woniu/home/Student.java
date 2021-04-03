package com.woniu.home;

public class Student {
	private String name;
	private int age;
	public Student() {
		super();
		System.out.println("Student的无参构造方法执行了！");
	}
	public Student(String name) {  //有参构造方法注入属性
		super();
		this.name = name;
	}
	public Student(String name,int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}

}
