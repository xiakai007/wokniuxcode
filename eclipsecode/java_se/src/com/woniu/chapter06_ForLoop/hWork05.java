package com.woniu.chapter06_ForLoop;

//6、输出所有的水仙花数（可选）
public class hWork05 {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			int ge = i % 10;
			int shi = i / 10 % 10;
			int bai = i / 100;
			if (i == ge * ge * ge + shi * shi * shi + bai * bai * bai) {
				System.out.println("水仙花数有：" + i);
			}
		}
	}

}
