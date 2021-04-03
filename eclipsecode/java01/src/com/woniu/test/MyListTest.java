package com.woniu.test;

public class MyListTest {
	public static void main(String[] args) {
		MyList<String> myList=new MyList<>();
		myList.add("tom");
		myList.add("jack");
		myList.add("mike");
		System.out.println(myList.get(0));
		System.out.println(myList.get(1));
		System.out.println(myList.get(2));
	}

}
