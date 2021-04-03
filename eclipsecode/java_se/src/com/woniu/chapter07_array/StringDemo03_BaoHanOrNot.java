package com.woniu.chapter07_array;

import java.util.Scanner;

public class StringDemo03_BaoHanOrNot {
	public static void main(String[] args) {
		int[] arr = { 8, 4, 2, 1, 23, 344, 12 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println("\n---------------");
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		System.out.println("---------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int num = sc.nextInt();
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("包含");
		} else {
			System.out.println("不包含");
		}
		sc.close();
	}

}
