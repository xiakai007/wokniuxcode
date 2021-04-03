package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

public class ForDemo0501_10GuKeNianLing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("请输入的第" + (i + 1) + "位顾客的年龄：");
			int age = sc.nextInt();
			if (age < 30) {
				continue;
			}
			count++;// 30岁以上的人数
		}
		System.out.println("30岁以下的比例是：" + ((10 - count) * 1.0 / 10) * 100 + "%");
		System.out.println("30岁以上的比例是：" + (count * 1.0 / 10) * 100 + "%");
		sc.close();
	}

}
