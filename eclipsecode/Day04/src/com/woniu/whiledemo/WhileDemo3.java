package com.woniu.whiledemo;

import java.util.Scanner;

public class WhileDemo3 {
	public static void main(String[] args) {
		int i = 6;
		int ss = 1;
		while(i>0) {
			ss *= i;
			i--;
		}
		System.out.println("6!="+ss);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		int num = sc.nextInt();
		int temp = num;
		long jie = 1;
		if(num < 0) {
			System.out.println("负数没有阶乘！");
		}else if(num == 0) {
			System.out.println(num + "!="+1);
		}else {
			while(num>0) {
				jie *= num;
				num--;
			}
			System.out.println(temp+"!="+jie);
		}
		
		sc.close();
	}

}
