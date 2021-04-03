package cc.zy.base.common.paymentUtils.test;

import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.util.MD5Utils;
import cc.zy.base.common.paymentUtils.util.NumberUtil;
import cc.zy.base.common.paymentUtils.util.SignUtil_QuickIn;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class TestMd5 {



    public static void main(String[] args) throws NoSuchAlgorithmException {


        //6位随机数
//        for (int i = 0; i < 100; i++) {
//            System.out.println((int)((Math.random()*9+1)*100000));
//        }



//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        long l = System.currentTimeMillis();
//        System.out.println("毫秒数===》"+l);
//        String format = sdf.format(l);
//        System.out.println("排版后====>"+format);


        //javamd5();
        //0787d5e1f653ef9a182fbe45d59c550d
        //liantuofu();
        //38b43f958d3b1c08ac3ec9d265dbfbfc
        //System.out.println(System.currentTimeMillis());
    }





    static void liantuofu(){
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
        paras.put("random", "liantuo123");//随机数
        paras.put("merchantCode", "EW_N3569696496");//商户编号
        paras.put("refundNo", "TK2021020109311505742723");//退款订单号

        String sign = SignUtil_QuickIn.createSign(paras, ComConstant_QuickIn.PARTER_KEY, ComConstant_QuickIn.INPUT_CHARSET);
//        paras.put("sign", SignUtil_QuickIn.createSign(paras,null ,ComConstant_QuickIn.INPUT_CHARSET));
//        String sign = SignUtil_QuickIn.createSign(paras, null, ComConstant_QuickIn.INPUT_CHARSET);
        System.out.println(sign);
    }

    static void javamd5() throws NoSuchAlgorithmException {
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("appId", ComConstant_QuickIn.APPID);//合作方标识
        paras.put("random", "liantuo123");//随机数
        paras.put("merchantCode", "EW_N3569696496");//商户编号
        paras.put("refundNo", "TK2021020109311505742723");//退款订单号

        String s = MD5Utils.stringToMD5(paras, ComConstant_QuickIn.PARTER_KEY);
        System.out.println(s);

//        MessageDigest md = MessageDigest.getInstance("MD5");
//        // java自带工具包MessageDigest
//        String resultString = MD5Utils.stringToMD5("random=liantuo123&key=7cf7ba6e3ebb8a5f8b8c769aa0a26f4b");
//        System.out.println(resultString);
//        // e10adc3949ba59abbe56e057f20f883e
//        String resultString1 = MD5Utils.stringToMD5("random=liantuo123&key=7cf7ba6e3ebb8a5f8b8c769aa0a26f4b");
//        System.out.println(resultString1);
//        //81dc9bdb52d04dc20036dbd8313ed055
//
//        // spring自带工具包DigestUtils
//        System.out.println(DigestUtils.md5DigestAsHex("random=liantuo123&key=7cf7ba6e3ebb8a5f8b8c769aa0a26f4b".getBytes()));
//        // 81dc9bdb52d04dc20036dbd8313ed055

    }
}
