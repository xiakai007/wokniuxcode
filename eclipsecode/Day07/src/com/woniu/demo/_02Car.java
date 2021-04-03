package com.woniu.demo;

public class _02Car {
	String brand = "解放牌";
	String color = "红色";
	float price = 288888f;
	String type = "SUV";
	public void run() {
		System.out.println(brand+"正在行驶");
	}
	public void speed() {
		System.out.println(brand+"正在加速行驶");
	}
	public void stop() {
		System.out.println(brand+"已停车！");
	}

}
