package com.woniu.chapter21_Thread;
class Number{
	private int j;
	public void print() {
		synchronized(this) {
			if(Thread.currentThread().getName().equalsIgnoreCase("add")) {
				j++;
				System.out.println(Thread.currentThread().getName()+":"+j);
			}else {
				j--;
				System.out.println(Thread.currentThread().getName()+":"+j);
			}
		}
	}
}
class NumbThread extends Thread{
	private Number num;
	public NumbThread(Number num) {
		this.num = num;
	}
	@Override
	public void run() {
		num.print();
	}
}
public class TestJ {
	/*定义int类型变量j，有4个线程对其操作，
	 * 其中两个线程每次对j增加1，另外两个线程对
	 * j每次减少1。请写出程序，要求利用同步机制
	 * 防止多线程对并发j操作引起数据错误
	 * */
	public static void main(String[] args) {
		Number number = new Number();
		NumbThread numth1 = new NumbThread(number);
		numth1.setName("add");
		NumbThread numth2= new NumbThread(number);
		numth2.setName("add");
		NumbThread numth3 = new NumbThread(number);
		numth3.setName("minu");
		NumbThread numth4 = new NumbThread(number);
		numth4 .setName("minu");
		numth1.start();
		numth2.start();
		numth3.start();
		numth4.start();
		
	}

}
