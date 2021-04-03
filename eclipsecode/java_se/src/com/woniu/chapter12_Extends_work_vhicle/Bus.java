package com.woniu.chapter12_Extends_work_vhicle;

public class Bus extends MotoVehicle {
	//座位
	private int seatCount;
	
	public Bus() {
		
	}
	public Bus(String no,int seatCount) {
		super(no);
		this.seatCount = seatCount;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	
	public int calRent(int days) {
		if(seatCount<=16) {
			return days*800;
		}else {
			return days*1500;
		}
	}

}
