package com.woniu.chapter09_class_object_work;

public class Customer {
	int score;
	String type;

	public void show() {
		System.out.println("积分：" + score + "，卡类型：" + type);
		if (score >= 1000 && type == "金卡" || score >= 5000 && type == "普卡") {
			System.out.println("回馈积分500分！");
		} else {
			System.out.println("没有积分。");
		}

	}

}
