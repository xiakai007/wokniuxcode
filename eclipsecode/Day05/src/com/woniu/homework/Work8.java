package com.woniu.homework;

import java.util.Scanner;

public class Work8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		if(month == 1 ||month == 2) {
			System.out.println("第"+month+"个月兔子共有1对。");
			sc.close();
			return;
		}
		
		int i = 3;
		int pre_1 = 1;
		int pre_2 = 1;
		int pre_n = 0;
		while(i <= month) {
			pre_n = pre_1 + pre_2;
			pre_1 = pre_2;
			pre_2 = pre_n;
			i++;
		}
		System.out.println("第"+month+"个月兔子共有"+pre_n+"对。");
		sc.close();
	}

}
