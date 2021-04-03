package com.woniu.chapter10_01_classWithNoParameter;

public class AutoLionTest {
	public static void main(String[] args) {
		AutoLion lion = new AutoLion();
		lion.color = "红色";
		//调用显示狮子的方法
		System.out.println(lion.showLion());
		//调用跑的方法
		lion.run();
		//调用叫的方法
		String sound = lion.bark();
		System.out.println(sound);
		
	}

}
