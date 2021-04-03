package cc.zy.base.common.paymentUtils.util;

import cc.zy.base.common.paymentUtils.entity.LianTuoFuParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 订单编号和退款编号生成工具类-Lee
 * Created by Lee on 2021/2/2
 *
 */

public class NumberUtil {



    //创建商户订单号
    public static String createOutTradeNo(String prefixOutTradeNo){
        StringBuffer sb = new StringBuffer();
        sb.append(prefixOutTradeNo);//添加前缀

        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        long l = System.currentTimeMillis();
        System.out.println("毫秒数===》"+l);
        String format = sdf.format(l);
        System.out.println("排版后====>"+format);
        sb.append(format);//添加时间年月日时分秒yyyyMMddHHmmss

        //6位随机数
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        sb.append(random);//添加末尾6位随机数

        String s = sb.toString();
        System.out.println(s);


        return s;
    }



    //创建退款订单号
    public static String createRefundNo(String prefixRefundNo){
        StringBuffer sb = new StringBuffer();
        sb.append(prefixRefundNo);//添加前缀

        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        long l = System.currentTimeMillis();
        System.out.println("毫秒数===》"+l);
        String format = sdf.format(l);
        System.out.println("排版后====>"+format);
        sb.append(format);//添加时间年月日时分秒yyyyMMddHHmmss

        //6位随机数
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        sb.append(random);//添加末尾6位随机数

        String s = sb.toString();
        System.out.println(s);


        return s;
    }
}
