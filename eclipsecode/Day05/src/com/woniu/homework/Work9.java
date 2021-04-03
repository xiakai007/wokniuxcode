package com.woniu.homework;

public class Work9 {
	public static void main(String[] args) {
		int i = 1;
		while(i <= 5) {
			int j = 1;
			while(j <= 6-i) {
				System.out.print("* ");
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
