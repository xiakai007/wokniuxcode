package com.woniu.fordemo;

import java.util.Scanner;

public class ForDemo3 {
	public static void main(String[] args) {
		//1、1、2、3、5、8...
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入兔子繁殖月数：");
		int num = sc.nextInt();
		if(num == 1 || num == 2) {
			System.out.println("第"+num+"个月繁殖后共有1对兔子");
			sc.close();
			return;
		}
		int n1 = 1,n2 = 1,sum = 0;
		for(int i =3;i <= num;i++) {
			sum = n1 + n2;
			n2 = n1;
			n1 = sum;
		}
		System.out.println("第"+num+"个月繁殖后共有"+sum+"对兔子");
		sc.close();
	}

}
