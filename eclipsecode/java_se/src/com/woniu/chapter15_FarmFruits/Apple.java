package com.woniu.chapter15_FarmFruits;

public class Apple implements Fruit {

	@Override
	public void plant() {
		System.out.println("苹果正在栽种");
	}

	@Override
	public void grow() {
		System.out.println("苹果正在生长");
	}

	@Override
	public void harvest() {
		System.out.println("收获了苹果");
	}

}
