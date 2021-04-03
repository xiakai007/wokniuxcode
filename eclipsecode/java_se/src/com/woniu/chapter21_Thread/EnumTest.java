package com.woniu.chapter21_Thread;

public class EnumTest {
	public static void main(String[] args) {
		SeasonEnum spring = SeasonEnum.SPRING;
		System.out.println(spring);
		System.out.println(spring.getSeasonName());
		System.out.println(spring.getSeasonDesc());
		SeasonEnum[] seasons = SeasonEnum.values();
		for(SeasonEnum season:seasons) {
			System.out.println(season);
		}
		SeasonEnum automn = SeasonEnum.valueOf("AUTOMN");
		System.out.println(automn);
		String st = SeasonEnum.WINTER.getSeasonName();
		System.out.println(st);
	}

}
