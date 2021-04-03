package com.woniu.chapter03;

import java.util.Scanner;

public class Work02 {
	public static void main(String[] args) {
		System.out.println("我行我素购物管理系统 >客户信息管理 >添加客户信息" + "\n\n");
		System.out.print("请输入会员号（<4位整数>）：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if ((num >= 1000) && (num <= 9999)) {
			System.out.print("请输入会员生日（月/日<用两位数表示>）：");
			String birthday = sc.next();
			System.out.print("请输入积分：");
			int score = sc.nextInt();
			System.out.println("\n\n" + "已录入的会员信息是：");
			System.out.println(num + "\t" + birthday + "\t" + score);
		} else {
			System.out.println("会员信息不存在！");
		}
		sc.close();
	}

}
