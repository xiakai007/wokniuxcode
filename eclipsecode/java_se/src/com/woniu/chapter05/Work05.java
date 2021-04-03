package com.woniu.chapter05;

//5、打印1~100之间 6的倍数的个数
public class Work05 {
	public static void main(String[] args) {
		int num = 1;
		int i = 0;
		while (num <= 100) {
			if (num % 6 == 0) {
				System.out.println(num);
				i++;
			}
			num++;
		}
		System.out.println("1~100之间 6的倍数的个数为" + i + "个");
	}

}
