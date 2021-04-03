package com.woniu.chapter15_FarmFruits;

public class People {
	public static void main(String[] args) {
		FruitGardener fgd = new FruitGardener();
		Fruit fruit = fgd.getFruit("草莓");
//		fruit.plant();
		fgd.info(fruit);
		Fruit fruit2 = fgd.getFruit("苹果");
		fgd.info(fruit2);
		Fruit fruit3 = fgd.getFruit("葡萄");
		fgd.info(fruit3);
	}

}
