package com.woniu.chapter11_String;

import java.util.Scanner;

public class RegisterTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***欢迎进入注册系统***\n");
		Register rgs = new Register();
		boolean flag = true;
		do {
			System.out.print("请输入用户名：");
			String name = sc.next();
			System.out.print("请输入密码：");
			String pwd1 = sc.next();
			System.out.print("请再次输入密码：");
			String pwd2 = sc.next();
			 flag = rgs.verify(name, pwd1, pwd2);
		}while(flag);
		sc.close();
		
	}

}
