package com.woniu.homework;

import java.util.Scanner;

//菱形
public class Work11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 1;
		while(k<=3) {
		System.out.println("请输入第"+k+"个菱形坐标值：");
		int scope = sc.nextInt();
		int i = -scope;
		while(i <= scope) {
			int j = -scope;
			while(j <= scope) {
				if(Math.abs(i)+Math.abs(j) == scope) {
					System.out.print("* ");
				}else{
					System.out.print("  ");
				}
				j++;
			}
			System.out.println();
			i++;
		}
		k++;
		}
		sc.close();
	}
}