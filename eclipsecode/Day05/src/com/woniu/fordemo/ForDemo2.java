package com.woniu.fordemo;

public class ForDemo2 {
	public static void main(String[] args) {
		for(int i = 100;i < 999;i++) {
			int bai = i/100,shi = i/10%10,ge = i%10;
			if(i == bai*bai*bai+shi*shi*shi+ge*ge*ge) {
				System.out.print(i+" ");
			}
		}
	}

}
