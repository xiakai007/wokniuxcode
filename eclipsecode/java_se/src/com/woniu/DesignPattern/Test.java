package com.woniu.DesignPattern;

public class Test {
	public static void main(String[] args) {
		Singleton st1 = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st1==st2);
		Singleton2 st3 = Singleton2.getInstance();
		Singleton2 st4 = Singleton2.getInstance();
		System.out.println(st3);
		System.out.println(st4);
		System.out.println(st3==st4);
	}

}
