package cc.zy.base.common.paymentUtils.example_quickIn;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.SignUtil_QuickIn;

/**
 * 主扫支付API
 * Created by LVHUIHUI on 2018-8-6
 *
 */
public class SIPrecreateNative {
	
	public static Map getReqparas(){
	 	Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
    	paras.put("random", "liantuo123" + new Random().nextInt());//随机数
    	paras.put("merchantCode", "EW_N3569696496");//商户编号
    	paras.put("outTradeNo", "zhu" + new Random().nextInt(100000000));//商户订单号
    	paras.put("totalAmount", "0.01");//订单总金额
    	paras.put("channel", "WXPAY");//支付渠道
    	paras.put("tradeType", "NATIVE");//支付交易类型
    	paras.put("notifyUrl", "http://www.baidu.com");//异步通知地址
    	paras.put("subject", "测试订单123");//支付凭证商品描述信息，不填写默认为交易订单编号
    	paras.put("sign", SignUtil_QuickIn.createSign(paras,ComConstant_QuickIn.PARTER_KEY ,ComConstant_QuickIn.INPUT_CHARSET));

    	paras.put("subOpenId","1");
	    return paras;
   }
	
	public static Map getReqparasTest(){
	 	Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", "EW_N5946005323");//合作方标识
    	paras.put("random", "9217");//随机数
    	paras.put("merchantCode", "EW_N4130797151");//商户编号
    	paras.put("outTradeNo", "234123432");//商户订单号
    	paras.put("totalAmount", "0.1");//订单总金额
    	paras.put("channel", "WXPAY");//支付渠道
    	paras.put("tradeType", "NATIVE");//支付交易类型
    	paras.put("notifyUrl", "http://gate.wonzy.top/services/liantuopay/callback.aspx&sign=eb81405f21aea080f19a82c555bb8109");//异步通知地址
    	//paras.put("subject", "测试订单1");//支付凭证商品描述信息，不填写默认为交易订单编号
    	paras.put("sign", SignUtil_QuickIn.createSign(paras,"f37101f36627cba9232840ae7017304e",ComConstant_QuickIn.INPUT_CHARSET));
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("主扫支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIPrecreateNative.getReqparasTest(),ComConstant_QuickIn.SERVICEURL_NEWSI_PRECREATE));
	}
}
