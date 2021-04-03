package com.woniu.home1;

public class Dog {
	String name;
	public void eat(Meat meat) {
		System.out.println(name+"喜欢吃"+meat.name);
	}
	public void eat(Fish fish) {
		System.out.println(name+"喜欢吃"+fish.name);
	}

}
