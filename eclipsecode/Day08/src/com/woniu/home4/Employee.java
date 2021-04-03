package com.woniu.home4;
/**
 * public 公开的
 * @author xiakai
 *
 */
public class Employee {
	public String name;
	public String eno;
	public char gender;
	public int age;
	public float salary;
	public void info() {
		System.out.println("大家好，我叫"+name+"，工号"+eno+"，性别"+gender+
				"，今年"+age+"岁，薪资¥："+salary+"，"+identify(salary));
	} 
	public String identify(float salary) {
		if(salary >20000) {
			return "我是金领";
		}else if(salary >10000) {
			return "我是白领";
		}else if(salary >5000) {
			return "我是蓝领";
		}else {
			return "工资太低，无法判断";
		}
	}

}
