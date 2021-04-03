package cc.zy.base.common.paymentUtils.example_quickIn;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.SignUtil_QuickIn;

/**
 * 聚合支付API
 * Created by LVHUIHUI on 2018-8-6
 *
 */
public class SIJsPay {
	
	public static Map getReqparas(){
		Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
    	paras.put("random", "liantuo123");//随机数
    	paras.put("merchantCode", "EW_N4130797151");//商户编号
    	paras.put("outTradeNo", "EW_N4267159134_a1a11a11aaaabc1aa1");//商户订单号
    	paras.put("totalAmount", "0.01");//订单金额
    	paras.put("expireSeconds", "300");//二维码有效期以秒为单位
    	paras.put("returnUrl", "http://baidu.com");//公众号支付成功跳转地址
    	paras.put("orderRemark", "0.01");//订单备注
    	paras.put("sign", SignUtil_QuickIn.createSign(paras,ComConstant_QuickIn.PARTER_KEY ,ComConstant_QuickIn.INPUT_CHARSET));
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("聚合支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIJsPay.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_JS_PAY));
	}
}
