package com.woniu.chapter15_InterfacePinter;

public class Printer {
	private InkBox inkBox;
	private Paper paper;
	public void setInkBox(InkBox inkBox) {
		this.inkBox = inkBox;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	public void print() {
		System.out.println("使用"+inkBox.getColor()+"墨盒在"
				+paper.getSize()+"纸张上打印");
	}

}
