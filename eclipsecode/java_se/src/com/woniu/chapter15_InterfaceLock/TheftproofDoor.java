package com.woniu.chapter15_InterfaceLock;

public class TheftproofDoor extends Door implements ILock,IBell {

	@Override
	public void lockUp() {
		System.out.println("锁关上了");
		
	}

	@Override
	public void closeLock() {
		System.out.println("锁打开了");
		
	}

	@Override
	public void open() {
		System.out.println("门打开了");
		
	}

	@Override
	public void close() {
		System.out.println("门关上了");
		
	}

	@Override
	public void takePictures() {
		System.out.println("已拍照");
		
	}
	

}
