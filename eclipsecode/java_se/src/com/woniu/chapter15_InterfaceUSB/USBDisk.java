package com.woniu.chapter15_InterfaceUSB;

public class USBDisk implements IUSB {

	@Override
	public void service() {
		System.out.println("已连接USB接口，U盘开始传输数据");
		
	}

}
