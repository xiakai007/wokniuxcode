package com.woniu.chapter19_collection;



import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class SetTest {
	@Test
	public void test() {
		HashSet<Person> set = new HashSet<>();
		Person p1 = new Person("tom",20);
		Person p2 = new Person("tom",20);
		set.add(p1);
		set.add(new Person("jack",16));
		set.add(p2);
		set.add(new Person("mike",8));
		System.out.println(set);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		TreeSet<Person> treeSet = new TreeSet<>();
		treeSet.add(p1);
		treeSet.add(p2);
		treeSet.add(new Person("jack",16));
		treeSet.add(new Person("mike",8));
		System.out.println(treeSet);
		
		
	}

}
