package com.woniu.home3;

public class Circle {
	Point center;  //初始值为null
	int r;
	public void print() {
		if(center != null) {  //解决空指针异常
			System.out.println("圆心坐标为：（"+center.x+"，"+center.y+"），半径为："+r+"cm");
		}else {
			System.out.println("请设置圆心：");
		}
		
	}

}
