package com.woniu.chapter03;

import java.util.Scanner;

public class IfDemo04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入远动员的百米赛跑成绩：");
		double secs = sc.nextDouble();
		if(secs <= 10) {
			System.out.println("请输入运动员的性别：");
			String gender = sc.next();
			if(gender.equals("男")) {
				System.out.println("恭喜您进入男子组决赛！");
			}else {
				System.out.println("恭喜您进入女子组决赛！");
			}
		}else {
			System.out.println("被淘汰");
		}
		sc.close();
	}

}
