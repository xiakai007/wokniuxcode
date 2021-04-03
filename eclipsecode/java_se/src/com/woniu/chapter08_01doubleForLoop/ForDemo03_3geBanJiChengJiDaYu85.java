package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo03_3geBanJiChengJiDaYu85 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] className = new int[3];
		double[] score = new double[4];
		int count = 0;
		for (int i = 0; i < className.length; i++) {
			double sum = 0;
			double avg = 0;
			System.out.println("请输入第" + (i + 1) + "个班级的成绩：");
			for (int j = 0; j < score.length; j++) {
				System.out.print("第" + (j + 1) + "个学员的成绩：");
				score[j] = sc.nextInt();
				sum += score[j];
				if (score[j] < 85) {
					continue;
				}
				count++;
			}
			avg = sum / 4;
			System.out.println("请输入第" + (i + 1) + "个班级的平均分是：" + avg + "\n");
		}
		System.out.println("成绩85分以上的学员人数共有" + count + "人");
		sc.close();
	}

}
