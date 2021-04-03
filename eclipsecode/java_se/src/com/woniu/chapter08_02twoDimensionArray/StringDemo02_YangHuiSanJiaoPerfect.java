package com.woniu.chapter08_02twoDimensionArray;

public class StringDemo02_YangHuiSanJiaoPerfect {
	public static void main(String[] args) {
		// 创建杨辉数组并赋初始值
		int[][] yangHui = new int[11][];
		for (int i = 0; i < yangHui.length; i++) {
			yangHui[i] = new int[i + 1];
			// 第（i+1）行第1列的值均为1
			yangHui[i][0] = 1;
			// 第（i+1）行第（i+1）列的值均为1
			yangHui[i][i] = 1;
		}
		// 杨辉算法填充数据
		for (int i = 2; i < yangHui.length; i++) {
			for (int j = 1; j < i; j++) {
				yangHui[i][j] = yangHui[i - 1][j] + yangHui[i - 1][j - 1];
			}
		}
		// 遍历输出
		for (int i = 0; i < yangHui.length; i++) {
			for(int k=0;k<yangHui.length-i-1;k++) {
				System.out.print("\t");
			}
			for (int j = 0; j < yangHui[i].length; j++) {
				System.out.print("\t"+yangHui[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
