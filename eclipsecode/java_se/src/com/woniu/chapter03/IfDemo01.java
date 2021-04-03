package com.woniu.chapter03;

import java.util.Scanner;

public class IfDemo01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//提示输入张浩Java成绩
		System.out.println("输入张浩的Java成绩：");
		int score = sc.nextInt();
		//判断并输出
		if(score > 98) { 
			System.out.println("奖励张浩一台手机");
		}else { 
			System.out.println("奖励写代码");
		}
		
		sc.close();
	}

}
