package com.woniu.chapter10_01_classWithNoParameter;

import java.util.Scanner;

/**
 * 菜单类
 * 
 * @author xiakai
 *
 */
public class Menu {
	Scanner sc = new Scanner(System.in);

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
			main();
			break;
		case 2:
			System.out.println("执行退出");
			break;
		default:
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

}
