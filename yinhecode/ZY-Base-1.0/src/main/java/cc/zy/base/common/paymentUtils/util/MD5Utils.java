package cc.zy.base.common.paymentUtils.util;

import com.liantuo.front.client.sign.util.MD5Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
/**
 * 自定义加密工具-Lee
 * Created by Lee on 2021/2/1
 *
 */
public class MD5Utils {
    public static String stringToMD5(Map<String, String> paras, String key)  {
        SortedMap<String, String> paraMap = new TreeMap<String, String>();
        paraMap.putAll(paras);
        StringBuffer sb = new StringBuffer();
        Set es = paraMap.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)&& !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        String signString = sb.toString().replaceAll("&$", "&key="+key);
        System.out.println("请求参数是:"+signString);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // java自带工具包MessageDigest
        String resultString = MD5Utils.stringToMD5(signString);
        System.out.println("经过md5加密："+resultString);
        return resultString;
//        return MD5Util.MD5Encode(signString, "UTF-8").toLowerCase();

    }


    private static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}
