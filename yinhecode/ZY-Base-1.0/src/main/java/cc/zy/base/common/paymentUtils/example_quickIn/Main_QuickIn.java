package cc.zy.base.common.paymentUtils.example_quickIn;

import java.util.Map;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.HttpClientUtil;

/**
 * 联拓富快速接入版支付接口demo列表
 * Created by LVHUIHUI on 2018-8-6
 *
 */



public class Main_QuickIn {
	/**
	 * 联拓富快速接入版
	 * @param reqParas
	 * @return
	 */
	public static String requestAsPost(Map reqParas,String serverUrl){
		String res = HttpClientUtil.requestAsHttpPOST(serverUrl,reqParas, ComConstant_QuickIn.INPUT_CHARSET,10000,20000);
		return res;
	 }
	
	public static void main(String[] args)  {
		//ok查询所有订单
		System.out.println("支付账单查询API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIBill.getReqparas(), ComConstant_QuickIn.SERVICEURL_NEWSI_BILL));

		//ok进行公众号/小程序支付，返回支付链接
		//System.out.println("公众号&小程序支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIPrecreateJSAPI.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_PRECREATE));

		//ok订单退款
		//System.out.println("支付订单退款API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIRefund.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_REFUND));


		//ok查询退款订单
		//System.out.println("支付订单退款查询API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIRefundQuery.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_REFUND_QUERY));


		//本接口只针对预先创建订单的支付模式下的订单，包括“主扫支付”和“公众号支付”
		//System.out.println("支付订单关单API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIClose.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_CANCEL));
		//订单撤销只针对被扫支付订单
		//System.out.println("支付订单撤销API===服务器端返回res====="+Main_QuickIn.requestAsPost(SICancel.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_CANCEL));


		//System.out.println("秘钥信息下载===服务器端返回res====="+Main_QuickIn.requestAsPost(SILogin.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_LOGIN));
		//System.out.println("门店信息下载===服务器端返回res====="+Main_QuickIn.requestAsPost(SIMerchantList.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_MERCHANT_LIST));
		//System.out.println("被扫支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIPay.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_PAY));
		//System.out.println("被扫支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIPayQuery.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_PAY_QUERY));
		//System.out.println("主扫支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIPrecreateNative.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_PRECREATE));
	}

	//public static void main(String[] args) {

		//主扫支付
		//System.out.println("主扫支付API===服务器端返回res====="+Main_QuickIn.requestAsPost(SIPrecreateNative.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_PRECREATE));



		//公众号&小程序支付API
		//pay();


		//订单查询
		//orderFormSelect();

	//}

	static void orderFormSelect(){

	}

	static void pay(){
		System.out.println(Main_QuickIn.requestAsPost(SIPrecreateJSAPI.getReqparas(),ComConstant_QuickIn.SERVICEURL_NEWSI_PRECREATE));
	}
	
}
