package com.woniu.chapter14_PackaingObject;

public class Test03 {
	String name;
	int age;
	public Test03() {
//		super();
	}
	public Test03(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test03 other = (Test03) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Test03 [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		Test03 t1 = new Test03("张三",20);
		System.out.println(t1);
		Test03 t2 = new Test03("张三",20);
		System.out.println(t1==t2);//地址不一样
		System.out.println(t1.equals(t2));//重写了equals方法
	}
	

}
