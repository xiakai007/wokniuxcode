package com.woniu.chapter07_array;

import java.util.Arrays;
import java.util.Scanner;

public class StringDemo06_5xueYuanShengXuPaiLie {
	public static void main(String[] args) {
		System.out.println("请输入5位学员的成绩：");
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[5];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();
		}
		//获取最大值
		int max = scores[0];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.println("最大值为：" + max);

		Arrays.sort(scores);
		System.out.print("学员成绩升序排列：");
		for (int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}
		sc.close();
	}

}
