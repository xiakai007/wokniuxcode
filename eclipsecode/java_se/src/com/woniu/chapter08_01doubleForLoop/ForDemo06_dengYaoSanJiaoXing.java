package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo06_dengYaoSanJiaoXing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入等腰三角形的行数：");
		int row = sc.nextInt();// 行数
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < row - i - 1; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
