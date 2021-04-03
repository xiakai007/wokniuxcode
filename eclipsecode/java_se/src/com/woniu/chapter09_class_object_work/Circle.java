package com.woniu.chapter09_class_object_work;

public class Circle {
	double radius;
	double perimeter;
	double area;

	/**
	 * 求圆周长的方法
	 */
	public void peri() {
		perimeter = radius * 2 * 3.14;
		System.out.println("圆的周长是：" + perimeter);
	}

	/**
	 * 求圆面积的方法
	 */
	public void areas() {
		area = radius * radius * 3.14;
		System.out.println("圆的面积是：" + area);
	}

}
