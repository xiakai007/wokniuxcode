package com.woniu.chapter21_Thread;

import java.util.concurrent.locks.ReentrantLock;

class Windoe extends Thread{
	private static int tickets=100;
	private static ReentrantLock rlock = new ReentrantLock();
	public Windoe(String name) {
		super(name);
	}
	@Override
	public void run() {
		sell();
	}
	public static void sell() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				rlock.lock();
				if(tickets>0) {
					System.out.println(Thread.currentThread().getName()+"售出票号："+tickets--);
				}else {
					break;
				}
			}finally {
				rlock.unlock();
			}
		}
		
	}
}

public class Test13 {
	public static void main(String[] args) {
		Windoe w1 = new Windoe("窗口1");
		w1.start();
		Windoe w2 = new Windoe("窗口2");
		w2.start();
		Windoe w3 = new Windoe("窗口3");
		w3.start();
	}

}
