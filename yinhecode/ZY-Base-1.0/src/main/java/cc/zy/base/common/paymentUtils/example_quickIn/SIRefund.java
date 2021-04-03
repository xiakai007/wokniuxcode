package cc.zy.base.common.paymentUtils.example_quickIn;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.SignUtil_QuickIn;

/**
 * 支付订单退款API
 * Created by LVHUIHUI on 2018-8-6
 *
 */
public class SIRefund {
	
	public static Map getReqparas(){
		Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
    	paras.put("random", "liantuo123"+new Random().nextInt());//随机数
    	paras.put("merchantCode", "EW_N3569696496");//商户编号
    	paras.put("outTradeNo", "2021020109311505742723");//商户订单号
    	paras.put("refundNo", "TKS2021020109311505742723");//退款订单号
    	paras.put("refundAmount", "0.01");
    	paras.put("sign", SignUtil_QuickIn.createSign(paras,ComConstant_QuickIn.PARTER_KEY ,ComConstant_QuickIn.INPUT_CHARSET));
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("支付订单退款API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIRefund.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_REFUND));
	}
}
