package com.woniu.chapter05;

public class WhileDemo02 {
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		while(i<=10) {
			i +=2;
			sum +=i;
//			i +=2;
		}
		System.out.println(sum);
	}

}
