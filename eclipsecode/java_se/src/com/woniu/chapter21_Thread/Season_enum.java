package com.woniu.chapter21_Thread;
class Season{
	private final String SEASONNAME;
	private final String SEASONDESC;
	private Season(String seasonName,String seasonDesc) {
		this.SEASONNAME = seasonName;
		this.SEASONDESC = seasonDesc;
	}
	public static final Season SPRING = new Season("春天","春暖花开");
	public static final Season SUMMER = new Season("夏天","夏日炎炎");
	public static final Season AUTOMN = new Season("秋天","秋高气爽");
	public static final Season WINTER = new Season("冬天","万里雪飘");
	@Override
	public String toString() {
		return "Season [SEASONNAME=" + SEASONNAME + ", SEASONDESC=" + SEASONDESC + "]";
	}
	
}
class Testt{
	private Season season;

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	public Testt() {
		super();
	}
	
}
public class Season_enum {
	public static void main(String[] args) {
		Season spring = Season.SPRING;
		System.out.println(spring);
		Season summer = Season.SUMMER;
		System.out.println(summer);
		Season automn = Season.AUTOMN;
		System.out.println(automn);
		Season winter = Season.WINTER;
		System.out.println(winter);
		Testt te = new Testt();
		te.setSeason(Season.SPRING);
		System.out.println(te.getSeason());
	}

}
