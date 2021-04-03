package com.woniu.chapter17_outer_inner_lambda;
class Outer{
	private String info = "outer";
	
	public class Inner{
		private String info;
		public void print() {
			info = "inner";
			//在成员内部类中区分外外部结构
			System.out.println("Inner info:"+this.info);
			//外部类和内部类属性重名时，在内部类方法中访问外部类属性，类型打点加this属性
			System.out.println("Outer info:"+Outer.this.info);
		}
	}
	//使用内部类信息
	public void fun() {
		new Inner().print();
	}
}
public class Test {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.fun();//通过实例化的对象outer打点来调用fun()方法
		//实例化内部类对象:
		//1、如果成员变量内部类为非静态，则使用外部类对象打点new 内部类()实例化内部类对象/
		Outer.Inner inner = outer.new Inner();
		inner.print();//通过实例化的对象inner打点来调用print()方法
		
		//2、如果成员内部类为静态，则使用 new 外部类打点 内部类()
//		Outer.Inner inner2 = new Outer.Inner();
	}

}
