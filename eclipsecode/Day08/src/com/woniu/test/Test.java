package com.woniu.test;

import com.woniu.home4.Customer;

public class Test {
	public static void main(String[] args) {
		Customer cu = new Customer();
		cu.setAge(18);
		System.out.println(cu.getAge());
//		System.out.println(cu.name);无法访问
	}

}
