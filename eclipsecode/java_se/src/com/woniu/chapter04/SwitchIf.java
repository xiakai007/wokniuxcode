package com.woniu.chapter04;

import java.util.Scanner;

public class SwitchIf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入消费金额：");
		double money = sc.nextDouble();
		System.out.println("是否参加优惠换购活动：");
		System.out.println("1.满50元，加2元换购百事可乐饮料1瓶");
		System.out.println("2.满100元，加3元换购500ml可乐一瓶");
		System.out.println("3.满100元，加10元换购5公斤面粉");
		System.out.println("4.满200元，加10元换购1个苏泊尔炒菜锅");
		System.out.println("5.满200元，加20元换购欧莱雅爽肤水一瓶");
		System.out.println("0.不换购");
		System.out.print("请选择：");
		if (sc.hasNextInt()) {
			int choose = sc.nextInt();
			double sumMoney;
			switch (choose) {
			case 1:
				if (money >= 50 && money < 100) {
					int addMoney = 2;
					sumMoney = money + addMoney;
					System.out.println("本次消费总金额：" + sumMoney);
					System.out.println("成功换购：1瓶百事可乐饮料。");
				}
				break;
			case 2:
				if (money >= 50 && money < 100) {
					int addMoney = 3;
					sumMoney = money + addMoney;
					System.out.println("本次消费总金额：" + sumMoney);
					System.out.println("成功换购：1瓶500ml可乐。");
				}
				break;
			case 3:
				if (money >= 100 && money < 200) {
					int addMoney = 10;
					sumMoney = money + addMoney;
					System.out.println("本次消费总金额：" + sumMoney);
					System.out.println("成功换购：5公斤面粉。");
				}
				break;
			case 4:
				if (money >= 200) {
					int addMoney = 10;
					sumMoney = money + addMoney;
					System.out.println("本次消费总金额：" + sumMoney);
					System.out.println("成功换购：1个苏泊尔炒菜锅。");
				}
				break;
			case 5:
				if (money >= 200) {
					int addMoney = 20;
					sumMoney = money + addMoney;
					System.out.println("本次消费总金额：" + sumMoney);
					System.out.println("成功换购：一瓶欧莱雅爽肤水。");
				}
				break;
			case 0:
				System.out.println("不换购");
				break;
			default:
				System.out.println("没有该选项！");
			}
		} else {
			System.out.println("选择错误！");
		}

		sc.close();
	}
}
