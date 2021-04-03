package com.woniu.chapter05;

//import java.util.Scanner;

public class WhileDemo01 {
	public static void main(String[] args) {
//		int i = 0;
//		while(i<50) {
//			System.out.println("打印第"+(i+1)+"份试卷");
//			i++;
//		}
//		Scanner sc = new Scanner(System.in);
//		System.out.println("合格了吗（y/n）");
//		String answer = sc.next();
//		while("n".equals(answer)) {
//			System.out.println("上午教材");
//			System.out.println("下午编程");
//			System.out.println("合格了吗（y/n）");
//			answer = sc.next();
//		}
//		System.out.println("完成学习任务");
//		sc.close();
//		int i = 2012;
//		int sum = 25;
//		while(sum<100) {
//			sum = (int)(sum*1.25);
//			i++;
//		}
//		System.out.println(i);
//		System.out.println(sum);
		int i = 1;
		int sum = 0;
		while(i<=100) {
			if(i%2==0) {
				System.out.println(i);
				sum +=i;
			}
			i++;
		}
		System.out.println(sum);
	}

}
