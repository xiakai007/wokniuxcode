package com.woniu.chapter08_02twoDimensionArray;

import java.util.Arrays;
import java.util.Scanner;

public class Work01_ZuiDaZhi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入行数：");
		int row = sc.nextInt();
		int[][] num = new int[row][row];
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				System.out.println("请输入第" + (i + 1) + "行第" + (j + 1) + "列的数：");
				num[i][j] = sc.nextInt();
			}
		}
		int[] max = new int[row];
		for (int i = 0; i < row; i++) {
			max[i] = num[i][0];
			for (int j = 1; j < num[i].length; j++) {
				if (num[i][j] > max[i]) {
					max[i] = num[i][j];
				}
			}
		}
		System.out.println("最大值组成的数组为" + Arrays.toString(max));
		sc.close();
	}

}
