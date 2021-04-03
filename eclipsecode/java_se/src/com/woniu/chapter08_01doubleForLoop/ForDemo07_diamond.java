package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo07_diamond {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入菱形的半行数：");
		int row = sc.nextInt();
		for (int i = -row; i <= row; i++) {
			// 空心菱形
			for (int j = -row; j <= row; j++) {
				if (Math.abs(i) + Math.abs(j) == row) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
//			 //实心菱形
//			for (int j = -row; j <= row; j++) {
//				if (Math.abs(i) + Math.abs(j) <= row) {
//					System.out.print("*");
//				} else {
//					System.out.print(" ");
//				}
//			}
			System.out.println();
		}
		sc.close();
	}

}
