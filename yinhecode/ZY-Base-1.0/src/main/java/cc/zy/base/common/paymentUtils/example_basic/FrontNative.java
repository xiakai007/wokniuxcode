package cc.zy.base.common.paymentUtils.example_basic;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_Basic;
import cc.zy.base.common.paymentUtils.util.SignUtil;
import com.alibaba.fastjson.JSON;


/**
 * 扫码--主扫支付
 * Created by LVHUIHUI on 2018-6-1
 *
 */
public class FrontNative {
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
    	head.put("service", "front.native");//扫码--主扫支付
    	head.put("version", ComConstant_Basic.VERSION_1);//默认版本号
    	head.put("partner_id", ComConstant_Basic.PARTNER_ID);//联富通线下提供pid
    	head.put("core_merchant_no", ComConstant_Basic.CORE_MERCHANT_NO);//联富通后台核心商户编号
     	head.put("input_charset", ComConstant_Basic.INPUT_CHARSET);//编码格式，默认只支持UTF-8
       
		
        body.put("merchant_no", "EW_N8366110628");//门店商户编号
    	body.put("channel_type", "WX");//支付渠道
    	body.put("out_trade_no", "EW_N8366110628_0000w1211");//商户订单号	
    
        body.put("total_amount", "0.01");//订单总金额
    	body.put("subject", "玉玲兰麓谷店");//商品标题
    	body.put("spbill_create_ip", "123.0.0.1");//终端IP
    	body.put("device_info", "设备测试账号1");//设备号
		
    	requestJson.put("body", body);
        requestJson.put("head", head);
        map.putAll(body);
        map.putAll(head);
 	    head.put("sign", SignUtil.createSign(map,ComConstant_Basic.PARTER_KEY ,ComConstant_Basic.INPUT_CHARSET));
 	    head.put("sign_type", ComConstant_Basic.SIGN_TYPE);
 	    paras.put("requestJson", JSON.toJSONString(requestJson));
 	   System.out.println("requestJson======="+paras);
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("扫码--主扫支付===服务器端返回res====="+ Main.requestAsPost(FrontNative.getReqparas()));
	}
	
}
