package com.woniu.chapter10_01_classWithNoParameter;

import java.util.Scanner;

/**
 * 密码验证登录类
 * 
 * @author xiakai
 *
 */
public class StartSMS {
	Scanner sc = new Scanner(System.in);
	String name;
	String passWord;

	/**
	 * 登录菜单
	 */
	public void login() {
		System.out.println("\n\t欢迎使用我行我素购物管理系统");
		System.out.println("\n\t\t1.登录系统");
		System.out.println("\n\t\t2.退出");
		System.out.println("\n************************************");
		System.out.print("请选择，输入数字：");
		int num = sc.nextInt();
		switch (num) {
			case 1:
				System.out.print("请输入用户名：");
				name = sc.next();
				System.out.print("请输入密码：");
				passWord = sc.next();
				check();
				break;
			default:
				System.out.println("执行退出");
				break;
	}
	}

	/**
	 * 主菜单
	 */
	public void main() {
		System.out.println("\n\t我行我素购物管理系统主菜单");
		System.out.println("\n************************************");
		System.out.println("\n\t\t1.客户信息管理");
		System.out.println("\n\t\t2.真情回馈");
		System.out.println("\n************************************");
		System.out.print("请选择，输入数字或按0返回上一级菜单：");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			cust();
			break;
		case 2:
			send();
			break;
		case 0:
			login();
			break;
		default:
			break;
		}

	}

	/**
	 * 真情回馈
	 */
	public void send() {
		System.out.println("\n\t我行我素购物管理系统>真情回馈");
		System.out.println("\n************************************");
		System.out.println("\n\t\t1.幸运大放送");
		System.out.println("\n\t\t2.幸运抽奖");
		System.out.println("\n\t\t3.生日问候");
		System.out.println("\n************************************");
		System.out.print("请选择，输入数字或按0返回上一级菜单：");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("执行幸运大放送");
			break;
		case 2:
			System.out.println("执行幸运抽奖");
			break;
		case 3:
			System.out.println("执行生日问候");
			break;
		case 0:
			main();
			break;
		default:
			break;
		}
	}

	/**
	 * 客户信息菜单
	 */
	public void cust() {
		System.out.println("\n\t我行我素购物管理系统>客户信息管理");
		System.out.println("\n************************************");
		System.out.println("\n\t\t1.添加客户");
		System.out.println("\n\t\t2.删除客户");
		System.out.println("\n\t\t3.创建订单");
		System.out.println("\n************************************");
		System.out.print("请选择，输入数字或按0返回上一级菜单：");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("执行添加客户");
			break;
		case 2:
			System.out.println("执行删除客户");
			break;
		case 3:
			System.out.println("执行创建订单");
			break;
		case 0:
			main();
			break;
		default:
			break;
		}

	}

	/**
	 * 用户名和密码验证
	 */
	public void check() {
		if ((name.equals("JadeBird")) && (passWord.equals("0000"))) {
			System.out.println("@@登录成功：" + name + "@@");
			main();
		} else {
			System.out.println("@@您没有权限进入系统，请重新登录。@@");
			login();
		}

	}
}
