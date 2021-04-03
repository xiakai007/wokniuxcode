package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

public class Practice02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score ;
		double sum = 0;//初始化求和
		double avg = 0;
		
		System.out.println("请输入学生姓名：");
		String name = sc.nextLine();
		
		for(int i = 0;i<5;i++) {
			System.out.print("第"+(i+1)+"门课的成绩为：");
			score = sc.nextInt();
			if(score<0) {
				System.out.println("成绩不能为负数！");
				i--;//成绩为负循环输入，直至输入正确执行后续代码
				continue;
			}
			sum += score;
		}
			avg = sum*1.0/5;
			System.out.println(name+"的平均分是："+avg);
		sc.close();
	}
}
