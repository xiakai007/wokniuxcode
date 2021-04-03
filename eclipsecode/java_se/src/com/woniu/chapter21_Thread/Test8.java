package com.woniu.chapter21_Thread;
class Window5 implements Runnable{
    private int tickets = 100;
	@Override
	public void run() {
		while(true) {
			/*当剩1张票时，三个线程均执行if(tickets<=0){break;}， 执行完毕后
			 *在含锁的print()方法处排队等待，同步锁为this，三个线程执行print()方法
			 *完毕后才会消失，如果print()方法没有tickets>0限制，必然会有票号0、-1和-2出现*/
			System.out.println("当前待售票号为："+tickets);//如果print()方法没有tickets>0限制，票号-3出现
			if(tickets<=0) {
				break;
			}
			print();//同步锁为this
		}
		
	}
	public synchronized void print() {
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tickets>0) {
			System.out.println(Thread.currentThread().getName()+"票号为："+tickets--);
		}
	}
	
}
public class Test8 {
	public static void main(String[] args) {
		Window5 wd = new Window5();
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
