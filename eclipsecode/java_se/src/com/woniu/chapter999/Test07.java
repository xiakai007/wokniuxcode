package com.woniu.chapter999;
class Super {
	int show(int a,int b){return 0;}
}
class Demo15 extends Super {
	static int show2(int a,int b){return 10;}
}
public class Test07 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Demo15 demo15 = new Demo15();
		System.out.println(demo15.show2(1, 2));
	}

}