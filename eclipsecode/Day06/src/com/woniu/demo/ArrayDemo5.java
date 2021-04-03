package com.woniu.demo;

import java.util.Arrays;

//冒泡算法
public class ArrayDemo5 {
	public static void main(String[] args) {
		int [] arr = {5,8,56,78,6,54,9,45,66,2,-6,-4};
		int count = 0;
		for(int i=0;i< arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				count++;
			}
		}
		System.out.println("循环次数："+count);
//		for(int i=0;i<arr.length;i++) {
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
		System.out.println(Arrays.toString(arr));
	}

}
