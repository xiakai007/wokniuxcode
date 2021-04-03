package com.woniu.chapter06_ForLoop;

//5、用循环控制语句打印输出：1+3+5+...+99=?的结果
public class hWork04 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 100; i++) {
			if (i % 2 == 0) {
				continue;
			}
			sum += i;
		}
		System.out.println("1+3+5+...+99=" + sum);
	}

}
