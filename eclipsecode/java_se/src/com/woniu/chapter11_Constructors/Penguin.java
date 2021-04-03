package com.woniu.chapter11_Constructors;

public class Penguin {
	private String name;
	private int health=100;
	private int love=0;
	private String gender;
	public static final String GENDER_MALE="雄";
	public static final String GENDER_FEMALE="雌";
	
	
	
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
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void show() {
		System.out.println("宠物的自白\n我的名字叫"+name+",健康值是"+health+",和主人的亲密度是"+love+",性别是"+gender+"。");
	}
	
	

}
