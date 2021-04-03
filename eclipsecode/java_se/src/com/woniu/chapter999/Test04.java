package com.woniu.chapter999;

public class Test04 {
	class Value {
		int i = 15;

	}
	public static void main(String[] args) {
		Test04 t = new Test04();
		t.first();
	}
	public void first() {
		int i = 5;
		Value v = new Value();
		v.i = 25;
		second(v,i);
		System.out.println("v.i 1="+v.i);
	}
	public void second(Value v,int i) {
		i = 0;
		v.i = 20;
		Value val = new Value();
		v = val;
		System.out.println("v.i 2="+v.i + ",i=" + i);
	}

}
