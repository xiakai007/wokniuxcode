package com.woniu.chapter06_ForLoop;

//100以内的奇数之和
public class ForDemo04 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
