package com.woniu.chapter05.hwork;

import java.util.Scanner;

public class GoodsInfo {
	public static void main(String[] args) {
		//商品信息
		String tshirtN = "T恤";
		String shoeN = "网球鞋";
		String racketN = "网球拍";
		double tshirtP = 245.8;
		double shoeP = 570.7;
		double racketP = 320.9;
		System.out.println("MyShopping管理系统>购物结算");
		System.out.println("\n************");
		System.out.println("选择购买的商品编号：");
		System.out.println("1."+tshirtN+"\t2."+shoeN+"\t3."+racketN);
		System.out.println("**************");
		
		Scanner sc = new Scanner(System.in);
		String answer = "y";
		while(!answer.equals("n")) {
			if(!answer.equals("y")&&!answer.equals("y")) {
				System.out.println("错误，只能输入y/n，请重新输入：");
				answer = sc.next();
			}else {
				System.out.print("请输入商品编号：");
				if(sc.hasNextInt()) {
				int num = sc.nextInt();
				switch(num) {
				case 1:
					System.out.println(tshirtN+"\t¥"+tshirtP);
					break;
				case 2:
					System.out.println(shoeN+"\t¥"+shoeP);
					break;
				case 3:
					System.out.println(racketN+"\t¥"+racketP);
					break;
					default:
						System.out.println("输入错误！--1");
						break;
				}
				}else {
					System.out.println("输入错误！--2");
				}
				System.out.print("\n\n是否继续（y/n）：");
				answer = sc.next();
			}
			
		}
		System.out.println("\n程序结束！");
		sc.close();
	}

}
