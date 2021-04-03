package com.woniu.demo;

import java.util.Arrays;

public class ArrayDemo6 {
	public static void main(String[] args) {
		char [] arr= {'a','b','c','d','e'};
		System.out.println(Arrays.toString(arr));
		//使用一个数组实现倒序。
//		for(int i = arr.length-1;i>=0;i--) {
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
		for(int left=0,right=arr.length-1;left<right;left++,right--) {
			char temp = arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			
		}
		System.out.println(Arrays.toString(arr));
	}

}
