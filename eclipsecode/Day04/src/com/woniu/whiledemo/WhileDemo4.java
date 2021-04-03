package com.woniu.whiledemo;

public class WhileDemo4 {
	public static void main(String[] args) {

		int jie_0 = 1;
		int sum = 0;
		int i = 1;
		long jhe = 0;
		while(i<=16) {
			int j = i;
			int sss =1;
			while(j>0) {
				sss *= j;
				j--;
			}
			sum += sss;
			i +=3;
		}
		jhe = jie_0 + sum;
		System.out.println(jhe);
		
	}

}
