package com.woniu.chapter08_02twoDimensionArray;

public class StringDemo04_Sum {
	public static void main(String[] args) {
		int[][] num = new int[][] { { 3, 5, 8, 4 }, { 9, 1, 13, 24 }, { 17, 6, 2, 14 } };
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				sum += num[i][j];
			}
		}
		System.out.println("所有元素之和为：" + sum);
	}

}
