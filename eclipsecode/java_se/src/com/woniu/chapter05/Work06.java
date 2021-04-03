package com.woniu.chapter05;

//求出1～100之间，既是3又是7的倍数的自然数出现的次数
public class Work06 {
	public static void main(String[] args) {
		int num = 1;
		int i = 0;
		while (num <= 100) {
			if (num % 3 == 0 && num % 7 == 0) {
				System.out.println(num);
				i++;
			}
			num++;
		}
		System.out.println("1~100之间 既是3又是7的倍数的自然数出现了" + i + "次");
	}

}
