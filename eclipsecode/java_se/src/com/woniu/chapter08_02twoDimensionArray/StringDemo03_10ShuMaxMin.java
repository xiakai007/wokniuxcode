package com.woniu.chapter08_02twoDimensionArray;

import java.util.Arrays;

public class StringDemo03_10ShuMaxMin {
	public static void main(String[] args) {
		int[] num = new int[10];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 90 + 10);
		}
		System.out.println(Arrays.toString(num));
		int max = num[0];
		int min = num[0];
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
			if (num[i] < min) {
				min = num[i];
			}
			sum += num[i];
			avg = sum*1.0 / num.length;
		}
		System.out.println("最大值：" + max);
		System.out.println("最小值：" + min);
		System.out.println("总和：" + sum);
		System.out.println("平均值：" + avg);
	}

}
