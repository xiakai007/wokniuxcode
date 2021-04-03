package com.woniu.home4;
//创建一张空员工工牌
public class Test {
	String str = "陕西西安";
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.name = "张三";
		employee.eno = "1007";
		employee.gender = '男';
		employee.age = 26;
		employee.salary = 5001;
		employee.info();
		System.out.println(employee.identify(500));
		Test test = new Test();
		System.out.println(test.str);
	}
}
