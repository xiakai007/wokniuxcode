package com.woniu.do_while;

public class Demo {
	public static void main(String[] args) {
//		System.out.println(11111);
//		int i = 0;
//		if(i == 0) {
//		return;
//		}
//		System.out.println(22222);
		int i = 1;
		while(i <= 10) {
			if(i % 2 ==0) {
				i++;
				continue;
				
			}
			System.out.println(i+" ");
			i++;
		}
	}

}
