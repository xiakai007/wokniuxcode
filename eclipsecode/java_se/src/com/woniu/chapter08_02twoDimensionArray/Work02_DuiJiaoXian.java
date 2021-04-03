package com.woniu.chapter08_02twoDimensionArray;

public class Work02_DuiJiaoXian {
	public static void main(String[] args) {
		int[][] num = new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				if (i == j) {
					sum1 += num[i][j];
				}
				if (i + j == num.length - 1) {
					sum2 += num[i][j];
				}
			}
		}
		System.out.println("对角线1的和：" + sum1 + "，对角线2的和：" + sum2);

		int sum3 = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				if ((i == j) || (i + j == num.length - 1)) {
					sum3 += num[i][j];
				}
			}
		}
		System.out.println("对角线的和：" + sum3);
	}

}
