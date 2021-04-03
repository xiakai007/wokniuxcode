package com.woniu.chapter17_outer_inner_lambda;

import java.util.Arrays;
import java.util.Comparator;

//class InvPersoon implements Comparator<Persoon>{
//	@Override
//	public int compare(Persoon o1, Persoon o2) {
////		return Integer.compare(o1.getAge(), o2.getAge());
//		//按年龄升序
//		if(o1.getAge()>o2.getAge()) {
//			return 1;
//		}else if(o1.getAge()==o2.getAge()){
//			//年龄相同时按名称升序
//			return o1.getName().compareTo(o2.getName());
//		}else {
//			return -1;
//		}
//	}
//}

public class PersoonTest {
	public static void main(String[] args) {
		Persoon []prns = new Persoon[5];
		prns[0] = new Persoon("x一号",25);
		prns[1] = new Persoon("s二号",6);
		prns[2] = new Persoon("j三号",17);
		prns[3] = new Persoon("a四号",48);
		prns[4] = new Persoon("e五号",17);
		System.out.println("排序前："+Arrays.toString(prns));
		Arrays.sort(prns);
		System.out.println("自然排序后（降序）："+Arrays.toString(prns));
		//通过匿名内部类实现
		Arrays.sort(prns,new Comparator<Persoon>(){
			@Override
			public int compare(Persoon o1, Persoon o2) {
				//按年龄升序
				if(o1.getAge()>o2.getAge()) {
					return 1;
				}else if(o1.getAge()==o2.getAge()){
					//年龄相同时按名称升序
					return o1.getName().compareTo(o2.getName());
				}else {
					return -1;
				}
			}
			
		});
		System.out.println("定制排序后（升序）："+Arrays.toString(prns));
		
	}

}
