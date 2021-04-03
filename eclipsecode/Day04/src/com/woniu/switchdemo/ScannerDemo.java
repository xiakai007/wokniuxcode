package com.woniu.switchdemo;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入内容1：");
		String s1 = sc.nextLine();
		System.out.println("结果："+s1);
		System.out.println("------------------");
		System.out.println("请输入：");
		int num = sc.nextInt();
		System.out.println("数字："+num);
		System.out.println("------------------");
		System.out.println("请输入内容2：");
		String s2 = sc.next();
		System.out.println("结果："+s2);
		sc.close();
	}

}
