package com.woniu.chapter21_Thread;
class Print{
	private boolean flag = true;
	private int count = 1;
	
	public synchronized void printNum() {
		if(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(2*count-1);
		System.out.print(2*count);
		flag = false;
		notify();
	}
	
	public synchronized void printChar() {
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print((char)('A'+count-1));
		flag = true;
		count++;
		notify();
	}
	
}
public class Thread12A34B56C {
	public static void main(String[] args) {
		Print prt = new Print();
		new Thread(()->{
			for(int i=0;i<26;i++) {
				prt.printNum();
			}
		}).start();
		new Thread(()->{
			for(int i=0;i<26;i++) {
				prt.printChar();
			}
		}).start();
	}

}
