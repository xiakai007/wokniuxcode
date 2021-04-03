package com.woniu.reflect;

public class MyJSONObjectTest {
	public static void main(String[] args) {
		Goods goods = new Goods(1, 2, 3, "k01", "hhh", 102, 52.2f, "pop", "fff");
		MyJSONObject goodsMyJO=new MyJSONObject(goods);
		System.out.println(goodsMyJO);
		Users user=new Users(1,"tom", "123456","qwe","tjtydhgf");
		MyJSONObject userMyJO=new MyJSONObject(user);
		System.out.println(userMyJO);
	}

}
