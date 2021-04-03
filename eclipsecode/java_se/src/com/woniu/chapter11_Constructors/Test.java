package com.woniu.chapter11_Constructors;

public class Test {
	public static void main(String[] args) {
		Car car = new Car();
		Seller seller = new Seller();
		car.setType(Car.TYPE1);
		car.setID(Car.ID1);
		car.setNum(13);
		seller.setName(Seller.NAME);
		System.out.println(seller.getName()+"卖了"+car.getNum()+"辆"+car.getID()+"款"+car.getType());
		System.out.println(seller.getName()+"每次卖了一辆车。");
	}

}
