package com.woniu.chapter06_ForLoop;
//1-10之间整数相加，累加值大于20的当前数
public class ForDemo05 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1;i<=10;i++) {
			sum += i;
			if(sum>=20) {
				System.out.println(i);
				break;
			}
		}
	}
}
