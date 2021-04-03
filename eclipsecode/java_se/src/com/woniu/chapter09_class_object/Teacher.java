package com.woniu.chapter09_class_object;

public class Teacher {
	String name;//教师称呼
	String specialty;//专业方向
	String course;//教授课程
	int teachAge;//教龄
	//输出教师信息
	public void show() {
		System.out.println(name+"\n专业方向："+specialty+"\n教授课程："+course+"\n教龄："+teachAge);
	}

}
