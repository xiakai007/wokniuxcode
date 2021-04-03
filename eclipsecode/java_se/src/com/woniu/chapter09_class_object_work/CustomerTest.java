package com.woniu.chapter09_class_object_work;

public class CustomerTest {
	public static void main(String[] args) {
		Customer cus = new Customer();
		cus.score = 1000;
		cus.type = "普卡";
		cus.show();
		Customer cus2 = new Customer();
		cus2.score = 3000;
		cus2.type = "金卡";
		cus2.show();

	}

}
