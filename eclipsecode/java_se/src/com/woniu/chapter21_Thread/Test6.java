package com.woniu.chapter21_Thread;
class Window3 extends Thread{
	private static int tickets = 100;
	public static Object obj = new Object();

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			Class clazz = Window3.class;
//			synchronized(clazz) {}//也可作为锁
			synchronized(obj) {
				if(tickets<=0) {
					break;
				}
				System.out.println(this.getName()+"票号为："+tickets--);
			}
			
		}
	}
}
public class Test6 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		w1.setName("窗口1");
		w1.start();
		Window3 w2 = new Window3();
		w2.setName("窗口2");
		w2.start();
		Window3 w3 = new Window3();
		w3.setName("窗口3");
		w3.start();
	}

}

