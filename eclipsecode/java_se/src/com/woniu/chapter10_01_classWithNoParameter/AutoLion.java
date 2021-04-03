package com.woniu.chapter10_01_classWithNoParameter;

public class AutoLion {
	String color;
	
	public void run() {
		System.out.println("正在奔跑");
	}
	
	public String bark() {
		String sound = "大声吼叫";
		return sound;
	}
	
	public String getColor() {
		return color;
	}
	
	public String showLion() {
		return "这是一个"+getColor()+"的电动狮子";
	}

}
