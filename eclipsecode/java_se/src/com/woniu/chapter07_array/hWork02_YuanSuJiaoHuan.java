package com.woniu.chapter07_array;

import java.util.Arrays;
import java.util.Scanner;

public class hWork02_YuanSuJiaoHuan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数组5个元素：");
		int[] num = new int[5];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(num));

		int numMax = num[0];
		int numMin = num[0];
		for (int i = 0; i < num.length; i++) {
			if (num[i] > numMax) {
				numMax = num[i];
			}
			if (num[i] < numMin) {
				numMin = num[i];
			}
		}
		System.out.println("最大值为：" + numMax + "，最小值为：" + numMin);
		
		for (int i = 0; i < num.length; i++) {
			if (numMax == num[i]) {
				int temp = num[i];
				num[i] = num[0];
				num[0] = temp;
			}
			if (numMin == num[i]) {
				int temp = num[i];
				num[i] = num[num.length - 1];
				num[num.length - 1] = temp;
			}
		}
		System.out.println(Arrays.toString(num));
		sc.close();
	}

}
