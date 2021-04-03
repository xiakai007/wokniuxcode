package com.woniu.home4;

public class Test2 {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		System.out.println("c1:"+c1);
		c1.setAge(18);
		Customer c2 = new Customer();
		System.out.println("c2:"+c2);
		c2.setAge(28);
		System.out.println(c1.getAge());
		System.out.println(c2.getAge());
	}

}
