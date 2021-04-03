package com.woniu.chapter21_Thread;

public class Test {
	public static void main(String[] args) {
		//3.创建Thread子类的对象
		MyThread1 myt = new MyThread1();
		//4.通过此对象调用start()方法
		myt.start();
		//4.开启另一个线程
		MyThread1 myt2 = new MyThread1();
		myt2.start();
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"---"+i);
		}
	}

}
//1.创建继承Thread的子类
class MyThread1 extends Thread{
	//2.重写run方法
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(this.getName()+"---"+i);
		}
	}
}