package com.wxws.sms.data;
/**
 * 礼品类
 * @author xiakai
 *
 */
public class Gift {
	public String giftName;
	public double giftPrice;
	@Override
	public String toString() {
		return "一个价值¥"+giftPrice+"的"+giftName;
	}
	

}
