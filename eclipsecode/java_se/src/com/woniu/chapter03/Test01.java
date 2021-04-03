package com.woniu.chapter03;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		String name = "青";
		String passWord = "123";
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name1 = sc.nextLine();
		System.out.println("请输入密码：");
		String passWord1 = sc.nextLine();
		if ((name1.equals(name)) && (passWord1.equals(passWord))) {
			System.out.println("欢迎你，青");
		} else {
			System.out.println("对不起，你不是青");
		}
		sc.close();
	}

}
