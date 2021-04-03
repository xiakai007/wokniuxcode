package com.woniu.fordemo;

public class ForDemo1 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1;i <= 100;i++) {
			sum += i;
		}
		System.out.println(sum);
		for(int i = 9;i >= 1;i -=2) {
				System.out.print(i+"  ");
		}
		int ji = 1,sum2 = 0;
			for(int i = 6;i > 0;i--) {
				ji *= i; 
			}
			sum2 +=ji;
		System.out.println("\n"+sum2);
		
		long sum3 = 0;
		for(int i = 1;i <= 16;i +=3) {
			long ji2 = 1;
			for(int j = i;j > 0;j--) {
				ji2 *=j;
			}
			sum3 += ji2; 
			
		}
		System.out.println(sum3);
	}

}
