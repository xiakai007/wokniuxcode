package com.woniu.chapter17_outer_inner_lambda;

public class StuTest {
	public static void main(String[] args) {
		Student stu1 = new Student("小明","男", 20, 1001);
		Student stu2 = new Student("小明","女", 18,1001);
		stu1.show();
		stu2.show();
		if(stu1.equals(stu2)) {
			System.out.println("是同一个学生");
		}else {
			System.out.println("是两个学生");
		}
	}
}
