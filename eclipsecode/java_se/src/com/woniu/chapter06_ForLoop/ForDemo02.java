package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

public class ForDemo02 {
	public static void main(String[] args) {
		System.out.println("请输入自然数值：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i = 0;i<=num;i++) {
			System.out.println(i+"+"+(num-i)+"="+num);
			sc.close();
		}
	}

}
