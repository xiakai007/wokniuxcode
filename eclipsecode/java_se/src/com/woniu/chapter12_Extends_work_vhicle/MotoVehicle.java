package com.woniu.chapter12_Extends_work_vhicle;

public class MotoVehicle {
	private String no;
	private String brand;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public MotoVehicle() {
		
	}
    public MotoVehicle(String no) {
		this.no = no;
	}
    public MotoVehicle(String no,String brand) {
		this.no = no;
		this.brand = brand;
	}
    public int calRent(int days) {
    	return days;
    }

}
