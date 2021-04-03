package com.woniu.chapter03;

import java.util.Scanner;

public class Work01 {
	public static void main(String[] args) {
		System.out.println("我行我素购物管理系统 >幸运抽奖" + "\n\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入4位数字会员号：");
		int num = sc.nextInt();
		int bai = num / 100 % 10;
		System.out.println("会员号的百位数是："+bai);
		int random = (int) (Math.random() * 10);
		System.out.println("随机数字是："+random);
		if (bai == random) {
			System.out.println(num + "号客户是幸运客户，获精美iPhone一台");
		} else {
			System.out.println(num + "号客户，谢谢您的支持！");
		}
		sc.close();
	}

}
