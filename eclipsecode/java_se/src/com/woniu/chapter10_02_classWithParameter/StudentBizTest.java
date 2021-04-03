package com.woniu.chapter10_02_classWithParameter;

import java.util.Scanner;

public class StudentBizTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentBiz stub = new StudentBiz();
		for (int i = 0; i < 5; i++) {
			System.out.print("请输入第" + (i + 1) + "位学生的姓名：");
			String name = sc.next();
			stub.addName(name);
		}
		stub.showNames();

		System.out.print("\n请输入要修改的学生姓名：");
		String oldName = sc.next();
		System.out.print("请输入新的学生姓名：");
		String newName = sc.next();
		if (stub.editName(oldName, newName)) {
			System.out.println("******修改结果******");
			System.out.println("找到并修改成功！");
			stub.showNames();
		}else {
			System.out.println("******修改结果******");
			System.out.println("没有找到要修改的学生。");
		}

		System.out.print("\n请输入开始查找的位置：");
		int start = sc.nextInt();
		System.out.print("请输入结束查找的位置：");
		int end = sc.nextInt();
		System.out.print("请输入要查找的姓名：");
		String name = sc.next();
		System.out.println("******查找结果******");
		if (stub.searchName(start, end, name)) {
			System.out.println("找到了!");
		} else {
			System.out.println("没有找到该学生！");
		}
		sc.close();
	}

}
