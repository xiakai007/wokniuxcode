package com.woniu.chapter11_String;

import java.util.Scanner;

public class String01_abc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入用户名:");
		String name = sc.next();
		System.out.print("请输入密码：");
		String passWord = sc.next();
		if(passWord.length()<6) {
			System.out.println("密码长度不能小于6位！");
			
		}else if(name.equalsIgnoreCase("Tom")&&passWord.equals("1234567")){
			System.out.println("注册成功！");
		}else {
			System.out.println("用户名密码错误");
		}
		sc.close();
	}
}
