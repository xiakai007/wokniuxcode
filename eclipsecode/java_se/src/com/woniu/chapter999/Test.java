package com.woniu.chapter999;

import java.util.Arrays;

public class Test {
		
		String str = new String("good");
		char[] ch = {'t','e','s','t'};
		int i = 10;
		
		public void change(String str, char[] ch, int i) {
			//str形参，接受的地址
			str = new String("good body"); //因为字符串的不可变性，会创建新的字符串对象,不会影响原字符串
			//ch形参，接受地址
			System.out.println(Arrays.toString(ch));
			ch[0] = 'b'; //通过地址更改原来的数据
			System.out.println(Arrays.toString(ch));
			i = 100;
		}
		public static void main(String[] args) {
			Test t = new Test();
			
			t.change(t.str, t.ch, t.i);
			
			System.out.println(t.str); //good
			System.out.println(t.ch); //best
			System.out.println(t.i); //10
		}

	
}
