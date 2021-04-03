package com.woniu.chapter999;
interface Aa { 

 // 1.8之后静态方法 
	 public static void method() { 
		 System.out.println("A method(接口Aa的静态方法) - ---"); 
		 }
	//1.8之后默认方法
	  public default void method2() { 
		  System.out.println("A method2(接口Aa的默认方法) ---- "); 
		  }
}
class Basee {
 public void method2() { 
	 System.out.println("Base method2(父类的方法) ---- "); 
	 } 
 }
class Subb extends Basee implements Aa { 
	 
//	 public void method2() { 
//        System.out.println("Sub method2(子类Subb重写了method2()方法) ----"); 
//	  } 
}

public class Test05 {
	public static void main(String[] args) {
		Subb subb = new Subb();
		subb.method2();
	}

}
