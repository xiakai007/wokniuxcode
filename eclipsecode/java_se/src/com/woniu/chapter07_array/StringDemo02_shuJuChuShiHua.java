package com.woniu.chapter07_array;

public class StringDemo02_shuJuChuShiHua {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("---------");
		byte[] arr1 = new byte[10];
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("---------");
		boolean[] arr2 = new boolean[10];
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("---------");
		char[] arr3 = new char[10];
		for (int i = 0; i < arr3.length; i++) {
//			System.out.println(arr3[i]);
			if (arr3[i] == 0) {// 0的unicode码与空字符unicode码一致
				System.out.println(1);
			}
		}
		System.out.println("---------");
		String[] arr4 = new String[10];
		for (int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i]);
		}
		System.out.println("".equals(" "));
	}
}
