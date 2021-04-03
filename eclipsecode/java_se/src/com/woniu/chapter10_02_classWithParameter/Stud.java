package com.woniu.chapter10_02_classWithParameter;
/**
 * 学生类
 */
public class Stud {
	public int id;
	public String name;
	public int age;
	public int score;
	public String gender;
	/**
	 * 展示学生各类信息
	 */
	public void showInfo() {
		System.out.println(id+"\t"+name+"\t"+gender+"\t"+age+"\t"+score);
	}

}

