package com.woniu.chapter03;

import java.util.Scanner;

public class Work04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入小明的考试成绩：");
		int score = sc.nextInt();
		if(score == 100) {
			System.out.println("爸爸买辆车");
		}else if(score >= 90 && score <100) {
			System.out.println("妈妈买MP4");
		}else if(score >= 60 && score <90) {
			System.out.println("妈妈买参考书");
		}else {
			System.out.println("不买任何东西");
		}
		sc.close();
	}

}
