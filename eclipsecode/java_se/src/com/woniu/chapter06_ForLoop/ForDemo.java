package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

public class ForDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score ;
		double sum = 0;//初始化求和
		double avg = 0;
		
		System.out.println("请输入学生姓名：");
		String name = sc.nextLine();
		
		boolean flag = true;//控制负数提示
		for(int i = 0;i<5;i++) {
			System.out.print("第"+(i+1)+"门课的成绩为：");
			score = sc.nextInt();
			if(score<0) {
				flag = false;
				break;
			}
			sum += score;
		}
		if(flag) {
			avg = sum*1.0/5;
			System.out.println(name+"的平均分是："+avg);
		}else {
			System.out.println("成绩不能为负数！");//成绩为负程序结束
		}
	
		sc.close();
	}

}
