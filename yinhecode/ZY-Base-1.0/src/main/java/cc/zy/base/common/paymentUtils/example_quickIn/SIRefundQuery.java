package cc.zy.base.common.paymentUtils.example_quickIn;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.MD5Utils;

/**
 * 支付订单退款查询API
 * Created by LVHUIHUI on 2018-8-6
 *
 */
public class SIRefundQuery {
	
	public static Map getReqparas(){
		Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
    	paras.put("random", "liantuo123");//随机数
    	paras.put("merchantCode", "EW_N3569696496");//商户编号
    	paras.put("refundNo", "TK2021020109311505742723");//退款订单号
    	//paras.put("sign", SignUtil_QuickIn.createSign(paras,ComConstant_QuickIn.PARTER_KEY ,ComConstant_QuickIn.INPUT_CHARSET));
	    paras.put("sign", MD5Utils.stringToMD5(paras,ComConstant_QuickIn.PARTER_KEY));
		return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("支付订单退款查询API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIRefundQuery.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_REFUND_QUERY));
	}
}
