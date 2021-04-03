package com.woniu.chapter05.hwork;

import java.util.Scanner;

public class GoodsInfo02 {
	public static void main(String[] args) {
		// 商品信息
		String tshirtN = "T恤";
		String shoeN = "网球鞋";
		String racketN = "网球拍";
		double tshirtP = 245.8;
		double shoeP = 570.7;
		double racketP = 320.9;
		double discount = 0.8;// 折扣
		double totalPrice = 0.0;// 总价格
		double payable = 0.0;// 应付价格

		System.out.println("MyShopping管理系统>购物结算");
		System.out.println("\n************");
		System.out.println("选择购买的商品编号：");
		System.out.println("1." + tshirtN + "\t2." + shoeN + "\t3." + racketN);
		System.out.println("**************");

		Scanner sc = new Scanner(System.in);
		String answer = "y";
		while (!answer.equals("n")) {
			if (!answer.equals("y") && !answer.equals("y")) {
				System.out.println("错误，只能输入y/n，请重新输入：");
				answer = sc.next();
			} else {
				System.out.print("请输入商品编号：");
				if (sc.hasNextInt()) {
					int num = sc.nextInt();// 获取商品编号
					System.out.println("请输入购买数量：");
					int count = sc.nextInt();// 获取商品数量
					double goodsP = 0.0;
					switch (num) {
					case 1:
						goodsP = tshirtP * count;
						System.out.println(tshirtN + "¥" + tshirtP + "\t数量" + count + "\t¥" + goodsP);
						break;
					case 2:
						goodsP = shoeP * count;
						System.out.println(shoeN + "\t¥" + shoeP + "\t数量" + count + "\t¥" + goodsP);
						break;
					case 3:
						goodsP = racketP * count;
						System.out.println(racketN + "\t¥" + racketP + "\t数量" + count + "\t¥" + goodsP);
						break;
					default:
						System.out.println("输入错误！--1");
						break;
					}
					totalPrice += goodsP;
				}else {
					System.out.println("输入错误！--2");
				}
				System.out.print("\n\n是否继续（y/n）：");
				answer = sc.next();
			}

		}
		System.out.println("\n\n折扣" + discount);
		System.out.println("实际金额总价格：" + totalPrice);
		payable = totalPrice * discount;
		System.out.println("应付价格：" + payable);
		System.out.println("实付金额:");
		double pay = sc.nextInt();
		while (payable > pay) {
			System.out.println("您支付的金额不足，请重新支付：");
			pay = sc.nextInt();
		}
		double smChg = pay - payable;
		System.out.println("找零：" + smChg);
		sc.close();
	}

}