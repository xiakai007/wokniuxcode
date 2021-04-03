package com.woniu.demo;
import java.util.Scanner;
public class HomeWork5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个四位数的整数：");
		int a = sc.nextInt();
		int ge = a % 10;
		int shi = a /10%10;
		int bai = a/100%10;
		int qian = a/1000;
		int b = ge*1000+shi*100+bai*10+qian;
		System.out.println(b);
		sc.close();
	}

}
