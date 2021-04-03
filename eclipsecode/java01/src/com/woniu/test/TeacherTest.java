package com.woniu.test;

public class TeacherTest {
	public static void main(String[] args) {
		Teacher<String,Integer> tch=new Teacher<String,Integer>();
		tch.setId(1);
		tch.setName("jack");
		System.out.println(tch.getId());
		System.out.println(tch.getName());
		String str="wwwwwwwwwww";
		tch.test(str);
	}

}
