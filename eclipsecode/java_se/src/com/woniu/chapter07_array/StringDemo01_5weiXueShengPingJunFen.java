package com.woniu.chapter07_array;

import java.util.Scanner;

public class StringDemo01_5weiXueShengPingJunFen {
	public static void main(String[] args) {
		double []scores = new double[5];
		Scanner sc = new Scanner(System.in);
		for(int i =0;i<scores.length;i++) {
			System.out.println("请输入第"+(i+1)+"位学生的成绩：");
			scores[i] = sc.nextDouble();
		}
		double sum = 0;
		for(int i = 0;i<scores.length;i++) {
			sum += scores[i];
		}
		double avg = sum/scores.length;
		System.out.println("5位学生的平均分为"+avg+"分。");
		sc.close();
	}
}
