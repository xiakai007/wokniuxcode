package com.woniu.chapter15_Computer;

public class ComputerTest {
	public static void main(String[] args) {
		Computer cpt = new Computer();
		
		CPU cpu = new CPUIntel();
		HardDisk hdk = new HKingston();
		RAM ram = new RXiaoMi();
		cpt.setCpu(cpu);
		cpt.setHardDisk(hdk);
		cpt.setRam(ram);
		cpt.show();
		cpt.show2();
		System.out.println(cpu.getCpu());//接口中的默认方法通过实现类对象名打点调用
		System.out.println("---------");
		cpu = new CPUAmd();
		hdk = new Hwestd();
		ram = new RHuawei();
		cpt.setCpu(cpu);
		cpt.setHardDisk(hdk);
		cpt.setRam(ram);
		cpt.show();
		cpt.show2();
		CPU.info();//接口中的静态方法通过接口名打点调用
	}

}

