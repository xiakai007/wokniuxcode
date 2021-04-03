package com.woniu.home2;
//封装；
public class MyMath {
	/**
	 * 1.求任意数阶乘的方法
	 * @param num 整数
	 * @return 阶乘的结果
	 */
   public long jieCheng(int num) {
			if(num<0) {
				return -1;
			}
			if(num == 0 || num == 1) {
				return 1;
			}
			long  ji = 1;
				for(int i = num;i>1;i--) {
					ji *= i;
				}
				return ji;
   }
   
   /**
    * 2.判断一个数是否是水仙花数
    * @param num 三位数
    * @return ture 是，false 否
    */
   public boolean isNarcissus(int num) {
	   if(num<100 || num>=1000) {
			return false;
		}
			int ge = num%10;
			int shi = num/10%10;
			int bai = num/100;
			return ge*ge*ge+shi*shi*shi+bai*bai*bai == num;
			}
   
   /**
    * 3.数组倒序算法
    * @param arr 需要倒序的数组对象地址
    */
   public void inversetSort(double []arr) {
	   if(arr == null) {   //防护空指针异常
		   System.out.println("数组为空！");
		   return;
	   }
	   for(int left=0,right=arr.length-1;left<right;left++,right--) {
		   double temp = arr[left];
		   arr[left] = arr[right];
		   arr[right] = temp;
	   }
   }
}
  
  


