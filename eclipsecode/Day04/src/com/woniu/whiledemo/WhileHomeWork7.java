package com.woniu.whiledemo;

public class WhileHomeWork7 {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
//		while(i<=10) {
//			sum += i;
//			i++;
//			if(sum>20)
//				break;
//		}
		while(sum<=20) {
			sum += i;
			i++;
		}
//		while(ture) {
//			sum += i;
//			i++;
//			if(sum>20)
//				break;
//		}
		System.out.println(sum);
		System.out.println(i);
	}

}
