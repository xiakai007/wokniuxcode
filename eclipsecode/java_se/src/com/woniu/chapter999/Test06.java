package com.woniu.chapter999;
interface W {
	void print();
}
class Outer  {
	public void print(W a) {
		a.print();
	}
}
public class Test06 {
     public static void main(String[] args) {
		
		Outer outer = new Outer();

        //匿名内部类方式实现
		outer.print(new W() {
			@Override
			public void print() {
				System.out.println("-----------");
			}});
        //匿名内部类方式实现
		outer.print(new W() {

			@Override
			public void print() {
				System.out.println("===============");
			}});
	}

}
