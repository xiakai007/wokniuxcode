package com.woniu.chapter10_01_classWithNoParameter;

/**
 * 成绩计算类
 * 
 * @author 夏凯
 */
public class ScoreCal {
	int java;
	int c;
	int db;

	/**
	 * 计算总成绩
	 */
	public int calTotal() {
		return java + c + db;
	}

	/**
	 * 计算平均成绩
	 */
	public double calAvg() {
		return calTotal() / 3.0;
	}

	/**
	 * 展示总成绩
	 */
	public void showCalTotal() {
		System.out.println("总成绩是：" + calTotal());
	}

	/**
	 * 展示平均成绩
	 */
	public void showCalAvg() {
		System.out.println("平均成绩是：" + calAvg());
	}

}
