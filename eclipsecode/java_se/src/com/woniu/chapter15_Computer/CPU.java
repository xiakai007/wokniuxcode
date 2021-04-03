package com.woniu.chapter15_Computer;

public interface CPU {
	String getBrand();
	public static void info() {
		System.out.println("这是一个CPU接口");
	}
	 default String getCpu() {
		return "国产";
	}

}
