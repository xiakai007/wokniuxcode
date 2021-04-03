package com.woniu.chapter07_array;

import java.util.Arrays;
import java.util.Scanner;

public class StringDemo09_insertSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 创建数组并排序
		int[] num = { 99, 85, 82, 63, 60, 79, 12, 108 };
		System.out.println("原数组为" + Arrays.toString(num));
		Arrays.sort(num);
		// 创建新数组
		int[] newNum = new int[num.length + 1];
		// 复制
		for (int i = 0; i < num.length; i++) {
			newNum[i] = num[i];
		}
		// 输入要插入的整数
		System.out.println("请输入要插入的整数：");
		int insertNum = sc.nextInt();
		// 获取要插入的索引
		int index = newNum.length - 1;
		for (int i = 0; i < newNum.length; i++) {
			if (insertNum < newNum[i]) {
				index = i;
				break;
			}
		}
		// 插入该整数
		for (int i = newNum.length - 1; i > index; i--) {
			newNum[i] = newNum[i - 1];
		}
		newNum[index] = insertNum;
		// 输出新数组
		System.out.println("插入后的数组为" + Arrays.toString(newNum));
		sc.close();
	}
}
