package com.woniu.home;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		//1.键盘输入姓名、年龄录入学生对象中，3组
		Scanner sc = new Scanner(System.in);
		Student []stus = new Student[3];
		for(int i=0;i<stus.length;i++) {
			Student stu = new Student();
			System.out.println("请输入第"+(i+1)+"学生姓名：");
			String name = sc.next();
			stu.setName(name);
			System.out.println("请输入第"+(i+1)+"学生年龄：");
			int age = sc.nextInt();
			stu.setAge(age);
			stus[i] = stu;
		}
		System.out.println(Arrays.toString(stus));
		System.out.println(stus[0].getName());
		System.out.println(stus[1].getName());
		System.out.println(stus[2].getName());
		sc.close();
	}

}
