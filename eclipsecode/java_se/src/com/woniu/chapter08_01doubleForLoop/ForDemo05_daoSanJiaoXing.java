package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo05_daoSanJiaoXing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入直角倒三角形的行数：");
		int row = sc.nextInt();//行数
		for(int i=0;i<row;i++) {
			for(int j = 0;j<row-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
