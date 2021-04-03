package com.woniu.chapter11_String;

import java.util.Scanner;

public class String04_number {
	public static void main(String[] args) {
		System.out.println("***欢迎进入注册登录系统");
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		while (flag) {
			System.out.print("请输入身份证号：");
			String idN = sc.next();
			System.out.print("请输入手机号：");
			String phN = sc.next();
			System.out.print("请输入座机号：");
			String landN = sc.next();
			if (idN.length() == 16 || idN.length() == 18) {
				if (phN.length() == 11) {
					if (landN.split("-")[0].length() == 4 && landN.split("-")[1].length() == 7) {
						System.out.println("注册成功！");
						flag = false;
					} else {
						System.out.println("座机号码必须是4位，电话号码必须是7位");
					}
				} else {
					System.out.println("手机号码必须是11位！");
				}
			} else {
				System.out.println("身份证号必须是16位或18位！");
			}
		}
		sc.close();

	}

}
