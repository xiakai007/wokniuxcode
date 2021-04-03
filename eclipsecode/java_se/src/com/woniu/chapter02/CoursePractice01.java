package com.woniu.chapter02;

public class CoursePractice01 {
	public static void main(String[] args) {
		int money = 1000;
		System.out.println(money);
		long l = 2000L;
		System.out.println(l);
		int number1 = 10;
		int number2 = 20;
		int number3 = number1+number2;
		System.out.println(number3);
		int number4 = 65;
		int number5 = number4-number3;
		System.out.println(number5);
		char ch1 = 'a';
		System.out.println(ch1);
		char ch2 = '男';
		System.out.println(ch2);
		char ch3 = 48014;
		System.out.println(ch3);
		char ch4 = '\"';
		System.out.println(ch4);
		char ch5 = '\u9999';
		System.out.println(ch5);
		char ch6 = '\u9996';
		System.out.println(ch6);
		//使用基本方式创建字符串，也是引用类型。可以使用点操作符调用方法
		String str1 = "abc";
		System.out.println(str1);
		//获取字符串的长度
		System.out.println(str1.length());
		//使用关键字new创建，表示是引用类型
		String str2 = new String("defg");
		System.out.println(str2);
		//获取字符串的长度
		System.out.println(str2.length());
		String str3 = 3.5f+"";
		System.out.println(str3);
		System.out.println(3+4+"HelloWorld");
		System.out.println("HelloWorld"+3+4);
		System.out.println("HelloWorld"+(3+4));
		System.out.println("HelloWorld"+'a'+3);//字符串+字符=新字符串
		System.out.println('a'+3+"HelloWorld");//字符串可以参与运算，转换为ASCII码
		String str = "10";
		int i = Integer.parseInt(str);
		System.out.println(i);
		//byte类型不能自动转换char类型
		//byte类型可以自动转换short类型
		//char类型不能自动转换short类型
		byte b = 37;
		short s = b;
		System.out.println(s);
		
		short s1 = 13;
		s1 = (short)(s1-2);//s1被提升为int类型，须强转为short类型
		
		byte b2 = 37;
		short s2 = 3;
		short s3 = (short)(b2+s2);  //b2+s2的结果为int类型，须强制转换，byte类型+short类型的结果为int类型
		System.out.println(s3);
		//实现一个数字加密器，加密规则是加密结果 =（整数 * 10 + 5）/ 2 + 3.14159加密结果仍为一整数
		int num = 100;
		int num2 = (num* 10 + 5)/ 2 + (int)3.14159;
		System.out.println(num2);
	}

}
