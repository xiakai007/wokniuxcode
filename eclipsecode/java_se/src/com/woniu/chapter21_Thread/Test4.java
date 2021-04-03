package com.woniu.chapter21_Thread;
class Window extends Thread{
	private static int tickets = 100;
	public void run() {
		while(tickets>0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName()+"票号为："+tickets--);
		}
	}
}
public class Test4 {
	public static void main(String[] args) {
		Window w1 = new Window();
		w1.setName("窗口1");
		w1.start();
		Window w2 = new Window();
		w2.setName("窗口2");
		w2.start();
		Window w3 = new Window();
		w3.setName("窗口3");
		w3.start();
	}

}
