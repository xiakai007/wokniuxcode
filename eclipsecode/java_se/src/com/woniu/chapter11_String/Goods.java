package com.woniu.chapter11_String;

public class Goods {
//	private double d1 = 124.23;
//	private double d2 = 4500.0;
//	private double d3 = 8800.9;
//	private double d4 = 5000.88;
//	private double d5 = 4456.0;
	double []prices = new double[] 
	{124.23,4500.0,8800.9,5000.88,4456.0};
	String []names = new String[]
	{"电风扇","洗衣机","电视机","冰箱","空调机"};
	double sumM;
	
	/**
	 * 登录验证
	 * @param name
	 * @param pwd
	 * @return
	 */
	public boolean verify(String name,String pwd) {
		if(name.equals("TOM")&&pwd.equals("123")) {
			return true;
		}else {
			return false;
		}
	}
    
	/**
	 * 显示商品信息
	 */
	public void show() {
		System.out.println("**********欢迎进入商品批发城**********");
		System.out.println("\t编号\t商品\t价格");
		for(int i=0;i<names.length;i++) {
			System.out.println("\t"+(i+1)+"\t"+names[i]+"\t"+change(prices[i]));
		}
//		System.out.println("\t1\t电风扇\t" + change(d1));
//		System.out.println("\t2\t洗衣机\t" + change(d2));
//		System.out.println("\t3\t电视机\t" + change(d3));
//		System.out.println("\t4\t冰箱\t" + change(d4));
//		System.out.println("\t5\t空调机\t" + change(d5));
		System.out.println("**************************************");
	}

	public String change(double price) {
		StringBuffer str = new StringBuffer(String.valueOf(price));
		for (int i = str.indexOf(".") - 3; i > 0; i -= 3) {
			str.insert(i, ',');
		}
		return str.toString();
	}

	public void calPrice(int goodNo, int amount) {
		//获取总价格并转换格式
		double totalPrice = prices[goodNo-1]*amount;
		System.out.println("您需要付款"+totalPrice);
//		switch (idN) {
//		case 1:
//			sumM = amount * d1;
//			System.out.println("您需要付款：" + change(sumM));
//			break;
//		case 2:
//			sumM = amount * d2;
//			System.out.println("您需要付款：" + change(sumM));
//			break;
//		case 3:
//			sumM = amount * d3;
//			System.out.println("您需要付款：" + change(sumM));
//			break;
//		case 4:
//			sumM = amount * d4;
//			System.out.println("您需要付款：" + change(sumM));
//			break;
//		case 5:
//			sumM = amount * d5;
//			System.out.println("您需要付款：" + change(sumM));
//			break;
//		default:
//			break;
//		}
	}

}
