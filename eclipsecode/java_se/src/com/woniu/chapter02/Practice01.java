package com.woniu.chapter02;

import java.util.Scanner;

public class Practice01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("输入学员张三成绩：");
		int scoreZhang = sc.nextInt();
		int scoreLi = 80;
		boolean flag = scoreZhang > scoreLi;
		System.out.println("张三成绩比李四高吗？"+flag);
		sc.close();
	}

}
