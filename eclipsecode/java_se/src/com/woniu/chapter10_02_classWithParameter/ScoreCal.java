package com.woniu.chapter10_02_classWithParameter;

public class ScoreCal {
	/**
	 * 
	 * @param scores
	 * @return 平均成绩
	 */
	public double calAvg(int []scores) {
		int sum = 0;
		for(int i =0;i<scores.length;i++) {
			sum += scores[i];
		}
		return (double)sum/scores.length;
	}
	/**
	 * 
	 * @param scores
	 * @return 最高成绩
	 */
	public int calMax(int []scores) {
		int max = scores[0];
		for(int i =0;i<scores.length;i++) {
			if(scores[i]>max) {
				max = scores[i];
			}
		}
		return max;
	}

}
