package com.woniu.chapter21_Thread;

class Clerk{
	private int goods = 0;
	public synchronized void addGoods() {
		if(goods<30) {
			goods++;
			System.out.println(Thread.currentThread().getName()
			+"：开始生产第"+goods+"个产品");
			notify();
		}else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized void getGoods() {
		if(goods>0) {
			System.out.println(Thread.currentThread().getName()
					+"：开始消费第"+goods +"个产品");
			goods--;
			notify();
		}else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Customer implements Runnable{
	Clerk clerk;
	
	public Customer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		System.out.println("消费者开始消费产品：");
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.getGoods();
			
		}
	}
}

class Productor implements Runnable{
	Clerk clerk;
	
	public Productor(Clerk clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("生产者开始生产产品：");
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.addGoods();
			
		}
	}
	
}

public class TestThread {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor prod = new Productor(clerk);
		Thread pdt = new Thread(prod);
		pdt.setName("生产者");
		pdt.start();
		Customer cust = new Customer(clerk);
		Thread ctm = new Thread(cust);
		ctm.setName("消费者");
		ctm.start();
	}

}
