package com.woniu.whiledemo;

import java.util.Scanner;

public class WhileHomeWork11 {
	public static void main(String[] args) {
//		112358...
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入兔子繁殖的月数：");
		int month = sc.nextInt();
		if(month ==1 || month ==2) {
			System.out.println(1);
			sc.close();
			return;
		}
		int i = 3;
		int sum = 0;
		int n1 = 1,n2 = 1;
		while(i<=month) {
			sum = n1+n2;
			n1 = n2;
			n2 = sum;
			i++;
		}
		System.out.println(sum);
		sc.close();
	}

}
