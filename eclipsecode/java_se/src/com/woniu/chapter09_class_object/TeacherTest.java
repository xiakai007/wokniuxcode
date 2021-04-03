package com.woniu.chapter09_class_object;

public class TeacherTest {
	public static void main(String[] args) {
		Teacher tch = new Teacher();
		//属性赋值
		tch.name = "王老师";
		tch.specialty = "计算机";
		tch.course = "使用Java语言理解程序逻辑";
		tch.teachAge = 5;
		//调用方法
		tch.show();
		
	}

}
