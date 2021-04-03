package com.woniu.chapter15_Computer;

public class Computer {
	private CPU cpu;
	private HardDisk hardDisk;
	private RAM ram;
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	public void show() {
		System.out.println("计算机的信息如下：\nCPU的品牌是："
				+cpu.getBrand()+"\n硬盘容量是："+hardDisk.getCapacity()
				+"\n内存容量是："+ram.getSize());
	}	
	public void show2() {
		System.out.println("计算机的信息如下：\nCPU的品牌是："
				+cpu.getBrand());
	}

}
