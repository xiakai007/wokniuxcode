package com.woniu.whiledemo;

public class WhileHomeWork10 {
	public static void main(String[] args) {
		int year = 0;
		double money = 1000;
		while(money<=5000) {
			money = money+money*0.05;
			year++;
		}
//		while(true) {
//			money = money+money*0.05;
//			year++;
//			if(money>=5000)
//			break;
//		}
		
		System.out.println(year);
	}

}
