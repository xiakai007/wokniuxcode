package com.woniu.switchdemo;
import java.util.Scanner;
public class SwitchDemo4 {
	public static void main(String[] args) {
		System.out.println("请输入1～7之间的数字：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch(num) {
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
			System.out.println("非法字符");
		}
		System.out.println("欢迎进入图书管理系统！");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.退出（退出系统/程序）");
		Scanner sc2 = new Scanner(System.in);
		char ch = sc2.nextLine().charAt(0);
		switch(ch) {
		case '1':
			System.out.println("登录");
			break;
		case '2':
			System.out.println("注册");
			break;
		case '3':
			System.out.println("退出（退出系统/程序）");
			break;
		default:
			System.out.println("非法输入");
		}
		sc.close();
		sc2.close();
	}

}
