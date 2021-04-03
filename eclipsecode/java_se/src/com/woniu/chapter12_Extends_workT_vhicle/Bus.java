package com.woniu.chapter12_Extends_workT_vhicle;

public class Bus extends MotoVehicle {
	private int seatCount;
	
	public Bus() {
		
	}
	public Bus(String no,int seatCount) {//String brand,
		super(no);
		this.seatCount = seatCount;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	@Override
	public int calRent(int days) {
		if(seatCount<=16) {
			return days*800;
		}else {
			return days*1500;
		}
	}
	

}
