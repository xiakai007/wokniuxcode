package com.woniu.chapter14_PackaingObject;

public class Test {
	public static void main(String[] args) {
		//基本类型
		int i = 10;
		//自动装箱
		Integer i1 = new Integer(i);
		//1.5之后自动拆箱
		int i2 = i1;//int i2 = new Integer(i);
		System.out.println(i2);
		boolean flag = false;
		Boolean flag2 = new Boolean(flag);
		System.out.println(flag2);
		//Float f = new Float("a");报错，类型不一致
		Float f1 = new Float('a');//97.0
		System.out.println(f1);
		Character c = new Character('b');
		System.out.println(c);
		Double d = new Double(2.3);
		System.out.println(d.doubleValue());
		Boolean b = new Boolean(true);
		System.out.println(b.booleanValue());
		float f = 1.2f;
		Float f2 = f;
		System.out.println(f2);
		//String类型转包装类、基本类型
		//通过构造器实现
		Boolean b1 = new Boolean("true");
		System.out.println(b1);
		//通过静态方法实现
		int i3 = Integer.parseInt("12");//先自动装箱在自动拆箱
		//int i3 = Integer.parseInt("12.3");报错，12.3与int不一致
		System.out.println(i3);
		double d2 = Double.parseDouble("12.3");
		System.out.println(d2);
		//基本类型、包装类转String类型
		//方式一
		String str = String.valueOf(true);
		//方式二
		int i5 = 10;
		String str2 = i+"";
		
		Integer i6 = new Integer(12);
		String str3 = String.valueOf(i6);
		
		int i7 = 65;
		double d3 = 65.0;
		Double d4 = 65.0;
		System.out.println(i7==d3);
		System.out.println(i7==d4);
		System.out.println(d3==d4);
		System.out.println("-----1-----");
		char c3= 'A';
		char c4 = 65;
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c3==i7);
		System.out.println(c4==i7);
		Character c1 = 65;
		Character c2 = 'A';
		System.out.println("-----2-----");
		System.out.println(c2.equals(c1));
		System.out.println(c1==c2);
		System.out.println("-----3-----");
		System.out.println(c1==i7);
		//i7为int类型，equals方法被重写，判断之后返回false
		System.out.println(c1.equals(i7));
	}

}
