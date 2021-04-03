package com.woniu.chapter03;

import java.util.Scanner;

public class IfDemo02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 提示输入张浩Java成绩、音乐成绩
		System.out.println("输入张浩的Java成绩：");
		int scoreJava = sc.nextInt();
		System.out.println("输入张浩的音乐成绩：");
		int scoreMusic = sc.nextInt();
		// 判断
		if ((scoreJava > 98 && scoreMusic > 80) || (scoreJava == 100 && scoreMusic > 70)) {
			System.out.println("老师奖励张浩华为手机");
		}
		sc.close();
	}

}
