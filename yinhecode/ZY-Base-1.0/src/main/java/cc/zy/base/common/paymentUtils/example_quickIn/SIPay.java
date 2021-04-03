package cc.zy.base.common.paymentUtils.example_quickIn;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.SignUtil_QuickIn;

/**
 * 被扫支付API
 * Created by LVHUIHUI on 2018-8-6
 *
 */
public class SIPay {
	
	public static Map getReqparas(){
		Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
    	paras.put("random", "liantuo123");//随机数
    	paras.put("merchantCode", "EW_N4130797151");//商户编号
    	paras.put("outTradeNo", "EW_N4267159134_a1a11a11aaaabc1");//商户订单号
    	paras.put("totalAmount", "0.01");//订单总金额
    	paras.put("authCode", "135342335622154771");//支付授权码
    	paras.put("subject", "测试订单1");//支付凭证商品描述信息，不填写默认为交易订单编号
    	paras.put("sign", SignUtil_QuickIn.createSign(paras,ComConstant_QuickIn.PARTER_KEY ,ComConstant_QuickIn.INPUT_CHARSET));
	    return paras;
   }
  public static Map getReqparasTest(){
		Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
    	paras.put("random", "9217");//随机数
    	paras.put("merchantCode", "EW_N4130797151");//商户编号
    	paras.put("outTradeNo", "234123432");//商户订单号
    	paras.put("totalAmount", "0.1");//订单总金额
    	paras.put("authCode", "123");//支付授权码
    	paras.put("operatorId", "1001");//支付凭证商品描述信息，不填写默认为交易订单编号
    	paras.put("sign", SignUtil_QuickIn.createSign(paras,ComConstant_QuickIn.PARTER_KEY ,ComConstant_QuickIn.INPUT_CHARSET));
    	System.out.println("请求数据："+paras);
	    return paras;
   }
	public static void main(String[] args)  { 
		System.out.println("被扫支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIPay.getReqparasTest(),ComConstant_QuickIn.SERVICEURL_NEWSI_PAY));
	}
}
