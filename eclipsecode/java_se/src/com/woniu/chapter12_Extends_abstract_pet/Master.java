package com.woniu.chapter12_Extends_abstract_pet;

public class Master {
	private String name = "";
	private int money = 0;
	public Master() {
		
	}
	public Master(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
//	public void feed(Dog dog) {
//		dog.eat();
//	}
//	public void feed(Penguin penguin) {
//		penguin.eat();
//	}
//	public void feed(Cat cat) {
//		cat.eat();
//	}
	public void feed(Pet pet) {
		pet.eat();
	}
	public Pet getPet(String typeId) {
		Pet pet = null;
		if(typeId.equals("1")) {
			pet = new Dog("欧欧","雪纳瑞");
		}else if(typeId.equals("2")) {
			pet = new Penguin("楠楠","Q妹");
		}
		return pet;
	}
	public void play(Pet pet) {
		if(pet instanceof Dog) {
			Dog dog = (Dog)pet;
			dog.catchingFlyDisc();
		}else if(pet instanceof Penguin) {
			Penguin peng = (Penguin)pet;
			peng.swimming();
		}
	}

}
