package com.woniu.demo1;

import java.util.Date;

public class Consumer {
	//1.属性私有化
	private long id;
	private String name;
	private char gender;
	private int age;
	private Date birthday;
	private int cno;
	
	
	
	//2.构造方法
	public Consumer() {
		super();//父类构造方法，所有类的父类都是Object
		System.out.println("Consumer已执行");
	}
	public Consumer(int age) {
		super();
		this.age = age;
	}
	
	public Consumer(String name) {
		super();
		this.name = name;
	}
	public Consumer(String name,char gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	public Consumer(char gender,String name) {
		super();
		this.name = name;
		this.gender = gender;
	}
	//全参数构造方法
	public Consumer(long id,String name,char gender,int age,Date birthday,int cno) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.cno = cno;
	}
	
	//3.提供公共的访问方式
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGender(char gender) {
		if(gender =='男' ||gender =='女') {
			this.gender = gender;
		}else {
			System.out.println("您输入的性别有误");
		}
		
	}
	public char getGender() {
		return gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday(){
		return birthday;
	}
	//4.普通方法（测试重载）
	public void show() {
		System.out.println(1111);
	}
	public int show(int a) {
		return a;
	}
	public int show(int a,int b) {
		return a+b;
	}

}
