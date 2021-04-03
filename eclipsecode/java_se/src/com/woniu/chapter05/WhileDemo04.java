package com.woniu.chapter05;

import java.util.Scanner;

public class WhileDemo04 {
	public static void main(String[] args) {
//		String goods1 = "T恤";
//		String goods2 = "网球鞋";
//		String goods3 = "网球拍";
		double tshirtP = 245.8;
		double shoeP = 570.7;
		double racketP = 320.9;
		System.out.println("MyShopping管理系统>购物结算");
		System.out.println("\n************");
		System.out.println("选择购买的商品编号：");
//		System.out.println("1.T恤\t2.网球鞋\t3.网球拍");
		System.out.println("1.T恤\t2.网球鞋\t3.网球拍");
		System.out.println("**************");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入商品编号：");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			System.out.println("T恤"+"\t"+"¥"+tshirtP);
			break;
		case 2:
			System.out.println("网球鞋"+"\t"+"¥"+shoeP);
			break;
		case 3:
			System.out.println("网球拍"+"\t"+"¥"+racketP);
			break;
			default:
				System.out.println("选择错误！");
		}
		
		System.out.print("\n是否继续（y/n）");
		String answer = sc.next();
		while("y".equals(answer)) {
			System.out.print("请输入商品编号：");
			int num2 = sc.nextInt();
			switch(num2) {
			case 1:
				System.out.println("T恤"+"\t¥"+tshirtP);
				break;
			case 2:
				System.out.println("网球鞋"+"\t¥"+shoeP);
				break;
			case 3:
				System.out.println("网球拍"+"\t¥"+racketP);
				break;
				default:
					System.out.println("选择错误！");
			}
			System.out.print("\n是否继续（y/n）");
			answer = sc.next();
		}
		System.out.println("程序结束!");
		sc.close();
	}

}
