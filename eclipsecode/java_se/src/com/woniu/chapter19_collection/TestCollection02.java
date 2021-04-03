package com.woniu.chapter19_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

class Student{
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
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
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
public class TestCollection02 {
	@Test
	public void test2() {
		LinkedList<String>llist = new LinkedList<>();
		llist.add("cc");
		llist.add("yy");
		llist.add("hh");
		llist.add("aa");
		String str1 = llist.peek();
		System.out.println(str1);
		String str2 = llist.peekFirst();
		System.out.println(str2);
		String str3 = llist.peekLast();
		System.out.println(str3);
	}
	@Test
	public void test1() {
		Collection<Integer> col = new ArrayList<>();
		col.add(2);
		col.add(5);
		col.add(9);
		col.add(-8);
		System.out.println(col);
		Collection<Integer>col2 = new ArrayList<>();
		col2.add(12);
		col2.add(54);
		col.addAll(col2);
		System.out.println(col);
		int i = 99;
		col.add(i);
		System.out.println(col);
//		col.clear();
		System.out.println(i);
		System.out.println(col.contains(54));
		List<Student> stu = new ArrayList<>();
		Student st = new Student("tom",22);
		stu.add(new Student("jack",45));
		stu.add(new Student("mike",12));
		stu.add(new Student("mery",33));
		stu.add(st);
		System.out.println(stu);
		stu.remove(new Student("mike",12));
		System.out.println(stu);
		System.out.println(stu.contains(st));
		System.out.println("------------1------------");
		List<Integer> listI = Arrays.asList(1,5,6,8,-6,-52);
		System.out.println(listI);
		col.removeIf(t->t==54);
		System.out.println(col);
		Iterator<Integer> iter = col.iterator();
		while(iter.hasNext()) {
			Integer no = iter.next();
			if(no==-8) {
				iter.remove();
			}
			System.out.println(no);
		}
		System.out.println(col);
		for(Integer no:col) {
			System.out.println(no);
		}
		
    }

}
