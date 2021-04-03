package com.woniu.chapter15_InterfacePhone;

public class PhoneTest {
	public static void main(String[] args) {
		CommonPhone cph = new CommonPhone("G502c","索尼爱立信");
		cph.info();
		cph.play("《热雪》");
		cph.sendInfo();
		cph.call();
		cph.networkConn();
		System.out.println();
		
		SmartPhone sph = new SmartPhone("I9100","HTC");
		sph.info();
		sph.play("《小时代》");
		sph.takePictures();
		sph.sendInfo();
		sph.call();
		sph.networkConn();
	}

}
