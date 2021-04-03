package com.woniu.chapter19_collection;

class Stud{
	public int show() {
		try{
			int []nums = new int [3];
			System.out.println(nums[2]);
			System.out.println("++++");
			return 100;
		}finally {
			System.out.println("finally---------");
		}
	}
}

public class Finally {
	public static void main(String[] args) {
		Stud stu = new Stud();
		System.out.println(stu.show());
		
//		try {
//			Class.forName("sdfgsdfj");
//		}catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			new FileOutputStream("");
//		}catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		//java.lang.NullPointerException
//		String str = null;
//		System.out.println(str.length());
//		//java.lang.ArrayIndexOutOfBoundsException
//		String []arr = new String[4];
//		System.out.println(arr[4]);
//		//java.lang.ClassCastException
//		Object obj = new Date();
//		String str2 = (String)obj;
//		//java.lang.NumberFormatException
//		int num = Integer.parseInt("abc");
//		System.out.println(num);
//		//java.util.InputMismatchException
//		Scanner sc = new Scanner(System.in);
//		int no = sc.nextInt();
//		sc.close();
//		//java.lang.ArithmeticException
//		int res = 10/0;
	}

}
