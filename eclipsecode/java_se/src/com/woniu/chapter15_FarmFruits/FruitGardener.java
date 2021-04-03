package com.woniu.chapter15_FarmFruits;

public class FruitGardener {
	private Fruit fruit;
	

	public FruitGardener() {
		super();
	}
	
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	//面向接口编程
	public Fruit getFruit(String fruitName) {
		if(fruitName.equals("葡萄")) {
			fruit = new Grape();
		}else if(fruitName.equals("苹果")) {
			fruit = new Apple();
		}else if(fruitName.equals("草莓")) {
			fruit = new Strawberry();
		}else {
			fruit = null;
		}
		return fruit;
	}
	public void info(Fruit fruit) {
		fruit.plant();
		fruit.grow();
		fruit.harvest();
	}

}
