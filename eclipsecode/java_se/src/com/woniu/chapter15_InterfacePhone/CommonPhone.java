package com.woniu.chapter15_InterfacePhone;

public class CommonPhone extends Phone implements PlayWiring,Network {
	
	public CommonPhone() {
		super();
	}

	public CommonPhone(String brand, String type) {
		super(brand, type);
	}

	@Override
	public void play(String content) {
		System.out.println("开始播放音乐："+content);
		
	}

	@Override
	public void sendInfo() {
		System.out.println("发送文字信息");
		
	}

	@Override
	public void call() {
		System.out.println("开始语音通话");
		
	}

	@Override
	public void networkConn() {
		System.out.println("功能不够，无法连接网络");
		
	}
	
	

}
