package com.woniu.chapter16_Comparable_tor;

import java.util.Arrays;
import java.util.Comparator;

class InvertedString implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2);//降序
	}

}
//class InvertedGoods implements Comparator<Goods>{
//
//	@Override
//	public int compare(Goods o1, Goods o2) {
//		//升序
//		//return Double.compare(o1.getPrice(), o2.getPrice());
////		if(o1.getPrice()>o2.getPrice()) {
////			return 1;
////		}
////		if(o1.getPrice()==o2.getPrice()) {
////			return 0;
////		}else {
////			return -1;
////		}
//		
//		//降序
//		return Double.compare(o2.getPrice(), o1.getPrice());
//	}
//	
//}

public class InvertedTest {
public static void main(String[] args) {
	InvertedString invertS = new InvertedString();
	String []strs = {"rr","jj","mm","vv","aa","ff"};
	System.out.println(Arrays.toString(strs));
	//定制排序
	Arrays.sort(strs, invertS);
	System.out.println(Arrays.toString(strs));
	Goods []goods = new Goods[5];
	goods[0] = new Goods("r红楼梦",23);
	goods[1] = new Goods("b水浒传",54);
	goods[2] = new Goods("h西游记",16);
	goods[3] = new Goods("d三国演义",40);
	goods[4] = new Goods("n营造天书",8);
	System.out.println(goods);//地址
	//定制排序-降序
//	Arrays.sort(goods, new InvertedGoods());
	//匿名内部类
	Arrays.sort(goods, new Comparator<Goods>() {
		@Override
		public int compare(Goods o1, Goods o2) {
			//升序
			if(o1.getPrice()>o2.getPrice()) {
				return 1;
			}
			if(o1.getPrice()==o2.getPrice()) {
				return 0;
			}else {
				return -1;
			}
		}
	});
	//lambda 表达式：(参数)-> {方法体}
	Arrays.sort(goods, (o1,o2) ->{
		return Double.compare(o2.getPrice(), o1.getPrice());//降序
	});
	System.out.println(Arrays.toString(goods));
 }
}
