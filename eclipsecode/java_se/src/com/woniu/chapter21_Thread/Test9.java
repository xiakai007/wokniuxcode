package com.woniu.chapter21_Thread;
class Window6 extends Thread{
	private static int tickets = 100;

	@Override
	public void run() {
		while(true) {
			if(tickets<=0) {
				break;
			}
			print();//同步锁为Window6.class
		}
	}
	//print()方法改变为静态方法
	public static synchronized void print() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tickets>0) {
			System.out.println(Thread.currentThread().getName()+"票号为："+tickets--);
		}
	}
}
public class Test9 {
	public static void main(String[] args) {
		Window6 w1 = new Window6();
		w1.setName("窗口1");
		w1.start();
		Window6 w2 = new Window6();
		w2.setName("窗口2");
		w2.start();
		Window6 w3 = new Window6();
		w3.setName("窗口3");
		w3.start();
		Window6 w4 = new Window6();
		w4.setName("窗口4");
		w4.start();
		Window6 w5 = new Window6();
		w5.setName("窗口5");
		w5.start();
	}

}


