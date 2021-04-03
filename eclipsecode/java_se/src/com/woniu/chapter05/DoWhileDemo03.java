package com.woniu.chapter05;

import java.util.Scanner;

public class DoWhileDemo03 {
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
		String choice = "";
		boolean flag = true;
		do {
				flag = false;
			if (num >= 1 && num <= 4) {
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
						break;//break退出后执行break下面的代码
					}
					System.out.println(choice);
					System.out.println("程序结束");
//					return;//return返回主函数main的void值,return导致sc.close();无法执行
				} 
			else {
					System.out.println("错误，请重新输入：");
					num = sc.nextInt();
					flag = true;
				}
		} while (flag);
		sc.close();

	}
}
