package com.woniu.chapter19_collectionWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
class Employee{
	String name;
	String id;
	int no;
	int salary;
	public Employee(String name, String id, int no, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.no = no;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", no=" + no + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		result = prime * result + salary;
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	
}
public class Work1 {
	
	@Test
	public void test5(){
		ArrayList<String> lets = new ArrayList<>();
		lets.add("z");
		lets.add("b");
		lets.add("z");
		lets.add("a");
		lets.add("h");
		lets.add("a");
		lets.add("t");
		lets.add("c");
		for(int i=0;i<lets.size();i++) {
			String str = lets.get(i);
			if("a".equals(str)) {
				lets.remove(i);
				i--;
			}
		}
		System.out.println(lets);
	}
	@Test
	public void test4(){
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee("admin","0001",0,10000));
		list.add(new Employee("jack","0002",0,2000));
		list.add(new Employee("admin","0001",0,10000));
		list.add(new Employee("jerry","0001",0,10000));
		list.add(new Employee("tom","0004",0,5000));
		ArrayList<Employee> emps = new ArrayList<>();
		for(Employee e:list) {
			if(emps.contains(e)) 
				continue;
			emps.add(e);
				
		}
		System.out.println(emps);
	}
	@Test
	public void test3(){
		ArrayList<String> lets = new ArrayList<>();
		lets.add("z");
		lets.add("b");
		lets.add("z");
		lets.add("h");
		lets.add("总");
		lets.add("a");
		lets.add("f");
		lets.add("总");
		lets.add("a");
		lets.add("陕总");
		System.out.println(lets);
		//使用Set集合去重
		Set<String> letSet = new HashSet<>(lets);
		System.out.println(letSet);
//		//removeRange?
//		lets.remove(3);
//		lets.remove(3);
//		System.out.println(lets);
//		lets.removeIf(t->t.equals("a"));
//		System.out.println(lets);
	}
	@Test
	public void test2(){
		Map<String,Integer> scores = new HashMap<>();
		scores.put("1001号", 98);
		scores.put("1002号", 95);
		scores.put("1003号", 93);
		scores.put("1004号", 67);
		scores.put("1005号", 56);
		System.out.println(scores);
		Set<Entry<String,Integer>> scoreSet = scores.entrySet();
		System.out.println("-------方式1-------");
		Iterator<Entry<String,Integer>> iterScore = scoreSet.iterator();
		while(iterScore.hasNext()) {
			Entry<String, Integer> scoreEntry = iterScore.next();
			String id = scoreEntry.getKey();
			Integer score = scoreEntry.getValue();
			System.out.println(id+"-"+score);
		}
		System.out.println("-------方式2-------");
		for(Entry<String,Integer> scoreEntry:scoreSet) {
			String id = scoreEntry.getKey();
			Integer score = scoreEntry.getValue();
			System.out.println(id+"-"+score);
		}
		
	}
	@Test
	public void test1(){
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("c");
		list.add("d");
		System.out.println(list);
		System.out.println("-------方式1-------");
		for(String let:list) {
			System.out.print(let+"\t");
		}
		System.out.println("\n-------方式2-------");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String let = iter.next();
			System.out.print(let+"\t");
		}
		System.out.println("\n-------方式3-------");
		for(int i = 0;i<list.size();i++) {
			System.out.print(list.get(i)+"\t");
		}
		
	}

}
