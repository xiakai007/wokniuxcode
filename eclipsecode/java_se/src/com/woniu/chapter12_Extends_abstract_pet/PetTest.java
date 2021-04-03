package com.woniu.chapter12_Extends_abstract_pet;

import java.util.Scanner;

public class PetTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("欢迎来到宠物商店\n\"请选择领养的宠物（1、狗 狗， 2、企鹅）：");
		String typeId = sc.next();
		
//		Dog dog = new Dog("欧欧","雪纳瑞");
//		dog.show();
//		Penguin peng = new Penguin("楠楠","Q妹");
//		peng.show();
//		Master master = new Master("主人",100);
//		master.feed(dog);
//		master.feed(peng);
//		Cat cat = new Cat("QQ");
//		master.feed(cat);
		
//		Master master1 = new Master();
		Master master = new Master("主人",100);
		Pet pet = master.getPet(typeId);
		pet.setHealth(80);
		pet.setLove(90);
		//分别调用喂食方法和玩耍方法
		master.feed(pet);//多态，feed()调用eat()为同一个方法，使用相同方法因传递实现不同而体现出不同特性
		master.play(pet);//非多态，play()调用两个不同的方法，不是多态
		sc.close();
	}

}
