package com.woniu.chapter11_Constructors;

import java.util.Scanner;

public class PetTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Dog dog = new Dog();
		Penguin peng = new Penguin();
		System.out.println("欢迎您来到宠物店！");
		System.out.print("请输入要领养宠物的名字：");
		String name = sc.next();
		System.out.print("请选择要领养的宠物类型：（1、狗狗 2、企鹅）");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			dog.setName(name);
			dog.getName();
			System.out.print("请选择狗狗的品种：（1、聪明的拉布拉多犬 2、酷酷的雪纳瑞）");
			int no = sc.nextInt();
			System.out.print("请选择狗狗的健康值（1-100之间）：");
			int healN = sc.nextInt();
			dog.setHealth(healN);
			dog.getHealth();
			if (no == 1) {
				dog.setBreed("聪明的拉布拉多犬");
				dog.getBreed();
			} else if (no == 2) {
				dog.setBreed("酷酷的雪纳瑞");
				dog.getBreed();
			}
			dog.show();
			break;
		case 2:
			peng.setName(name);
			peng.getName();
			System.out.print("请选择企鹅的性别：（1、Q仔 2、Q妹）");
			int no1 = sc.nextInt();
			if (no1 == 1) {
				peng.setGender(Penguin.GENDER_MALE);
				System.out.println(peng.getGender());
			} else if (no1 == 2) {
				peng.setGender(Penguin.GENDER_FEMALE);
				System.out.println(peng.getGender());
			}
			peng.show();
			break;
		default:
			break;
		}
		sc.close();
	}

}
