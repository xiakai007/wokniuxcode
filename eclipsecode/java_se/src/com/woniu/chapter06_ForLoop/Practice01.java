package com.woniu.chapter06_ForLoop;

import java.util.Scanner;

public class Practice01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count1 = 0,count2 = 0;
		boolean flag = true;
		
		while(flag) {
			System.out.println("请输入一个整数：");
			int num = sc.nextInt();
			if(num>0) {
				count1++;//正数个数
				continue;
			}
			if(num<0) {
				count2++;//负数个数
				continue;
			}
			if(num==0) {
				System.out.println("您总共输入了"+count1+"个正数。");
				System.out.println("您总共输入了"+count2+"个负数。");
				flag = false;
			}
		}
		System.out.println("程序结束！");
		sc.close();
	}

}
