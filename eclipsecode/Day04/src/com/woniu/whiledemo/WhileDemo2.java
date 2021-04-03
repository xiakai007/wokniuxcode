package com.woniu.whiledemo;

public class WhileDemo2 {
	public static void main(String[] args) {
		int i= 1;
		int sum = 0;
		while(i<=100) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		int j = 1;
		int sum2 = 0;
		while(j<=100) {
			sum2 += j*j;
			j += 3;
		}
		System.out.println(sum2);
	}

}
