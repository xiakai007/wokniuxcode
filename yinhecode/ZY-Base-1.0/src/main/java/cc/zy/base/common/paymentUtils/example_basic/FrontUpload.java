package cc.zy.base.common.paymentUtils.example_basic;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_Basic;
import cc.zy.base.common.paymentUtils.util.SignUtil;
import com.alibaba.fastjson.JSON;



/**
 *图片上传API
 * Created by LVHUIHUI on 2018-6-1
 *
 */
public class FrontUpload {
	/**
	 * 图片上传API
	 * @return
	 */
	public static Map getReqparas(){
		HashMap<String, HashMap<String, String>> requestJson = new HashMap<String, HashMap<String, String>>();
		HashMap<String,String> map = new HashMap<String,String>();
		HashMap<String, String> body = new HashMap<String, String>();
		HashMap<String, String> head = new HashMap<String, String>();
    	Map<String, String> paras = new HashMap<String, String>();
    	head.put("service", "front.jsapi");//扫码--公众号支付
    	head.put("version", ComConstant_Basic.VERSION_1);//默认版本号
    	head.put("partner_id", ComConstant_Basic.PARTNER_ID);//联富通线下提供pid
    	head.put("core_merchant_no", ComConstant_Basic.CORE_MERCHANT_NO);//联富通后台核心商户编号
    	head.put("input_charset", ComConstant_Basic.INPUT_CHARSET);//编码格式，默认只支持UTF-8
		
    	body.put("merchant_no", "EW_N8366110628");//门店商户编号
    	body.put("channel_type", "ALI");//支付渠道
    	body.put("out_trade_no", "EW_N8366110628_01aa1b1aa112");//商户订单号	
    	body.put("total_amount", "0.01");//订单总金额
    	body.put("subject", "玉玲兰麓谷店");//商品标题
    	body.put("spbill_create_ip", "123.0.0.1");//终端IP
    	body.put("device_info", "设备测试账号1");//设备号
    	//body.put("open_id", "oLNmRjrZe5hqTd0eXMvZQTUBjR94");//对应的appid获取的用户openid
    	body.put("open_id", "2088412828586837");//使用支付宝支付的时候获取的支付宝buyid
    	//body.put("sub_appid", "wx6c68ab3d898a1a96");//联富通后台门店进件时填写的appid,传递参数时针对于所有的商户全部都为sub_appid
    	body.put("notify_url", "http://dailishanghu.com");//商户自己服务器被动接收支付结果的服务器地址
		
   
    	requestJson.put("body", body);
        requestJson.put("head", head);
        map.putAll(body);
        map.putAll(head);
 	    head.put("sign", SignUtil.createSign(map,ComConstant_Basic.PARTER_KEY,ComConstant_Basic.INPUT_CHARSET));
 	    head.put("sign_type", ComConstant_Basic.SIGN_TYPE);
 	    paras.put("requestJson", JSON.toJSONString(requestJson));
		
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("公众账号支付===服务器端返回res====="+ Main.requestAsPost(FrontUpload.getReqparas()));
	}
	
}
