package com.woniu.chapter05;

import java.util.Scanner;

public class WhileDemo03 {
	public static void main(String[] args) {
		double tshirtP = 245.8;
		double shoeP = 570.6;
		double racketP = 320.9;
		double totalMoney = 0;// 初始合计金额
		double money = 0;
		double discount = 0.8;
		System.out.println("************");
		System.out.println("请选择购买的商品编号：");
		System.out.println("1.T恤\t2.网球鞋\t3.网球拍");
		System.out.println("**************");

		Scanner sc = new Scanner(System.in);
		System.out.print("请输入商品编号：");
		int choice = sc.nextInt();
		System.out.print("请输入购买数量：");
		int num = sc.nextInt();
		switch (choice) {
		case 1:
			money = tshirtP * num;
			System.out.println("T恤¥" + tshirtP + "\t" + "数量" + num + "\t" + "合计¥" + money);
			break;
		case 2:
			money = shoeP * num;
			System.out.println("网球鞋¥" + shoeP + "\t" + "数量" + num + "\t" + "合计¥" + money);
			break;
		case 3:
			money = racketP * num;
			System.out.println("网球拍¥" + racketP + "\t" + "数量" + num + "\t" + "合计¥" + money);
			break;
		default:
			System.out.println("选择错误！");
		}
		totalMoney = money;

		double moneyt = 0;
		System.out.print("是否继续（y/n）");
		String answer = sc.next();
		int i = 0;
		while ("y".equals(answer)) {
			System.out.print("请输入商品编号：");
			int choice1 = sc.nextInt();
			System.out.print("请输入购买数量：");
			int num1 = sc.nextInt();
			switch (choice1) {
			case 1:
				moneyt = tshirtP * num1;
				System.out.println("第" + (i + 2) + "次购物：" 
				+ "T恤¥" + tshirtP + "\t" + "数量" + num1 + "\t" + "合计¥" + moneyt);
				break;
			case 2:
				moneyt = shoeP * num1;
				System.out.println("第" + (i + 2) + "次购物：" 
				+ "网球鞋¥" + shoeP + "\t" + "数量" + num1 + "\t" + "合计¥" + moneyt);
				break;
			case 3:
				moneyt = racketP * num1;
				System.out.println("第" + (i + 2) + "次购物：" 
				+ "网球拍¥" + racketP + "\t" + "数量" + num1 + "\t" + "合计¥" + moneyt);
				break;
			default:
				System.out.println("选择错误！");
			}
			i++;
			totalMoney += moneyt;
			System.out.print("是否继续（y/n）");
			answer = sc.next();
		}

		System.out.println("\n合计金额：" + totalMoney);// 合计金额
		System.out.println("折扣：" + discount);
		double money1 = totalMoney * discount;// 应付合计金额
		System.out.println("应付合计金额：" + money1);
		System.out.print("实付合计金额：");
		double money2 = sc.nextDouble();// 获取实付合计金额
		double money3 = 0;// 初始找零
		while (money2 < money1) {
			System.out.println("您支付的金额不足，请重新支付：");
			money2 = sc.nextDouble();// 再次获取实付合计金额
		}
		money3 = money2 - money1;// 找零
		System.out.println("找零：" + money3);
		sc.close();
	}

}
