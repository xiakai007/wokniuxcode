package com.woniu.chapter06_ForLoop;

//1.打印自然数的个数
//打印1~100之间 6的倍数的个数
//求出1～100之间，既是3又是7的倍数的自然数
//出现的次数？
public class hWork01 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 6 == 0) {
				count++;
			}
		}
		System.out.println("1~100之间 6的倍数的个数有" + count + "个");
		int count2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 7 == 0) {
				System.out.println("1~100之间 既是3又是7的倍数的自然数:" + i);
				count2++;
			}
		}
		System.out.println("1~100之间 既是3又是7的倍数的自然数有" + count2 + "个");
	}

}
