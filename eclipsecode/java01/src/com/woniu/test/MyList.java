package com.woniu.test;

public class MyList<E> {
	private Object[] container;
	private int defaultSize=10;
	private int size;
	public MyList() {
		container=new Object[defaultSize];
	}
	public void add(E e){
		container[size]=e;
		size++;
	}
	public E get(int index){
		Object obj=container[index];
		return (E)obj;
	}

}
