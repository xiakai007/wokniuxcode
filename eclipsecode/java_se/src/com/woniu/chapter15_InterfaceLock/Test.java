package com.woniu.chapter15_InterfaceLock;

public class Test {
	public static void main(String[] args) {
		TheftproofDoor tpd = new TheftproofDoor();
		tpd.close();
		tpd.lockUp();
		tpd.takePictures();
		tpd.closeLock();
		tpd.open();
	}

}
