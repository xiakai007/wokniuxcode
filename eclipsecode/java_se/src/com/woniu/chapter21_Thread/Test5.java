package com.woniu.chapter21_Thread;
class Window2 implements Runnable{
    private int tickets = 100;
	@Override
	public void run() {
		while(tickets>0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"票号为："+tickets--);
		}
		
	}
	
}
public class Test5 {
	public static void main(String[] args) {
		Window2 w2 = new Window2();
		Thread t1 = new Thread(w2);
		t1.setName("窗口1");
		t1.start();
		Thread t2 = new Thread(w2);
		t2.setName("窗口2");
		t2.start();
		Thread t3 = new Thread(w2);
		t3.setName("窗口3");
		t3.start();
		
	}

}
