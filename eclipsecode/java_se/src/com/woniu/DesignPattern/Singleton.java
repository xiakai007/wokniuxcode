package com.woniu.DesignPattern;

public class Singleton {
	//2.创建静态属性同时new对象
	private static Singleton single = new Singleton();
	//1.构造私有化
	private Singleton() {
		
	}
	//创建静态方法，返回当前对象
	public static Singleton getInstance() {
		return single;
	}

}
