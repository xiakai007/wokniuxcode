package com.woniu.whiledemo;

public class WhileHomeWork6 {
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		int j = 1;
		while(j<=100) {
			if(j%7==0) {
				
				i++;
				sum += j;
			}
			j++; 
		}
		
		System.out.println(i);
		System.out.println(sum);
	}

}
