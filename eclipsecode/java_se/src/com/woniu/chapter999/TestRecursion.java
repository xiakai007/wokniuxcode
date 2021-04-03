package com.woniu.chapter999;

import java.util.ArrayList;
import java.util.List;

class TestFactorial{
	public static long factorial(int n) {
		if(n<=1) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}
}
class Fibonacci{
	public static long getFibonacci(int n) {
		if(n==1) {
			return 0;
		}else if(n==2||n==3) {
			return 1;
		}else {
			return getFibonacci(n-1)+getFibonacci(n-2);
		}
	}
	public static List<Long> getFibList(int n){
		List<Long> listFib = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			listFib.add(getFibonacci(i));
		}
		return listFib;
	}
}

public class TestRecursion {
	public static void main(String[] args) {
		long ftr = TestFactorial.factorial(6);
		System.out.println(ftr);
		long fib = Fibonacci.getFibonacci(30);
		System.out.println(fib);
		List<Long> listFib = new ArrayList<>();
		listFib = Fibonacci.getFibList(30);
		System.out.println(listFib);
	}

}
