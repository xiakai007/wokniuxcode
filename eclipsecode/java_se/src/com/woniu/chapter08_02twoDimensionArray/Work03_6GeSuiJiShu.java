package com.woniu.chapter08_02twoDimensionArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Work03_6GeSuiJiShu {
	public static void main(String[] args) {
		int[] num = new int[6];
//		int count = 0;
		for (int i = 0;i < num.length;i++) {
//			count++;
			num[i] = (int) (Math.random() * 10 + 1);
			for (int j = 0;j < i;j++) {
				if (num[i] == num[j]) {
//					count++;
					i--;
					continue;
				}
			}
		}
		System.out.println("数组num为：" + Arrays.toString(num));
//		System.out.println("循环了"+count+"次");
		Set<Integer> setNum = new HashSet<>();
		while(setNum.size()<6) {
			setNum.add((int)(Math.random()*10+1));
		}
		System.out.println(setNum);
		
	}

}
