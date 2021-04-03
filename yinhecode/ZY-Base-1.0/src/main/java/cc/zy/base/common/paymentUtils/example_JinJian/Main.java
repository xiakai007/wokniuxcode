package cc.zy.base.common.paymentUtils.example_JinJian;

import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_Basic;
import cc.zy.base.common.paymentUtils.util.HttpClientUtil;

/**
 * 联富通进件接口demo列表
 * Created by LVHUIHUI on 2018-9-4
 *
 */
public class Main {
	/**
	 * 请求联富通服务器
	 * @param reqParas
	 * @return
	 */
	public static String requestAsPost(Map reqParas){
		String res = HttpClientUtil.requestAsHttpPOST(ComConstant_Basic.SERVICEURL_NEWFRONT,reqParas,ComConstant_Basic.INPUT_CHARSET,10000,20000);
		return res;
	 }
	
	public static void main(String[] args)  { 
		System.out.println("进件--上传图片===服务器端返回res====="+Main.requestAsPost(FrontUpload.getReqparas()));
	}
	
	
	
}
