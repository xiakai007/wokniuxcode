package com.woniu.chapter12_Extends_abstract_pet;

public class Cat extends Pet {
	public Cat(String name) {
		super(name);
	}

	@Override
	public void show() {
		System.out.print("宠物的自白\n我的名字叫"+this.getName()+",健康值是"+this.getHealth()+",和主人的亲密度是"+this.getLove()+"\n");
		
	}

	@Override
	public void eat() {
		if(this.getHealth()>=100) {
			System.out.println("猫"+this.getName()+"吃饱了，不需要喂食了");
			
		}else {
			this.setHealth(this.getHealth()+2);
			System.out.println("猫"+this.getName()+"吃饱了！健康值增加2"+"，新健康值："+this.getHealth());
			
		}
		
	}

}
