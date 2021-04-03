package com.woniu.chapter09_class_object_work;

import java.util.Scanner;

public class ChangeAdminTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChangeAdmin cadm = new ChangeAdmin();

		System.out.print("请输入用户名：");
		cadm.name = sc.next();
		System.out.print("请输入密码：");
		cadm.passWord = sc.next();
		cadm.show();
		sc.close();
	}

}
