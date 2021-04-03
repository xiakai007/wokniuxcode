package com.woniu.chapter03;

import java.util.Scanner;

public class Work05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入是否是会员：是（y）/否（其他字符）");
		String isMember = sc.nextLine();
		System.out.println("请输入购物金额：");
		double  money = sc.nextDouble();
		double discount;
		//确定折扣
		if(isMember.equals("y")) {
			if(money >= 200) {
				discount = 0.75;
			}else {
				discount = 0.8;
			}
		}else {
			if(money >= 100) {
				 discount = 0.9;
			}else {
				discount = 1;
			}
		} 
		double payMoney = money * discount;
		System.out.println("实际支付："+payMoney);
		sc.close();
	}

}
