package com.woniu.chapter05;

public class DoWhileDemo02 {
	public static void main(String[] args) {
		double c = 0;// 摄氏度
		double f = 0;// 华氏度
		int i = 0;
		System.out.println("条目\t摄氏度\t华氏度");
		do {
			f = c * 9 / 5.0 + 32;
			System.out.println((i + 1) + "\t" + c + "\t" + f);
			c += 20;
			i++;
		} while (i < 10 && c <= 250);
	}

}
