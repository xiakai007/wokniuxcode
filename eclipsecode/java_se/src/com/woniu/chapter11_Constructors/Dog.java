package com.woniu.chapter11_Constructors;

public class Dog {
	private String name;
	private int health=100;
	private int love=0;
	private String breed;
	
	
	
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
		if(health >100||health<=0) {
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
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
//	构造方法
	public Dog() {
		super();
	}
	public Dog(String name,int health,int love,String breed) {
		super();
		this.name = name;
		this.health = health;
		this.love = love;
		this.breed = breed;
	}
	
	
	public void show() {
		System.out.println("宠物的自白\n我的名字叫"+name+",健康值是"+health+",和主人的亲密度是"+love+",我是一只"+breed+"。");
	}




}
