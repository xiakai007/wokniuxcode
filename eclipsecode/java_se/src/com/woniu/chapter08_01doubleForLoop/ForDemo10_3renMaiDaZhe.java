package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo10_3renMaiDaZhe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			int count = 0;
			System.out.println("请输入第" + (i + 1) + "个人所购的三件商品的价格：");
			for (int j = 0; j < 3; j++) {
				double price = sc.nextDouble();
				if (price < 300) {
					continue;
				}
				count++;

//				if (price >= 300) {
//					count++;
//				} 
			}
			System.out.println("第" + (i + 1) + "个人共有" + count + "件商品享受8折优惠！" + "\n");
		}
		sc.close();
	}

}
