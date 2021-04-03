package com.woniu.home4;

public class Customer {
	private int age;
	String name;
	protected int eno;
	public void setAge(int age) { //setAge用来给对象赋值
		if(age<=0) {
			System.out.println("年龄格式不正确！");
		}else {
//			System.out.println(this);
			this.age = age;
		}
	}
	public int getAge() { //getAge用来获取对象属性
		return age;
	}

}
