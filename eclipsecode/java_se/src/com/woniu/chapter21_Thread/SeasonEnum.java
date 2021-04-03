package com.woniu.chapter21_Thread;

public enum SeasonEnum {
	SPRING("春天","春暖花开"),
	SUMMER("夏天","夏日炎炎"),
	AUTOMN("秋天","秋高气爽"),
	WINTER("冬天","万里雪飘");
	private final String seasonName;
	private final String seasonDesc;
	private SeasonEnum(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
}


