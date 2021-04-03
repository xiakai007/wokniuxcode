package com.woniu.chapter21_Thread;
class Windoww2 extends Thread{
	private static int tickets = 100;
	public Windoww2(String name) {
		super(name);
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(Window.class) {
				if(tickets==0) {
					System.out.println("票已售罄");
					break;
				}
				System.out.println(this.getName()+"售出票号："+tickets--);
				System.out.println("还剩余"+tickets+"张票");
			}
		}
	}
}
public class TestT2 {
	public static void main(String[] args) {
		Windoww2 wdw = new Windoww2("1号窗口");
		wdw.start();
		Windoww2 wdw2 = new Windoww2("2号窗口");
		wdw2.start();
		Windoww2 wdw3 = new Windoww2("3号窗口");
		wdw3.start();
		Windoww2 wdw4 = new Windoww2("4号窗口");
		wdw4.start();
	}

}