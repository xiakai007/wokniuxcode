package com.woniu.chapter08_02twoDimensionArray;

public class StringDemo02_YangHuiSanJiao {
	public static void main(String[] args) {
		// 生成二维数组
		int[][] yangHui = new int[15][];
		for (int i = 0; i < yangHui.length; i++) {
			yangHui[i] = new int[i + 1];// 根据第i行确定对应数组的长度
		}
		// 按照杨辉规则填充数据
		for (int i = 0; i < yangHui.length; i++) {
			for (int j = 0; j < yangHui[i].length; j++) {
				yangHui[i][0] = 1;
				yangHui[i][i] = 1;
				if (j > 0 && j < i) {
					yangHui[i][j] = yangHui[i - 1][j] + yangHui[i - 1][j - 1];
				}
			}
		}

		// 输出杨辉三角
		
		for (int i = 0; i < yangHui.length; i++) {
			for (int j = 0; j < yangHui[i].length; j++) {
				System.out.print(yangHui[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
