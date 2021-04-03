package com.woniu.chapter21_Thread;
class A extends Thread{
	Object obj;
	public A(Object obj){
		this.obj=obj;
	}
	@Override
	public void run() {
		synchronized(obj) {
			for(int i=1;i<=52;i++) {
				System.out.print(i);
				if(i%2==0) {
					obj.notify();
					if(i==52){
						break;
					}
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
class B extends Thread{
	Object obj;
	public B(Object obj) {
		this.obj=obj;
	}
	@Override
	public void run() {
		synchronized(obj) {
			for(int i='A';i<='Z';i++) {
				System.out.print((char)i);
				if(i=='Z'){
					break;
				}
				obj.notify();
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
public class Thread12A34B {
	public static void main(String[] args) {
		Object obj = new Object();
		A a = new A(obj);
		B b = new B(obj);
		a.start();
		b.start();
	}

}
