package com.woniu.home3;

public class Test {
	public static void main(String[] args) {
		Point point = new Point();
		System.out.println(point);
		point.x = 3f;
		point.y = 4f;
		point.print();
		Circle circle = new Circle();
		circle.r = 10;
		circle.center = point;
		circle.print();
		//画出内存图
	}

}
