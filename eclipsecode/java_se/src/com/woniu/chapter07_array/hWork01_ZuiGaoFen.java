package com.woniu.chapter07_array;

import java.util.Scanner;

public class hWork01_ZuiGaoFen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入学生人数：");
		int num = sc.nextInt();
		int []scores = new int[num];
		//学生成绩数组赋值
		for(int i = 0;i<scores.length;i++) {
			System.out.print("请输入第" + (i + 1) + "位学生的成绩：");
			scores[i] = sc.nextInt();
		}
		//获取最高分
		int scoreMax = scores[0];
		for(int i = 1;i<scores.length;i++) {
			if(scores[i]>scoreMax) {
				scoreMax = scores[i];
			}
		}
		System.out.println("成绩最高分："+scoreMax);
		//获取学生成绩等级
		for(int i = 0;i<scores.length;i++) {
			if(scores[i]>=scoreMax-10) {
				System.out.println("第" + (i + 1) + "位学生的成绩为A");
			}else if(scores[i]>=scoreMax-20&&scores[i]<scoreMax-10) {
				System.out.println("第" + (i + 1) + "位学生的成绩为B");
			}else if(scores[i]>=scoreMax-30&&scores[i]<scoreMax-20) {
				System.out.println("第" + (i + 1) + "位学生的成绩为C");
			}else {
				System.out.println("第" + (i + 1) + "位学生的成绩为D");
			}
		}
		sc.close();
	}

}
