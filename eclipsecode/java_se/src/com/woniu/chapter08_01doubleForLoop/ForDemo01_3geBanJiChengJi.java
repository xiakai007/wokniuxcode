package com.woniu.chapter08_01doubleForLoop;

import java.util.Scanner;

public class ForDemo01_3geBanJiChengJi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] className = new int[3];
		double[] score = new double[4];
		for (int i = 0; i < className.length; i++) {
			double sum = 0;
			double avg = 0;
			System.out.println("请输入第" + (i + 1) + "个班级的成绩：");
			for (int j = 0; j < score.length; j++) {
				System.out.print("第" + (j + 1) + "个学员的成绩：");
				score[j] = sc.nextInt();
				sum += score[j];
			}
			avg = sum / score.length;
			System.out.println("请输入第" + (i + 1) + "个班级的平均分是：" + avg + "\n");
		}
		sc.close();
	}

}
