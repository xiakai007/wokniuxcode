package com.wxws.sms.data;
/**
 * Gift.java
 * 礼品类
 */
public class Gift {
	 public String name;
	 public double price;
     
     public String toString(){
    	 return "一个价值￥" + price + "的" + name;
     }
}
