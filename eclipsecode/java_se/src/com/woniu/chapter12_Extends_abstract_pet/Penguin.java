package com.woniu.chapter12_Extends_abstract_pet;

public class Penguin extends Pet {
	//性别
	private String gender = "Q仔";

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public Penguin() {
		
	}
	public Penguin(String name,String gender) {
		this.setName(name);
		this.gender = gender;
	}
	@Override
	public void show() {
		
		System.out.print("宠物的自白\n我的名字叫"+this.getName()+",健康值是"+this.getHealth()+",和主人的亲密度是"+this.getLove()+",性别是"+gender+"。\n");
	}

	@Override
	public void eat() {
		if(this.getHealth()>=100) {
			System.out.println("企鹅"+this.getName()+"吃饱了，不需要喂食了");
			
		}else {
			this.setHealth(this.getHealth()+5);
			System.out.println("企鹅"+this.getName()+"吃饱了！健康值增加5");
			
		}
	}
	public void swimming() {
		System.out.println("企鹅"+this.getName()+"正在游泳");
		this.setHealth(this.getHealth()-10);
		this.setLove(this.getLove()+5);
		System.out.println("健康值减少了10，新健康值："+this.getHealth()+
				"；亲密度增加了5，新亲密度："+this.getLove());
	}

}
