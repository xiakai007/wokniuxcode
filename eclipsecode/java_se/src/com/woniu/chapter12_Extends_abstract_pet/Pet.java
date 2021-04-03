package com.woniu.chapter12_Extends_abstract_pet;

public abstract class Pet {
	//名字
	private String name = "无名氏";
	//健康值
	private int health=85;
	//亲密度
	private int love=1;
	//父类无参构造
	public Pet() {
	}
	//父类有参构造
	public Pet(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if(health>100||health<=0) {
			System.out.println("健康值应该在0-100之间，默认值为40。");
			this.health = 40;
		}else {
			this.health = health;
		}
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	
	public abstract void show();
	public abstract void eat();

}
