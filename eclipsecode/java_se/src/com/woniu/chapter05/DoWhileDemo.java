package com.woniu.chapter05;

import java.util.Scanner;

public class DoWhileDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//初始值+条件
		String answer = "";
		do {
			System.out.println("上机写代码");
			System.out.println("\n是否合格（y/n）：");
			answer = sc.next();
		}while(answer.equals("n"));
		System.out.println("执行完成");
		sc.close();
	}

}
