package com.woniu.chapter05;

import java.util.Scanner;

public class DoWhileDemo0302{
	public static void main(String[] args) {
		System.out.println("欢迎使用");
		System.out.println("----------");
		System.out.println("1.客户");
		System.out.println("2.购物");
		System.out.println("3.真情");
		System.out.println("4.注销");
		System.out.println("----------");

		Scanner sc = new Scanner(System.in);
		System.out.print("请输入整数数字：");
		int num = sc.nextInt();
		boolean flag = false;
		String choice = "";
		do {
				flag = false;
				switch (num) {
				case 1:
					choice="执行客户";
					break;
				case 2:
					choice="执行购物";
					break;
				case 3:
					choice="执行真情";
					break;
				case 4:
					choice="执行注销";
					break;
				default:
					System.out.print("错误——1，请重新输入：");
					num = sc.nextInt();
					flag = true;
					break;
				}
				System.out.println(choice);
		} while (flag);
		System.out.println("程序结束");
		sc.close();

	}
}
