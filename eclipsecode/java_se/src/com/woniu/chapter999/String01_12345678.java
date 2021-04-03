package com.woniu.chapter999;

import java.util.Scanner;

public class String01_12345678 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一串数字字符串：");
		String num = sc.next();
		StringBuffer numB = new StringBuffer(num);
		for (int i = numB.length()-2; i >0; i-=3) {
			numB.insert(i, ",");
		}
		System.out.println(numB);
		sc.close();
	}
	
	

}
