package com.woniu.chapter15_FarmFruits;

public class Strawberry implements Fruit {

	@Override
	public void plant() {
		System.out.println("草莓正在栽种");
	}

	@Override
	public void grow() {
		System.out.println("草莓正在生长");
	}

	@Override
	public void harvest() {
		System.out.println("收获了草莓");
	}

}
