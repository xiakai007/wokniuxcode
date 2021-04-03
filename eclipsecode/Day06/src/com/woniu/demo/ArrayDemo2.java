package com.woniu.demo;

public class ArrayDemo2 {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6};
		System.out.println(arr);
		System.out.println(arr[5]);
		int length = arr.length;
		System.out.println(length);
		arr = null;
		System.out.println(arr);
//		System.out.println(arr.length);NullPointerException 空指针异常
		
	}

}
