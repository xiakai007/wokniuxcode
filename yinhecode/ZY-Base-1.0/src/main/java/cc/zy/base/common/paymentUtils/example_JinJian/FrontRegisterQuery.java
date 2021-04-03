package cc.zy.base.common.paymentUtils.example_JinJian;

import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_JinJian;
import cc.zy.base.common.paymentUtils.util.SignUtil;
import com.alibaba.fastjson.JSON;


/**
 * 进件--进件查询接口
 * Created by LVHUIHUI on 2018-9-4
 *
 */
public class FrontRegisterQuery {
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
    	head.put("service", "merchant.registerquery");
    	 head.put("version", "1.0");//默认版本号
         head.put("input_charset", ComConstant_JinJian.INPUT_CHARSET);//编码格式，默认只支持UTF-8
         head.put("channel_partner_id", ComConstant_JinJian.CHANNEL_PARTNER_ID );//联富通渠道合作编号(开通代理商账号时，联富通商务提供)
         head.put("platform_merchant_no", ComConstant_JinJian.PLATFORM_MERCHANT_NO);//联富通平台商户编号(开通代理商账号时，联富通商务提供) 
		
       
        body.put("core_merchant_no", "EW_N6882910206");//联富通商户ID,进件接口返回的参数
        body.put("merchant_no", "EW_N4147165634");//联富通门店ID,进件接口返回的参数
        
        requestJson.put("head", head);
        requestJson.put("body", body);
        map.putAll(head);
        map.putAll(body);
		
   
    	requestJson.put("body", body);
        requestJson.put("head", head);
        map.putAll(body);
        map.putAll(head);
 	    head.put("sign", SignUtil.createSign(map,ComConstant_JinJian.PARTER_KEY,ComConstant_JinJian.INPUT_CHARSET));
 	    head.put("sign_type", ComConstant_JinJian.SIGN_TYPE);
 	    paras.put("requestJson", JSON.toJSONString(requestJson));
 	   System.out.println("请求参数========"+paras);
 	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("进件--进件查询接口===服务器端返回res====="+Main.requestAsPost(FrontRegisterQuery.getReqparas()));
	}
}
