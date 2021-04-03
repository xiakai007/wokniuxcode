package cc.zy.base.common.paymentUtils.example_basic;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_Basic;
import cc.zy.base.common.paymentUtils.util.SignUtil;
import com.alibaba.fastjson.JSON;

/**
 *订单退款查询API
 * Created by LVHUIHUI on 2018-6-1
 *
 */
public class FrontRefundQuery {
	/**
	 * 组装请求参数
	 * @return
	 */
	public static Map getReqparas(){
		HashMap<String, HashMap<String, String>> requestJson = new HashMap<String, HashMap<String, String>>();
		HashMap<String,String> map = new HashMap<String,String>();
		HashMap<String, String> body = new HashMap<String, String>();
		HashMap<String, String> head = new HashMap<String, String>();
    	Map<String, String> paras = new HashMap<String, String>();
    	head.put("service", "front.refundquery");//订单退款查询API
    	head.put("version", ComConstant_Basic.VERSION_1);//默认版本号
    	head.put("partner_id", ComConstant_Basic.PARTNER_ID);//联富通线下提供pid
    	head.put("core_merchant_no", ComConstant_Basic.CORE_MERCHANT_NO);//联富通后台核心商户编号
    	head.put("input_charset", ComConstant_Basic.INPUT_CHARSET);//编码格式，默认只支持UTF-8
		
    	body.put("out_refund_no", "EW_N8366110628_222");//退款订单号
    	
    	requestJson.put("body", body);
        requestJson.put("head", head);
        map.putAll(body);
        map.putAll(head);
 	    head.put("sign", SignUtil.createSign(map,ComConstant_Basic.PARTER_KEY ,ComConstant_Basic.INPUT_CHARSET));
 	    head.put("sign_type", ComConstant_Basic.SIGN_TYPE);
 	    paras.put("requestJson", JSON.toJSONString(requestJson));
		
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("订单退款查询API===服务器端返回res====="+ Main.requestAsPost(FrontRefundQuery.getReqparas()));
	}
	
}
