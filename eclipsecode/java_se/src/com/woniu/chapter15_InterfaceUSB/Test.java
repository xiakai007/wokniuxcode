package com.woniu.chapter15_InterfaceUSB;

public class Test {
	public static void main(String[] args) {
		//多态使用，调用相同方法service()
		IUSB usb = new USBFan();
		usb.service();
		usb = new USBDisk();
		usb.service();
		usb = new USBMouse();
		usb.service();
	}

}
