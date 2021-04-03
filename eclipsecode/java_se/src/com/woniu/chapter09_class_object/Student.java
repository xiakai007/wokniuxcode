package com.woniu.chapter09_class_object;

public class Student {
	String name;//学生姓名
	int age;//学生年龄
	String claN;//就读班级
	String hobby;//爱好
	//输出学生信息
	public void show() {
		System.out.println(name+"\n年龄："+age+"\n就读于："+claN+"班\n爱好："+hobby);
	}

}
