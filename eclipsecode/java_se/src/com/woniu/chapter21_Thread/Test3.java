package com.woniu.chapter21_Thread;

public class Test3 {
	public static void main(String[] args) {
		 //分线程
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(10);//停止时间后自动唤醒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(this.getName()+","+this.getPriority()+":"+i);
					if(i%10==0) {
						System.out.println("------yield------");
						yield();//将执行权限交给CPU，重新分配，但有可能重新分给自己
					}
				}
			}
		};
		t1.setName("分线程");
		t1.start();
//		
		Thread.currentThread().setName("主线程");
		for(int i = 0; i < 100; i++) {
			if(i%2!=0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+","+Thread.currentThread().getPriority()+":"+i);
				
			}
//			if(i==20) {
//				try {
//					t1.join();//让步线程：主线程停止运行，分线程t1执行至运行结束，唤醒主线程继续执行
//					System.out.println(t1.isAlive());//false
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println("---------main---------");
	}

}
