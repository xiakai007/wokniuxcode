package com.woniu.chapter15_InterfacePhone;

public class SmartPhone extends Phone implements Network,Pictures,PlayWiring {
	
	public SmartPhone() {
		super();
	}

	public SmartPhone(String brand,String type) {
		//this();
		super(brand,type);
	}

	@Override
	public void play(String content) {
		System.out.println("开始播放视频："+content);
		
	}

	@Override
	public void takePictures() {
		System.out.println("拍照成功");
		
	}

	@Override
	public void networkConn() {
		System.out.println("启动移动网络");
		
	}

	@Override
	public void sendInfo() {
		System.out.println("发送带图片和文字的信息");
		
	}

	@Override
	public void call() {
		System.out.println("开始视频通话");
		
	}

}
