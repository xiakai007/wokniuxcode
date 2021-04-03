package com.woniu.chapter02;

import java.util.Scanner;

public class Practice02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入4位数的会员卡号：");
		int score = sc.nextInt();
		//获取个位、十位、百位、千位数字
		int ge = score % 10;
		int shi = score / 10 % 10;
		int bai = score / 100 % 10;
		int qian = score / 1000;
		//获取个位、十位、百位、千位数字相加的和
		int sum = ge + shi + bai + qian;
		boolean flag = sum > 20;
		System.out.println("会员卡号" + score + "各位之和：" + sum);
		System.out.println("是幸运客户吗？" + flag);
		sc.close();
	}

}
