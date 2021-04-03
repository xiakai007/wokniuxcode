package cc.zy.base.common.paymentUtils.example_JinJian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_JinJian;
import cc.zy.base.common.paymentUtils.constant.RegisterRequestBodyForRate;
import cc.zy.base.common.paymentUtils.util.SignUtil;
import com.alibaba.fastjson.JSON;


/**
 * 进件--进件接口
 * Created by LVHUIHUI on 2018-9-4
 *
 */
public class FrontRegister {
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
    	head.put("service", "merchant.register");//进件方法
        head.put("version", "1.0");//默认版本号
        head.put("input_charset", ComConstant_JinJian.INPUT_CHARSET);//编码格式，默认只支持UTF-8
        head.put("channel_partner_id",ComConstant_JinJian.CHANNEL_PARTNER_ID );//联富通渠道合作编号(开通代理商账号时，联富通商务提供) 
        head.put("platform_merchant_no", ComConstant_JinJian.PLATFORM_MERCHANT_NO);//联富通平台商户编号(开通代理商账号时，联富通商务提供) 
		
        body.put("agent_no", "EW_N8484741367");//联富通后台代理商编号
        body.put("register_type", "03");//进件类型
        body.put("merchant_full_name", "张无忌");//商户名称/企业名称
        body.put("merchant_name", "张无忌");//商户简称
        body.put("province_id", "110000");//商户所在省ID
        body.put("city_id", "110100");//商户所在市ID
        body.put("area_id", "110106");//商户所在区ID
        body.put("address", "张无忌");//商户所在区ID
        body.put("business_category", "297");//经营类目/行业类别ID
        body.put("contact_name", "张无忌");//负责人/法人姓名
        body.put("certificate_no", "13082119880919805X");//法人证件号
        body.put("business_license_no", "911303026690645423");//营业执照编号
        body.put("bank", "102100099996");//开户银行
        body.put("card_no", "3267465464654654654");//银行卡号/对公账号
        
        body.put("contact_phone", "13919561125");//负责人电话
        body.put("certificate_holder_no", "500225199002260015");//持卡人身份证号码
        body.put("login_name", "zhangwj_dl0171");//门店登陆账号
        ArrayList<RegisterRequestBodyForRate> voList = new ArrayList<RegisterRequestBodyForRate>();
        RegisterRequestBodyForRate AliVo = new RegisterRequestBodyForRate();
        RegisterRequestBodyForRate WxVo = new RegisterRequestBodyForRate();
        AliVo.setRate_type("01");//	费率类型
        AliVo.setRate_value("0.0038");//费率
        WxVo.setRate_type("02");//	费率类型
        WxVo.setRate_value("0.0048");//费率
        voList.add(AliVo);
        voList.add(WxVo);
        body.put("rate_list",JSON.toJSONString(voList));
        
 
        body.put("identification_front_url", "01_153604766770181170967367256289.jpg");//负责人/法人身份证正面照片
        body.put("identification_opposite_url", "01_153604766770181170967367256289.jpg");//	负责人/法人身份证反面照片
        body.put("business_license_url", "01_153604766770181170967367256289.jpg");//营业执照照片
        body.put("door_ceb_url", "01_153604766770181170967367256289.jpg");//门头照
        body.put("merchantagreement_url", "01_153604766770181170967367256289.jpg");//商户协议照
        body.put("opening_permit_url", "01_153604766770181170967367256289.jpg");//开户许可证照片
        body.put("supplementary_material_url", "01_153604766770181170967367256289.jpg");//商户协议照
        body.put("supplementary_material_url1", "01_153604766770181170967367256289.jpg");//其他照片1
        body.put("supplementary_material_url2", "01_153604766770181170967367256289.jpg");//	其他照片2
        
        
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
		System.out.println("进件--进件接口===服务器端返回res====="+Main.requestAsPost(FrontRegister.getReqparas()));
	}
}
