package com.woniu.annotations;

public class NoBug {
	@NoBugCheck
	public void add(int a,int b){
		System.out.println("求和："+(a+b));
	}
	@NoBugCheck
	public void div(int a,int b){
		System.out.println("求商："+(a/b));
	}
	@NoBugCheck
	public void subt(int a,int b){
		System.out.println("求差："+(a-b));
	}

}
