package com.woniu.demo;

import java.util.Scanner;

public class HomeWork7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入张浩的Java考试成绩：");
		int score = sc.nextInt();
		System.out.println(score>98?"张浩获得一个MP4":"啥也没有");
		sc.close();
	}

}
