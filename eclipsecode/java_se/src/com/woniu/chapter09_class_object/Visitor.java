package com.woniu.chapter09_class_object;

public class Visitor {
	String name;//游客姓名
	int age;//游客年龄
	/**
	 * 根据游客年龄判定门票价格
	 */
	public void show() {
		if(age>=12&&age<=60) {
			System.out.println(name+"的年龄为："+age+"，门票价格为：20元\n");
		}else {
			System.out.println(name+"的年龄为："+age+"，门票免费\n");
		}
	}

}
