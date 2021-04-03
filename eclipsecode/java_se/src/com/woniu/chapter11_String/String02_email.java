package com.woniu.chapter11_String;

import java.util.Scanner;

public class String02_email {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---欢迎进入作业提交系统---");
		System.out.print("请输入Java文件名：");
		String name = sc.next();
		//获取指定字符的索引
		int ind = name.indexOf(".");
//		int ind2 = email.indexOf("@");
		if(ind<=0) {
			System.out.println("Java文件名错误！");
		}else if(name.substring(ind+1).equals("java")){//获取指定索引之后的字符串
			System.out.print("请输入您的邮箱：");
			String email = sc.next();
			if(email.contains("@")&&email.contains(".")&&email.indexOf(".")-email.indexOf("@")>1) {
				System.out.println("作业提交成功");
			}else {
				System.out.println("E-mail无效。\n作业提交失败！");
			}
		}else {
			System.out.println("Java文件名错误！");
		}
		sc.close();
	}
}
