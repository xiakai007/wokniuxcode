package com.woniu.chapter01;

public class Test {
	public static void main(String[] args) {
		int n = 10;
		int b = ++n + n++ + ++n;
		ShoppingList sl = new ShoppingList();
		sl.shoppingList();
		System.out.println("n:"+ ++n);
		System.out.println("b:"+b);
		sl.num = 100;
		System.out.println("num:"+sl.num);
	}

}
