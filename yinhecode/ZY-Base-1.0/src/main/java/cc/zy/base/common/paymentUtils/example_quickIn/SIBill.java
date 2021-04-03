package cc.zy.base.common.paymentUtils.example_quickIn;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.SignUtil_QuickIn;


/**
 * 支付账单查询API
 * Created by LVHUIHUI on 2018-8-6
 *
 */
public class SIBill {
	
	public static Map getReqparas(){
		Map<String, String> paras = new HashMap<String, String>();
    	paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
    	paras.put("random", "liantuo123");//随机数
    	paras.put("merchantCode", "EW_N3569696496");//商户编号
    	paras.put("billBeginTime", "20210201000000");//查询开始时间
    	paras.put("billEndTime", "20210202000000");//查询结束时间
    	paras.put("sign", SignUtil_QuickIn.createSign(paras,ComConstant_QuickIn.PARTER_KEY ,ComConstant_QuickIn.INPUT_CHARSET));
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("支付账单查询API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIBill.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_BILL));
	}
}
