package com.woniu.chapter05;

import java.util.Scanner;

//1.从键盘接收整数参数。如果该数为1-7，
// 打印对应的星期值，否则打印“非法参数”。
public class Work01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int week = sc.nextInt();
		switch (week) {
		case 1:
			System.out.println("星期一");
			break;
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		case 7:
			System.out.println("星期天");
			break;
		default:
			System.out.println("非法参数");
		}
		sc.close();
	}

}
