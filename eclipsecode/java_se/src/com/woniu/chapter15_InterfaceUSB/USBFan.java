package com.woniu.chapter15_InterfaceUSB;

public class USBFan implements IUSB {

	@Override
	public void service() {
		System.out.println("已连接USB接口，风扇开始转动");
		
	}

}
