package com.woniu.chapter17_outer_inner_lambda;

public class Persoon implements Comparable<Persoon> {
	private String name;
	private int age;
	public Persoon() {
		super();
	}
	public Persoon(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Persoon o) {
		return -Integer.compare(this.age,o.age);//按年龄降序
	}
	@Override
	public String toString() {
		return "Persoon [name=" + name + ", age=" + age + "]";
	}
	

}
