package com.woniu.chapter21_Thread;

import java.util.concurrent.locks.ReentrantLock;

class Windowd implements Runnable{
    private int tickets = 100;
    /*设置为true，则优先调用等待时间最长的线程*/
    private ReentrantLock rlock = new ReentrantLock(true);
    
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				//加锁
				rlock.lock();
				if(tickets>0) {
					System.out.println(Thread.currentThread().getName()+"票号为："+tickets--);
				}else {
					break;
				}
			}finally {
				//解锁
				rlock.unlock();
			}
		}
		
	}
}
public class Test10 {
	public static void main(String[] args) {
		Windowd wd = new Windowd();
		Thread t1 = new Thread(wd);
		t1.setName("窗口1");
		t1.start();
		Thread t2 = new Thread(wd);
		t2.setName("窗口2");
		t2.start();
		Thread t3 = new Thread(wd);
		t3.setName("窗口3");
		t3.start();
		Thread t4 = new Thread(wd);
		t4.setName("窗口4");
		t4.start();
		
	}

}
