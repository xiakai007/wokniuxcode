package com.woniu.chapter07_array;

import java.util.Scanner;

public class StringDemo04_5BiJinE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] money = new double[5];
		System.out.println("请输入会员本月的消费记录");
		for (int i = 0; i < money.length; i++) {
			System.out.print("请输入第" + (i + 1) + "笔购物金额：");
			money[i] = sc.nextDouble();
		}
		System.out.println("\n序号\t\t" + "金额（元）");
		double sum = 0;
		for (int j = 0; j < money.length; j++) {
			System.out.println((j + 1) + "\t\t" + money[j]);
			sum += money[j];
		}
		System.out.println("总金额" + "\t\t" + sum);
		sc.close();
	}

}
