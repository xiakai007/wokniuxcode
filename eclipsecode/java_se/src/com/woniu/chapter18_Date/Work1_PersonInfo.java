package com.woniu.chapter18_Date;

import java.util.Date;

class Person{
	int id;
	String gender;
	String name;
	int age;
	String huKou;
	Date birthday;
	
	public Person() {
		super();
	}
	public Person(int id, String name, String huKou) {
		super();
		this.id = id;
		this.name = name;
		this.huKou = huKou;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", huKou=" + huKou + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
public class Work1_PersonInfo {
	public static void main(String[] args) {
		Person pn1 = new Person(610231,"tom","陕西西安");
		Person pn2 = new Person(610231,"ton","陕西西安");
		if(pn1.equals(pn2)) {
			System.out.println("对象相等");
		}else {
			System.out.println("对象不相等");
		}
	}

}
