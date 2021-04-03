package com.woniu.chapter15_InterfacePhone;

public abstract class Phone {
	public String brand;
	public String type;

	public Phone() {
	}
	
	public Phone(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract void sendInfo();
	public abstract void call();
	public void info() {
		System.out.println("这是一款型号为"+type+"的"+brand+"手机：");
	};

}
