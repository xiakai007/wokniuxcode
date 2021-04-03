package com.woniu.chapter11_Constructors;

public class Box {
	//长
	private double length;
	//宽
	private double width;
	//高
	private double height;
	//体积
	private double volume;
	
//	public double getVolume() {
//		return volume;
//	}
//	public void setVolume(double volume) {
//		this.volume = volume;
//	}
//	public double getLength() {
//		return length;
//	}
//	public void setLength(double length) {
//		this.length = length;
//	}
//	public double getWidth() {
//		return width;
//	}
//	public void setWidth(double width) {
//		this.width = width;
//	}
//	public double getHeight() {
//		return height;
//	}
//	public void setHeight(double height) {
//		this.height = height;
//	}
	//无参构造器
	public Box() {
		super();
	}
	//有参构造器
	public Box(double length, double width, double height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}
	//求体积的方法
	public double getVolume() {
		volume = length*width*height;
		return volume;
	}
	

}
