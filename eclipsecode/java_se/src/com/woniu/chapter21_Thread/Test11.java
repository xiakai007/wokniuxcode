package com.woniu.chapter21_Thread;

class Window7 implements Runnable {
	private int tickets = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				// notify-wait,线程一、二交替打印数据
				notify();
				if (tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "票号为：" + tickets--);
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class Test11 {
	public static void main(String[] args) {
		Window7 wd = new Window7();
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
