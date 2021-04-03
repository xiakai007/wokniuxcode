package com.woniu.homework;
//倒三角
public class Work11 {
	public static void main(String[] args) {
		int i = 1;
		while(i<=9) {
			int j = 1;
			while(j<=10-i) {
				System.out.print("* ");
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
