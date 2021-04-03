package com.woniu.demo;

public class StringDemo2 {
	public static void main(String[] args) {
		String s1 = "上海";
		String s2 = "上海";
		System.out.println(s1==s2);
		String s4 = new String("上海");
		System.out.println(s4);
		System.out.println(s1==s4);//new使对象地址不一样，false
		boolean flag = s1.equals(s4);//比较内容
		System.out.println(flag);
		String s6 = "shanghai";
		String s7 = "SHANGHAI";
		boolean flag2 = s6.equalsIgnoreCase(s7);//忽略大小写
		System.out.println(flag2);
	}

}
