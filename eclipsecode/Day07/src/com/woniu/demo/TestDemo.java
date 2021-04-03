package com.woniu.demo;

public class TestDemo {
	public static void main(String[] args) {
		Calculator cltr = new Calculator();
		System.out.println(cltr);
		System.out.println(cltr.brand);
		System.out.println(cltr.type);
		cltr.brand = "小米m";
		System.out.println(cltr.brand);
		cltr.add(3, 5);
		cltr.sub(7.22, 7.2);
		cltr.sqrt(121);
		cltr.pow(2.5, 3.2);
		System.out.println("-----------------------");
		for(int i = 0;i<10;i++) {
			cltr.createRandom();
		}
	}
}
