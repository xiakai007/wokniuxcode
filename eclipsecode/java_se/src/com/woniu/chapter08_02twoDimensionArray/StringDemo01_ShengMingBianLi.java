package com.woniu.chapter08_02twoDimensionArray;

import java.util.Arrays;

public class StringDemo01_ShengMingBianLi {
	public static void main(String[] args) {
		//动态初始化，方式一：名称为arr的二维数组，
		//每个数组中有两个元素
		int [][]arr = new int[3][2];
		System.out.println(arr);
		//动态初始化，方式二：arr2的二维数组，可以对这三个以为数组分别进行初始化
		int [][]arr2 = new int[3][];
		arr2[0] = new int[0];
		arr2[1] = new int[4];
		arr2[2] = new int[5];
		//静态初始化：声明空间和赋值一起
		int [][]arr3 = new int[][] {{3,8,13},{1,2},{6,7,9,4,19,654,24,15487}};
		//使用
		System.out.println(arr3.length);
		System.out.println(arr3[2].length);
		System.out.println(Arrays.toString(arr3));//地址
		for(int i=0;i<arr3.length;i++) {
			for(int j = 0;j<arr3[i].length;j++) {
				System.out.print(arr3[i][j]+" ");
			}
			System.out.println();
		}
	}

}
