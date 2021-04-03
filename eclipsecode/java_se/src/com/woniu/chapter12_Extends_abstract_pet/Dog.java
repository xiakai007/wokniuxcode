package com.woniu.chapter12_Extends_abstract_pet;

public class Dog extends Pet {
	//品种
	private String strain;

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	

	public Dog() {
		
	}

	public Dog(String name,String strain) {
		this.setName(name);
		this.strain = strain;
	}
	//重写父类show()方法
	@Override//注解，判断方法名是否正确
	public void show() {
		System.out.print("宠物的自白\n我的名字叫"+this.getName()+",健康值是"+this.getHealth()+",和主人的亲密度是"+this.getLove()+",我是一只"+strain+"。\n");
	}

	@Override
	public void eat() {
		if(this.getHealth()>=100) {
			System.out.println("狗狗"+this.getName()+"吃饱了，不需要喂食了");
			
		}else {
			this.setHealth(this.getHealth()+3);
			System.out.println("狗狗"+this.getName()+"吃饱了！健康值增加3");
			
		}
	}
	public void catchingFlyDisc() {
		System.out.println("狗狗"+this.getName()+"正在接飞盘");
		this.setHealth(this.getHealth()-10);
		this.setLove(this.getLove()+5);
		System.out.println("健康值减少了10，新健康值："+this.getHealth()+
				"；亲密度增加了5，新亲密度："+this.getLove());
	}

}
