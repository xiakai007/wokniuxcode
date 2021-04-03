package com.woniu.chapter19_collection;

import java.util.ArrayList;

public class WorkArrayList {
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("学生一");
		strList.add("学生二");
		strList.add("学生三");
		strList.add("学生四");
		strList.add("学生五");
		strList.add("学生六");
		strList.add("学生七");
		strList.add("学生八");
		strList.add("学生九");
		strList.add("学生十");
		strList.add("学生X");
		System.out.println(strList);
		strList.add(2, "关羽");
		System.out.println(strList);
		System.out.println(strList.get(5));
		strList.remove(6);
		System.out.println(strList);
		strList.set(7, "7-修改");
		System.out.println(strList);
	}

}
