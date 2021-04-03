package com.woniu.demo1;

public class Test {
	public static void main(String[] args) {
//		Consumer c1 = new Consumer();
//		Consumer c2 = new Consumer("张三",'男');
//		Consumer c3 = new Consumer(1007, "张三", '男', 18, new Date(), 666);
		Consumer cs = new Consumer();
		cs.setId(1007);
		cs.setName("张三");
		cs.setGender('男');
		cs.setAge(18);
//		cs.setBirthday();
		System.out.println(cs.getName());
		System.out.println(cs.getGender());
		
//		System.out.println(c2.getName());
//		System.out.println(c2.getGender());
		
	}

}
