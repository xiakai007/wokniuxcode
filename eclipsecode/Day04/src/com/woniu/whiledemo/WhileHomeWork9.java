package com.woniu.whiledemo;

public class WhileHomeWork9 {
	public static void main(String[] args) {
		int i = 100;
		while(i<1000) {
			int ge = i%10;
			int shi = i/10%10;
			int bai = i/100;
			if(i==ge*ge*ge+shi*shi*shi+bai*bai*bai) 
				System.out.println(i);	
			i++;
		}
	}
}
