package com.woniu.chapter15_FarmFruits;

public class Grape implements Fruit {

	@Override
	public void plant() {
		System.out.println("葡萄正在栽种");
	}

	@Override
	public void grow() {
		System.out.println("葡萄正在生长");
	}

	@Override
	public void harvest() {
		System.out.println("收获了葡萄");
	}

}
