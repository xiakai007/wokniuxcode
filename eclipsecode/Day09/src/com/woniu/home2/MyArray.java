package com.woniu.home2;

public class MyArray {
	private int capacity = 10;
	private String []str = null;
	private int index = 0;
	public MyArray() {
		super();
		str = new String[capacity];
	}
	public MyArray(int capacity) {
		super();
		this.capacity = capacity;
		str = new String[capacity];
	}
	public void add(String value) {
		if(index<str.length) {
			str[index++] = value;//追加形式
		}
		if(index==str.length) {
			index = 0;
		}
		
	}
	public String[] getStr() {
		return str;
	}

}
