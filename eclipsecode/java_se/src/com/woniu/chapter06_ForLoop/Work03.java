package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

public class Work03 {
	public static void main(String[] args) {
		String userName = "abc";
		String passWord = "123321";
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0;i<3;i++) {
		System.out.print("请输入用户名：");
		String uName = sc.next();
		System.out.print("请输入密码：");
		String pWord = sc.next();		
		if((uName.equals(userName))&&(pWord.equals(passWord))) {
			System.out.println("欢迎登陆MyShopping系统！");
		}else {
			System.out.println("输入错误！您还有"+(2-i)+"次机会！");
			continue;
		}
		}
		System.out.println("\n对不起，您3次机会均输入错误！");
		sc.close();
	}

}
