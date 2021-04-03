package com.woniu.chapter07_array;

import java.util.Scanner;

public class StringDemo08_4jiaDianZuiXiaoZhi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入4家店的价格");
		int[] price = new int[4];
		for (int i = 0; i < 4; i++) {
			System.out.print("第" + (i + 1) + "家店的价格：");
			price[i] = sc.nextInt();
		}
		// 获取最小值
		int min = price[0];
		for (int i = 1; i < price.length; i++) {
			if (price[i] < min) {
				min = price[i];
			}
		}
		System.out.println("最低价格是：" + min);
		sc.close();
	}

}
