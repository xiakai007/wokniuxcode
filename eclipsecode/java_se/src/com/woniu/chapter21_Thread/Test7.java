package com.woniu.chapter21_Thread;
class Window4 implements Runnable{
    private int tickets = 100;
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(this) {
				if(tickets<=0) {
					break;
				}
				System.out.println(Thread.currentThread().getName()+"票号为："+tickets--);
			}
			
		}
		
	}
	
}
public class Test7 {
	public static void main(String[] args) {
		Window4 wd = new Window4();
		Thread t1 = new Thread(wd);
		t1.setName("窗口1");
		t1.start();
		Thread t2 = new Thread(wd);
		t2.setName("窗口2");
		t2.start();
		Thread t3 = new Thread(wd);
		t3.setName("窗口3");
		t3.start();
		
	}

}
