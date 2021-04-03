package com.woniu.chapter21_Thread;

class Windowe{
	private int tickets = 100;
	public void sell() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(this) {
				if(tickets<=0) {
					break;
				}
				System.out.println(Thread.currentThread().getName()+"票号："+tickets--);
				
			}
		}
	}
}

public class Test14 {
	public static void main(String[] args) {
		Windowe win = new Windowe();
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				win.sell();
			},"消费者"+i).start();
		}
	}

}
