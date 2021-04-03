package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.mapper.IPaymentMapper;
import cc.zy.base.businesses.service.IPaymentService;
import cc.zy.base.common.paymentUtils.constant.ComConstant_QuickIn;
import cc.zy.base.common.paymentUtils.entity.LianTuoFuParam;
import cc.zy.base.common.paymentUtils.entity.RefundDetail;
import cc.zy.base.common.paymentUtils.entity.RefundStatu;
import cc.zy.base.common.paymentUtils.example_quickIn.Main_QuickIn;
import cc.zy.base.common.paymentUtils.example_quickIn.SIPrecreateJSAPI;
import cc.zy.base.common.paymentUtils.util.HttpClientUtil;
import cc.zy.base.common.paymentUtils.util.MD5Utils;
import cc.zy.base.common.paymentUtils.util.NumberUtil;
import cc.zy.base.common.paymentUtils.util.SignUtil_QuickIn;
import cc.zy.base.system.entity.User;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  Service支付接口实现
 *
 * @author 李文龙
 * @date 2021-02-03 05:48:13
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IPaymentServiceImpl implements IPaymentService {
    @Autowired
    private LianTuoFuParam lianTuoFuParam;

    @Autowired
    private IPaymentMapper iPaymentMapper;

    /**
     * 联拓富快速接入版
     * @param reqParas
     * @return String
     */
    public static String requestAsPost(Map reqParas,String serverUrl){
        String res = HttpClientUtil.requestAsHttpPOST(serverUrl,reqParas, ComConstant_QuickIn.INPUT_CHARSET,10000,20000);
        return res;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String miniProgramPay(String openId,String goodsDetail,String subject){
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("appId", lianTuoFuParam.getAppId());//合作方标识
        String random =(int) ((Math.random() * 9 + 1) * 100000)+"";
        System.out.println(random);
        paras.put("random", random);//随机数
        paras.put("merchantCode", lianTuoFuParam.getMerchantCode()[0]);//商户编号
        paras.put("outTradeNo", NumberUtil.createOutTradeNo(lianTuoFuParam.getPrefixOutTradeNo()));//商户订单号
        paras.put("totalAmount", "0.11");//订单总金额,！从goodsDetail中拿，再修改
        paras.put("channel", "WXPAY");//支付渠道，微信
        paras.put("tradeType", "JSAPI");//支付交易类型
        paras.put("notifyUrl", "http://192.168.1.6:8080/ibasic/rebackTest");//异步通知地址，微测试
        paras.put("openId", openId);//微信用户标识
        if(subject!=null){
            paras.put("subject", subject);//支付凭证商品描述信息，不填写默认为交易订单编号
        }
        paras.put("goodsDetail", goodsDetail);
        paras.put("sign", MD5Utils.stringToMD5(paras,lianTuoFuParam.getKey()));//生成签名

        String result = requestAsPost(paras, lianTuoFuParam.getMiniProgramUrl());
        return result;
    }



    @Override
    //财务同意退费后，点击同意根据订单号查询在籍缴费表进行退款
    //user指当前对象，Id指t_absentee_refund的主键id
    public String refundByOutTradeNoForAbsentee(User user,Integer id) throws ParseException {
        //通过t_absentee_refund的主键ID查询到COST_ID,再去查询t_absentee_cost在籍缴费表
        Map<String, Object> map = iPaymentMapper.searchOutTradeNoAndCostMoney(id);
        String outTradeNo = (String)map.get("OUT_TRADE_NO");
        String costMoney = (BigDecimal)map.get("COST_MONEY")+"";
        System.out.println(outTradeNo);
        System.out.println(costMoney);

        Map<String, String> paras = new HashMap<String, String>();
        paras.put("appId", lianTuoFuParam.getAppId());//合作方标识
        String random =(int) ((Math.random() * 9 + 1) * 100000)+"";
        paras.put("random", random);//随机数
        paras.put("merchantCode", lianTuoFuParam.getMerchantCode()[0]);//商户编号

        paras.put("outTradeNo", outTradeNo);//商户订单号
        String refundNo = NumberUtil.createRefundNo(lianTuoFuParam.getPrefixRefundNo());
        paras.put("refundNo", refundNo);//退款订单号
        paras.put("refundAmount", costMoney);
        paras.put("sign", MD5Utils.stringToMD5(paras,lianTuoFuParam.getKey()));//生成签名

        //调用联拓富退费接口
        String result = requestAsPost(paras, lianTuoFuParam.getRefundUrl());

        //将返回结果插入数据库
        RefundDetail refundDetail = JSONObject.parseObject(result, RefundDetail.class);
        System.out.println("json转换的实体类"+refundDetail);
        Integer insertDetailResult = iPaymentMapper.insertReturnRefundDetail(refundDetail);

        String strTime = refundDetail.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parse = sdf.parse(strTime);
        Timestamp refundTime = new Timestamp(parse.getTime());
        //给退费表t_absentee_refund添加对应的退费订单号
        long l = System.currentTimeMillis();
        Timestamp fianceAgreeTime = new Timestamp(l);//财务同意时间，当前时间

        Integer agreeStatu = iPaymentMapper.searchAgreeStatu();//财务同意退费的状态值
        Integer refundOkStatu = iPaymentMapper.searchRefundOkStatu();//查询已退费的状态值
        Integer updateRefundNoResult = iPaymentMapper.updateRefundNoById(id, refundNo,refundTime,user.getUserId(),fianceAgreeTime,agreeStatu,refundOkStatu);



        return result;
    }

    //根据退款订单号查询该笔退款状态
    @Override
    public String refundStatuSearchByRefundNo(String refundNo){
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("appId", lianTuoFuParam.getAppId());//合作方标识
        String random =(int) ((Math.random() * 9 + 1) * 100000)+"";
        paras.put("random", random);//随机数
        paras.put("merchantCode", lianTuoFuParam.getMerchantCode()[0]);//商户编号
        paras.put("refundNo", refundNo);//退款订单号
        paras.put("sign", MD5Utils.stringToMD5(paras,lianTuoFuParam.getKey()));
        String result = requestAsPost(paras, lianTuoFuParam.getRefundStatuUrl());

        //根据返回的json，将其添加进数据库t_return_refund_statu_search表
        RefundStatu refundStatu = JSONObject.parseObject(result, RefundStatu.class);
        System.out.println("json转换的实体类"+refundStatu);
        Integer integer = iPaymentMapper.insertRefundStatu(refundStatu);
        if(integer>0){
            return "插入"+integer+"条数据成功"+result;
        }

        return "插入数据失败"+result;
    }


    //根据时间段批量查询订单
    @Override
    public String paymentOrderSearchByTime(String billBeginTime,String billEndTime){
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("appId", lianTuoFuParam.getAppId());//合作方标识
        String random =(int) ((Math.random() * 9 + 1) * 100000)+"";
        paras.put("random", random);//随机数
        paras.put("merchantCode", lianTuoFuParam.getMerchantCode()[0]);//商户编号
        paras.put("billBeginTime", billBeginTime);//查询开始时间
        paras.put("billEndTime", billEndTime);//查询结束时间
        paras.put("sign", MD5Utils.stringToMD5(paras,lianTuoFuParam.getKey()));

        String result = requestAsPost(paras, lianTuoFuParam.getOrderSearchUrl());
        return result;
    }

    public List<Map<String, Object>> refundApplyListForFinanace(){
        Integer agreeStatu = iPaymentMapper.searchAgreeStatu();
        Integer refundNotStatu = iPaymentMapper.searchRefundNotStatu();

        System.out.println("agreeStatu===>"+agreeStatu);
        System.out.println("refundNotStatu===>"+refundNotStatu);
        List<Map<String, Object>> resultList = iPaymentMapper.selectRefundListForFinance(agreeStatu, refundNotStatu);

        return resultList;
    }

}
