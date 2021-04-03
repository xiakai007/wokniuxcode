package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

//2.循环录入3位会员的信息
public class Work02 {
	public static void main(String[] args) {
		System.out.println("MyShopping管理系统>客户信息管理>添加客户信息");
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.print("\n请输入第" + (i + 1) + "个会员号（4位整数）：");
			int vipNum = sc.nextInt();
			if (vipNum < 1000 || vipNum > 9999) {
				System.out.println("会员号录入失败，请重新录入：");
				i--;
				continue;
			}
			System.out.print("请输入第" + (i + 1) + "个会员生日（月/日<用两位整数表示>）：");
			String vipBirD = sc.next();
			System.out.print("请输入第" + (i + 1) + "个会员积分：");
			int vipScore = sc.nextInt();
//			if (vipScore <0) {
//				System.out.println("会员积分录入失败，请重新录入：");
//				i--;
//				continue;
//			}
			System.out.println("您录入的第" + (i + 1) + "个会员信息是：");
			System.out.println(vipNum + "\t" + vipBirD + "\t" + vipScore);
		}
		System.out.println("程序结束");
		sc.close();
	}
}
