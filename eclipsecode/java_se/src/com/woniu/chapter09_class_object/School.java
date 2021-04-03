package com.woniu.chapter09_class_object;

public class School {
	String schName;//学校名称
	int stuNum;//学生数量
	int claNum;//教室数量
	//输出学校信息
	public void show() {
		System.out.println(schName+"有"+claNum+"间教室,"+stuNum+"名学生。");
	}

}
