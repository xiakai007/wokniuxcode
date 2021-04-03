package com.woniu.home1;

public class Test {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.name = "加菲猫";
		Fish fish = new Fish();
		fish.name = "巴沙鱼";
		Meat meat = new Meat();
		meat.name = "五花肉";
		cat.eat(fish);
		cat.eat(meat);
	}

}
