package com.woniu.chapter21_Thread;

import java.util.HashSet;
import java.util.Set;

class Numbers implements Runnable{
	Set<Integer> itgSet1 = new HashSet<>();
	Set<Integer> itgSet2 = new HashSet<>();
	@Override
	public void run() {
		for (int i = 0; i <= 50; i++) {
			if(i%2==0) {
				itgSet1.add(i);
			}else {
				itgSet2.add(i);
			}
		}
		System.out.println("偶数有："+itgSet1);
		System.out.println("奇数有："+itgSet2);
		System.out.println(Thread.currentThread().getName());
	}
	
}
public class TestR {
	public static void main(String[] args) {
		Numbers nu = new Numbers();
		Thread th = new Thread(nu);
		th.start();
		Thread th2 = new Thread(nu);
		th2.start();
	}

}
