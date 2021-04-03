package com.woniu.demo;

public class HomeWork4 {
	public static void main(String[] args) {
		int a = 12345;
		int ge = a % 10;
		int shi = a / 10 %10;
		int bai = a /100 % 10;
		int qian = a /1000 %10;
		int wan = a /10000;
		System.out.println(ge);
		System.out.println(shi);
		System.out.println(bai);
		System.out.println(qian);
		System.out.println(wan);
	}

}
