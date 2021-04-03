package cc.zy.base.common.paymentUtils.example_basic;

import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_Basic;
import cc.zy.base.common.paymentUtils.util.HttpClientUtil;

/**
 * 联富通支付接口demo列表
 * Created by LVHUIHUI on 2018-6-5
 *
 */
public class Main {
	/**
	 * 请求联富通服务器
	 * @param reqParas
	 * @return
	 */
	public static String requestAsPost(Map reqParas){
		String res = HttpClientUtil.requestAsHttpPOST(
										ComConstant_Basic.SERVICEURL_NEWFRONT,
										reqParas,ComConstant_Basic.INPUT_CHARSET,
										10000,
										20000);
		return res;
	 }
	
	public static void main(String[] args)  { 
		//System.out.println("扫码--主扫支付===服务器端返回res====="+requestAsPost(FrontNative.getReqparas()));
		//System.out.println("订单关单API===服务器端返回res====="+Main.requestAsPost(FrontClose.getReqparas()));
		//System.out.println("公众账号支付===服务器端返回res====="+Main.requestAsPost(FrontJsapi.getReqparas()));
		//System.out.println("扫码--被扫支付===服务器端返回res====="+Main.requestAsPost(FrontMicropay.getReqparas()));
		//System.out.println("订单退款API===服务器端返回res====="+Main.requestAsPost(FrontRefund.getReqparas()));
		//System.out.println("订单退款查询API===服务器端返回res====="+Main.requestAsPost(FrontRefundQuery.getReqparas()));
		//System.out.println("订单撤销API===服务器端返回res====="+Main.requestAsPost(FrontReverse.getReqparas()));
		System.out.println("订单查询API===服务器端返回res====="+Main.requestAsPost(FrontQuery.getReqparas()));
	}
	
	
	
}
