package com.woniu.chapter08_01doubleForLoop;

public class ForDemo08_jiuJiuChengFaBiao {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {// 行数
			for (int j = 1; j <= i; j++) {// 列数
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}

}
