package com.woniu.chapter13_abstract_1Instruments;

public class InstrumentTest {
	public static void main(String[] args) {
		Piano piano = new Piano();
		Violin violin = new Violin();
		Musician play = new Musician();
		play.testPlay(piano);
		play.testPlay(violin);
	}

}
