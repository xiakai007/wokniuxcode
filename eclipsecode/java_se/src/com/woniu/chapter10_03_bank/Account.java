package com.woniu.chapter10_03_bank;

import java.util.Scanner;

/**
 * 银行账户查询存取款类
 * 
 * @author xiakai
 *
 */
public class Account {
	// 银行存款
	double savings = 0;
	//银行账户的方法
	public void bank() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n*****当前余额为" + savings + "元*****");

		boolean flag = true;
		while (flag) {
			System.out.println("\n1.存款\t2.取款\t0.退出");
			System.out.print("请选择你需要办理的业务：");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("请输入存款金额：");
				double addMoney = sc.nextDouble();
				System.out.println("存款成功");
				System.out.println("\n*****当前余额为" + deposit(addMoney) + "元*****");
				break;
			case 2:
				System.out.print("请输入取款金额：");
				double subMoney = sc.nextDouble();
				withdraw(subMoney);
				break;
			case 0:
				flag = false;
				System.out.println("谢谢使用！");
				break;
			default:
				System.out.println("选择错误，请重新选择：");
				break;
			}
		}
		sc.close();
	}

	/**
	 * 存款业务
	 * 
	 * @param money
	 * @return 当前余额savings
	 */
	public double deposit(double money) {
		savings += money;
		return savings;
	}

	/**
	 * 取款业务
	 * 
	 * @param money
	 */
	public void withdraw(double money) {
		if (savings >= money) {
			System.out.println("取款成功");
			savings -= money;
			System.out.println("\n*****当前余额为" + savings + "元*****");
		} else {
			System.out.println("余额不总，请重新输入：");
		}

	}

}
