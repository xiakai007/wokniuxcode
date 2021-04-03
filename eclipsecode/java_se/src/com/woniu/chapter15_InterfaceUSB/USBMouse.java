package com.woniu.chapter15_InterfaceUSB;

public class USBMouse implements IUSB {

	@Override
	public void service() {
		System.out.println("已连接USB接口，鼠标正在移动");
		
	}

}
