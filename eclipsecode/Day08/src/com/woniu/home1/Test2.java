package com.woniu.home1;

public class Test2 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "哈士奇";
		Meat meat = new Meat();
		meat.name = "里脊肉";
		Fish fish = new Fish();
		fish.name = "扬子鳄";
		dog.eat(meat);
		dog.eat(fish);
	}

}
