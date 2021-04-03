package com.woniu.chapter09_class_object;

public class StudentTest {
	public static void main(String[] args) {
		Student stu = new Student();
		//属性赋值
		stu.name = "张浩";
		stu.age = 10;
		stu.claN = "S1";
		stu.hobby = "篮球";
		//调用方法
		stu.show();
	}

}
