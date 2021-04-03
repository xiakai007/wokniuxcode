package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo04_zhiJiaoSanJiaoXingP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入直角三角形的行数：");
		int row = sc.nextInt();
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<2*i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

}
