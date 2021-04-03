package homework;

import java.util.Scanner;

public class HW02_MyMathTest {
	public static void main(String[] args) {
		HW02_MyMath ftr = new HW02_MyMath();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		ftr.factorial(6);
		ftr.narcissus(153);
	}

}
