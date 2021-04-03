package com.woniu.chapter06_ForLoop;
//4、打印1-100之间非13的倍数，使用continue语句
public class hWork03 {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			if (i % 13 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}

}
