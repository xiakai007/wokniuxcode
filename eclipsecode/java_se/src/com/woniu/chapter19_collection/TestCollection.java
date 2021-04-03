package com.woniu.chapter19_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

class Person implements Comparable<Person>{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
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
		Person other = (Person) obj;
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
	public int compareTo(Person o) {
		if(this.age > o.age) {//按年龄升序
			return 1;
		}else if(this.age == o.age) {
			return this.name.compareTo(o.name);//年龄相同时按名称升序
		}else {
			return -1;
		}
	}
	
}
public class TestCollection {
	@Test
	public void test1() {
		/*Collection根接口只能调用实现类ArrayList重写（实现）的方法，
		 * 不能调用ArrayList特有的方法*/
		Collection<String> coll = new ArrayList<>();
		//1.add(E e)方法：往集合中添加元素
		coll.add("vv");
		coll.add("ee");
		coll.add("rr");
		coll.add("aa");
		String str2 = coll.toString();
		System.out.println(str2);
		//2.addAll(E e)方法：将集合中的所有元素放入指定集合中
		Collection<String> coll2 = new ArrayList<>();
		coll2.add("kk");
		coll2.add("yy");
		coll2.add("cc");
		coll.addAll(coll2);
//		coll.add(coll2);//coll的泛型改为Object后，集合coll2整体作为新元素添加至coll中：[vv, ee, rr, aa, kk, yy, cc, [kk, yy, cc]]
		System.out.println(coll);//输出顺序为添加的顺序
		//3.clear()方法：清空元素
		String str = "xyz";
		coll.add(str);//往集合中添加新元素
		System.out.println(coll);
		coll.clear();//清空
		System.out.println(coll);
		System.out.println(str);//清空后str仍然存在
	}
	@Test
	public void test2() {
		//contains(Object o)方法,判断是否包含指定元素
		Collection<String> coll = new ArrayList<>();
		coll.add("vv");
		coll.add("ee");
		coll.add("rr");
		coll.add("aa");
		Collection<String> coll2 = new ArrayList<>();
		coll2.add("ee");
		coll2.add("rr");
		System.out.println(coll.contains("ee"));//true
		Collection<Person> personColl = new ArrayList<>();
		Person p1 = new Person("tom",20);
		personColl.add(new Person("jack",22));
		personColl.add(p1);
		personColl.add(new Person("mike",18));
		System.out.println(personColl);
		personColl.remove(new Person("mike",18));
		System.out.println(personColl);
		//true，默认调用object的equals方法，==，所以true
		System.out.println(personColl.contains(p1));
		//false，默认调用object的equals方法，==，重写之前为false，重写后为true，一般都会重写
		System.out.println(personColl.contains(new Person("jack",22)));
		//containsAll(Collection<?> c)方法,判断所有元素是否相同，只看元素不管顺序
	}
	@Test
	public void test3() {
		/*1、可变参数，可以传递多个值或数组 2、一个方法只能有一个可变参数，并且位置最后*/
		// 多个值
		List<String> list = Arrays.asList("jack","tom");
		System.out.println(list);
		//基本类型数组
		List<int []> listInt = Arrays.asList(new int[] {1,2,3});
		/*Arrays.asList生成的对象ArrayList和new ArrayList生成的对象不同：
		 * Arrays.asList生成的对象不能打点调add()方法，编译通过运行报错，为其私有内部类；
		 * new ArrayList生成的对象可以打点调add()方法，
		 * */
		System.out.println(listInt);//地址
		System.out.println(listInt.size());//基本类型数组整体作为集合中的一个元素
		
		//包装类型数组
		List<Integer> listInteger = Arrays.asList(new Integer[] {1,2,3});
		System.out.println(listInteger.size());//包装类型数组或引用类型数组元素即为集合中的元素
		System.out.println(listInteger);
	}
	@Test
	public void test4() {
		Collection<String> coll = new ArrayList<>();
		coll.add("tom");
		coll.add("mike");
		coll.add("jack");
		coll.add("mery");
		System.out.println(coll.hashCode());
		
//		coll.remove(new String("tom"));
//		System.out.println(coll);
		
//		coll.removeAll(Arrays.asList("tom","asc","jack","uty"));//--- 删除参数集合中相同的元素 --- 差集
		coll.retainAll(Arrays.asList("tom","asc","jack","uty"));//--- 根据指定的集合保留相同的元素 --- 交集
		System.out.println(coll);
		//removeIf(Predicate<? super E> filter) 
		//Predicate --  boolean test(T t);
		coll.removeIf(t->t.equals("mery"));
		System.out.println(coll);
	}
	@Test
	public void test5() {
		Collection<String> coll = new ArrayList<>();
		coll.add("tom");
		coll.add("mike");
		coll.add("jack");
		coll.add("mery");
		Collection<String> coll2 = new ArrayList<>();
		coll2.add("tom");
		coll2.add("mery");
		coll2.add("jack");
		coll2.add("mike");
		//equals集合元素必须顺序相同，元素相同,个数相同
		System.out.println(coll.equals(coll2));//false
		System.out.println(coll.equals(Arrays.asList(
				new String[] {"tom","mike","jack","mery"})));//true
		System.out.println(coll.equals(123));//false
		
	}
	@Test
	public void test6() {
		Collection<String> coll = new ArrayList<>();
		coll.add("tom");
		coll.add("mike");
		coll.add("jack");
		coll.add("mery");
		//iterator()迭代获取集合中的元素
		//hasNext(),判断是否有元素，有返回true；E next(),返回下一个元素，类型为E
		Iterator<String> iter = coll.iterator();
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());
//		System.out.println(iter.next());
		while(iter.hasNext()) {
			String str = iter.next();
			if(str.equals("jack")) {
				iter.remove();//删除jack
			}
			System.out.println(str);
		}
		System.out.println(coll);
		for (String str : coll) {
			System.out.println(str);
		}
//		//错误  .next就会移动指针
//		while(iter.next()!=null) {
//			System.out.println(iter.next());
//		}
		//错误,每iterator就会得到一个新的迭代器，导致死循环
//		while(coll.iterator().hasNext()) {
//			System.out.println(coll.iterator().next());
//		}
		
	}
	@Test
	public void test7() {
		ArrayList<Person> personColl = new ArrayList<>();
		Person p1 = new Person("tom",20);
		personColl.add(new Person("jack",22));
		personColl.add(p1);
		personColl.add(new Person("mike",18));
		System.out.println(personColl);
		personColl.remove(new Person("mike",18));
		System.out.println(personColl);
	}
}
