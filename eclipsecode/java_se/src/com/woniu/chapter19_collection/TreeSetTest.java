package com.woniu.chapter19_collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;
class Studentt{
	String name;
	int age;
	public Studentt(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Studentt [name=" + name + ", age=" + age + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Studentt other = (Studentt) obj;
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	
}
public class TreeSetTest  {
	@Test
	public void test1() {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("cc");
		treeSet.add("yy");
		treeSet.add("hh");
		treeSet.add("aa");
		System.out.println(treeSet);
		
		TreeSet<Studentt> treeSet2  =new TreeSet<>(new Comparator<Studentt>() {

			@Override
			public int compare(Studentt o1, Studentt o2) {
				if(o1.age>o2.age) {//按年龄升序
					return 1;
				}else if(o1.age==o2.age) {
					return o1.name.compareTo(o2.name);//年龄相同时按名称升序
				}else {
					return -1;
				}
//				return o1.age-o2.age;
				
			}
		});
		treeSet2.add(new Studentt("tmd",22));
		treeSet2.add(new Studentt("tmd",22));
		treeSet2.add(new Studentt("hmd",22));
		treeSet2.add(new Studentt("amd",22));
		treeSet2.add(new Studentt("dmd",22));
		treeSet2.add(new Studentt("fmd",22));
		System.out.println(treeSet2);
	}
	
	

}
