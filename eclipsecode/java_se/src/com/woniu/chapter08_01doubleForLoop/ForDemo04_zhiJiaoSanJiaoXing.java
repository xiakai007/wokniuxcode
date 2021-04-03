package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo04_zhiJiaoSanJiaoXing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入直角三角形的行数：");
		int row = sc.nextInt();// 行数
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
