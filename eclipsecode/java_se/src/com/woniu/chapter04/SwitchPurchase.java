package com.woniu.chapter04;

import java.util.Scanner;

public class SwitchPurchase {
	public static void main(String[] args) {
		System.out.println("\n\n\t\t欢迎使用我行我素购物管理系统");
		System.out.println("\n\n\t\t\t1.登录系统");
		System.out.println("\n\n\t\t\t2.退出");
		System.out.println("\n\n* * * * * * * * * * * * * * * * * * * * * * * * *");
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\n请选择，输入数字：");
		//判断是否是整数
		if(sc.hasNextInt()) {
			int num = sc.nextInt();
		switch(num) {
		case 1:
			System.out.println("1.客户信息管理");
			System.out.println("2.购物结算");
			System.out.println("3.真情回赠");
			System.out.println("4.注销");
			System.out.print("请继续选择，输入数字：");
			if(sc.hasNextInt()) {
			int num2 = sc.nextInt();
			switch(num2) {
			case 1:
				System.out.println("购物管理系统>客户信息管理");
				System.out.println("1.显示所有客户信息");
				System.out.println("2.添加客户信息");
				System.out.println("3.修改客户信息");
				System.out.println("4.查询客户信息");
				break;
			case 2:
				System.out.println("正在进行购物结算");
				break;
			case 3:
				System.out.println("购物管理系统>真情回赠");
				System.out.println("1.幸运大放送");
				System.out.println("2.幸运抽奖");
				System.out.println("3.生日问候");
				break;
			case 4:
				System.out.println("正在注销");
				break;
			default:
				System.out.println("输入错误！");
			}
		    }else {
				System.out.println("请输入正确的数字！");
			}
			break;
		case 2:
			System.out.println("谢谢您的使用");
			break;
		default:
			System.out.println("输入错误！");
		}
		}else {
			System.out.println("请输入正确的数字！");
		}
		sc.close();
	}

}
