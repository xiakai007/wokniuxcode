package com.woniu.chapter02;

import java.util.Scanner;

public class Work5 {
	public static void main(String[] args) {
		int tshirtP = 245;
		int tshirtN = 2;
		int shoeP = 570;
		int shoeN = 1;
		int racketP = 320;
		int racketN = 1;
		float discount = 0.8f;
		float finalPay = (tshirtP * tshirtN + shoeP * shoeN + racketP * racketN) * discount;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入顾客实际交费：");
		int money = sc.nextInt();
		int bonousPoints = (int) ((finalPay / 100) * 3);
		System.out.println("************消费单************");
		System.out.println("购买物品" + "\t" + "单价" + "\t" + "个数" + "\t" + "金额");
		System.out.println("T恤" + "\t" + "¥" + tshirtP + "\t" + tshirtN + "\t" + "¥" + tshirtP * tshirtN);
		System.out.println("网球鞋" + "\t" + "¥" + shoeP + "\t" + shoeN + "\t" + "¥" + shoeP * shoeN);
		System.out.println("网球拍" + "\t" + "¥" + racketP + "\t" + racketN + "\t" + "¥" + racketP * racketN);
		System.out.println("\n\n折扣：" + "\t" + (int) (discount * 10) + "折");
		System.out.println("消费总金额" + "\t" + finalPay);
		System.out.println("实际交费" + "\t" + money);
		if (money > finalPay) {
			float returnMoney = money - finalPay;
			System.out.println("找钱" + "\t" + returnMoney);
		} else {
			System.out.println("对不起，你很穷，买不起");
		}
		System.out.println("本次购物所获的积分是：" + bonousPoints);
		sc.close();
	}

}
