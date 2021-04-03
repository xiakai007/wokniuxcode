package cc.zy.base.common.paymentUtils.example_quickIn;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;

import java.util.HashMap;
import java.util.Map;

/**
 * 秘钥信息下载
 * Created by LVHUIHUI on 2018-8-6
 *
 */
public class SILogin {
	
	public static Map getReqparas(){
    	Map<String, String> paras = new HashMap<String, String>();
    	paras.put("userName", "xscszh");//用户名
    	paras.put("passWord", "111qqq");//密码
	    return paras;
   }
	
	public static void main(String[] args)  { 
		System.out.println("秘钥信息下载===服务器端返回res====="+Main_QuickIn.requestAsPost(SILogin.getReqparas(), ComConstant_QuickIn.SERVICEURL_NEWSI_LOGIN));
	}
}
