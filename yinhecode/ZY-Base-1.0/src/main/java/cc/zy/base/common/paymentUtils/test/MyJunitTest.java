package cc.zy.base.common.paymentUtils.test;
import cc.zy.base.businesses.mapper.IPaymentMapper;
import cc.zy.base.businesses.service.IPaymentService;
import cc.zy.base.common.paymentUtils.entity.LianTuoFuParam;
import cc.zy.base.common.paymentUtils.entity.RefundStatu;
import cc.zy.base.common.paymentUtils.util.MD5Utils;
import cc.zy.base.common.paymentUtils.util.NumberUtil;
import cc.zy.base.system.entity.User;
import com.alibaba.fastjson.JSONObject;
import com.mchange.util.StringObjectMap;
import org.apache.http.entity.mime.content.StringBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@PropertySource(value = "classpath:application-payment.yml")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyJunitTest {

//    @Autowired
//    private LianTuoFuParam liantuofuVo;
//    @Autowired
//    private NumberUtil numberUtil;
//    @Value("${liantuofu.prefixOutTradeNo}")
//    private String prefixOutTradeNo;
    @Autowired
    private IPaymentService iPaymentService;

    @Autowired
    private IPaymentMapper iPaymentMapper;

    @Test
    public void test3(){
        String openId="oHucvv64jHMx6hXbPRIdI2FXI_i4";
        String goodsDetail="[ { “goodsId”: “1”, “goodsName”: “可乐”, “price”: 3, “quantity”: 1 } ]}";
        String subject="o232323232323dfd11";
        String s = iPaymentService.miniProgramPay(openId, goodsDetail, subject);
        System.out.println(s);
    }


    @Test
    public void test4(){
//        String outTradeNo="2021020314370160518127";
//        iPaymentService.refundByOutTradeNoForAbsentee(outTradeNo);
    }

    @Test
    public void test5() throws ParseException {
        User user = new User();
        user.setUserId(6L);
        String s = iPaymentService.refundByOutTradeNoForAbsentee(user, 8);
        System.out.println(s);
    }

    @Test
    public void test6(){
        Map<String, Object> map = iPaymentMapper.searchOutTradeNoAndCostMoney(1);
        String out_trade_no = (String)map.get("OUT_TRADE_NO");
        String cost_money = (BigDecimal)map.get("COST_MONEY")+"";
        System.out.println(out_trade_no+"===>"+cost_money);
    }

    @Test
    public void test7(){
        String refundNo = "LS-TK20210204193109716632";
        String s = iPaymentService.refundStatuSearchByRefundNo(refundNo);
        System.out.println(s);
    }

    @Test
    public void test8(){
        String beginTime="20210203000000";
        String endTime="20210204000000";
        String s = iPaymentService.paymentOrderSearchByTime(beginTime, endTime);
        System.out.println(s);
    }

    @Test
    public void test9() throws ParseException {
        String strTime = "20210204170543";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parse = sdf.parse(strTime);
        Timestamp timestamp = new Timestamp(parse.getTime());

    }

    @Test
    public void test10(){
        List<Map<String, Object>> maps = iPaymentService.refundApplyListForFinanace();
//        for (Map<String, Object> map : maps) {
//            Set<Map.Entry<String, Object>> entries = map.entrySet();
//            for (Map.Entry<String, Object> entry : entries) {
//                System.out.println(entry.getKey()+"====>"+entry.getValue());
//            }
//        }
        System.out.println(maps);
    }

//    @Test
//    public void test() {
//        System.out.println(liantuofuVo.toString());
//    }

//    @Test
//    public void test1(){
//        //测试订单号生成
//
//        String outTradeNo = numberUtil.createOutTradeNo();
//        System.out.println("接收到的返回值："+outTradeNo);//LS20210202195129374339
//    }
//
//    @Test
//    public void test2(){
//       //测试退款单号生成
//        String refundNo = numberUtil.createRefundNo();
//        System.out.println(refundNo);
//    }
}
