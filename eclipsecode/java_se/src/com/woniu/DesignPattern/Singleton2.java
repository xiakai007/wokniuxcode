package com.woniu.DesignPattern;

public class Singleton2 {
	private static Singleton2 sing2;
	
	private Singleton2() {
		
	}
	
	public static Singleton2 getInstance() {
		if(sing2==null) {
			sing2 = new Singleton2();
		}
		return sing2;
	}

}
