package com.woniu.test;

public class Student<T> {
	private T name;
	private T code;
	public Student() {
		super();
	}
	public Student(T name, T code) {
		super();
		this.name = name;
		this.code = code;
	}
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}
	public T getCode() {
		return code;
	}
	public void setCode(T code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", code=" + code + "]";
	}
	

}
