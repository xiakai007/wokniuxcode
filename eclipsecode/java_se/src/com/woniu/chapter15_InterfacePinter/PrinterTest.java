package com.woniu.chapter15_InterfacePinter;

public class PrinterTest {
	public static void main(String[] args) {
		Printer prt = new Printer();
		
		InkBox inkBox = new GrayInkBox();
		Paper paper = new A4Paper();
		prt.setInkBox(inkBox);
		prt.setPaper(paper);
		prt.print();
		
		inkBox = new ColorInkBox();
		paper = new B3Paper();
		prt.setInkBox(inkBox);
		prt.setPaper(paper);
		prt.print();
		
		inkBox = new ColorInkBox();
		paper = new A4Paper();
		prt.setInkBox(inkBox);
		prt.setPaper(paper);
		prt.print();
	}

}
