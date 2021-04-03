package com.woniu.chapter19_collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class MapTest {
	@Test
	public void test5() {
		List<Integer> list = new ArrayList<>();
		list.add(21);
		list.add(12);
		list.add(35);
		list.add(46);
		list.add(8);
		list.add(89);
		System.out.println(list);
		Collections.sort(list,  (o1,o2)->//lambda表达式，只有一条语句时大括号和return都可以省略
		     Integer.compare(o1, o2)
		);
		
	}
	@Test
	public void test4() {
		//1.创建输入流
		try(FileInputStream inp= new FileInputStream("myProp.properties")) {//自动关流
			//2.读取数据
			Properties pro = new Properties();
		    pro.load(inp);
		    String userN = pro.getProperty("userName");
		    String passW = pro.getProperty("passWord");
		    System.out.println(userN+"---"+passW);
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void test3() {
		HashMap<String,String> map = new HashMap<>();
		map.put("tom", "23");
		map.put("tom3", "25");
		map.put("tom2", "28");
		System.out.println(map);
		//删除key
		map.remove("tom2");
		System.out.println(map);
		//根据key获取value
		String value = map.get("tom3");
		System.out.println("value="+value);
		boolean keyExist = map.containsKey("tom");
		boolean valueExist = map.containsValue("25");
		System.out.println(keyExist+"---"+valueExist);
		//清空
		map.clear();
		System.out.println(map);
		
	}
	@Test
	public void test2() {
		TreeMap<Person,String> treeMap = new TreeMap<>((o1,o2)->{//lambda表达式
			if(o1.age>o2.age) {
				return 1;
			}else if(o1.age==o2.age) {
				return o1.name.compareTo(o2.name);
			}else {
				return -1;
			}
		});
		treeMap.put(new Person("tom",25), "D");
		treeMap.put(new Person("tom6",30), "C");
		treeMap.put(new Person("dtom",25), "B");
		treeMap.put(new Person("tomf",18), "A");
		System.out.println(treeMap);
	}
	@Test
	public void test1() {
		Map<String,Integer> map = new HashMap<>();
		map.put("gg", 123);
		map.put("dd", 256);
		map.put("aa", 498);
		//遍历所有的key和value
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println("key:"+key);
			System.out.println("value:"+value);
		}
		System.out.println("-----------1---");
		//遍历所有的value
		Collection<Integer> values = map.values();
		for(Integer value:values) {
			System.out.println(value);
		}
//		//遍历所有的value---2
//		Iterator<String> iter2 = map.keySet().iterator();
//		while(iter2.hasNext()) {
//			String key = iter2.next();
//			Integer value = map.get(key);
//			System.out.println(value);
//		}
		System.out.println("-----------2---");
		//遍历所有的entry
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		//1.迭代器遍历
		Iterator<Entry<String, Integer>> iterSet = entrySet.iterator();
		while(iterSet.hasNext()) {
			Map.Entry<String, Integer> entry = iterSet.next();
			//获取key
			String key = entry.getKey();
			//获取value
			Integer value = entry.getValue();
			System.out.println(key+"---"+value);
		}
		//2.增强for循环遍历
		for(Map.Entry<String, Integer> entry:entrySet) {
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
	}

}
