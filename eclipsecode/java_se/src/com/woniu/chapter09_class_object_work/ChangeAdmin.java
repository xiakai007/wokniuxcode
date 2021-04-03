package com.woniu.chapter09_class_object_work;

import java.util.Scanner;

public class ChangeAdmin {
	String name;
	String passWord;
	Scanner sc = new Scanner(System.in);

	public void show() {
		if (name.equals("admin1") && passWord.equals("111111")) {
			System.out.print("\n请输入新密码：");
			passWord = sc.next();
			System.out.println("修改密码成功，您的新密码为：" + passWord);
		} else {
			System.out.println("用户名和密码不匹配！您没有权限更新管理员信息");
		}
	}
}
