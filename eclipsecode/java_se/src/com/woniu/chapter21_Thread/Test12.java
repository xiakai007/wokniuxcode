package com.woniu.chapter21_Thread;

import java.util.concurrent.locks.ReentrantLock;

class Window8 implements Runnable{
    private int tickets = 100;
    private ReentrantLock rlock = new ReentrantLock(true);
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
//			try {
				rlock.lock();
				notify();
				if(tickets<=0) {
					break;
				}
				System.out.println(Thread.currentThread().getName()+"票号为："+tickets--);
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			finally {
//				rlock.unlock();
//			}
		
		
//			synchronized (this) {
//				notify();
//				if(tickets<=0) {
//					break;
//				}
//				
//				System.out.println(Thread.currentThread().getName()+"票号为："+tickets--);
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//			}
		
		
	}
}
public class Test12 {
	public static void main(String[] args) {
		Window8 wd = new Window8();
		Thread t1 = new Thread(wd);
		t1.setName("窗口1");
		t1.start();
		Thread t2 = new Thread(wd);
		t2.setName("窗口2");
		t2.start();
//		Thread t3 = new Thread(wd);
//		t3.setName("窗口3");
//		t3.start();
//		Thread t4 = new Thread(wd);
//		t4.setName("窗口4");
//		t4.start();
		
	}

}
