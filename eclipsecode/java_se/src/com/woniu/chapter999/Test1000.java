package com.woniu.chapter999;

class Base {
	int count = 10;

	public void display() {
		System.out.println("base display()" + this.count);
	}
}

class Sub extends Base {
	int count = 20;

	@Override
	public void display() {
		System.out.println(super.count); // 输出父类Base中的10
		System.out.println("sub display() " + this.count);// 输出子类Sub中的20
	}
}

public class Test1000 {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.display();// 10   sub display() 20
		Base base = sub; // 上行
		System.out.println(base == sub); // true
		base.display();// 10   sub display() 20 子类重写父类方 法
		System.out.println(base.count); // 10 父类属性沒有重写
		System.out.println(((Sub) base).count); // 20
	}

}
