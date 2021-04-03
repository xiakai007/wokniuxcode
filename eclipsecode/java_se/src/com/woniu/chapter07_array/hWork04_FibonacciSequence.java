package com.woniu.chapter07_array;

import java.util.Arrays;

public class hWork04_FibonacciSequence {
	public static void main(String[] args) {
		int []fib = new int[20];
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2;i<fib.length;i++) {
			fib[i] = fib[i-1]+fib[i-2];
		}
		System.out.println("斐波那契数列前20项值："+Arrays.toString(fib));
	}

}
