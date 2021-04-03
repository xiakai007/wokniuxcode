package cc.zy.base.businesses.service;

import cc.zy.base.system.entity.User;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 *  联拓富支付接口接口
 *
 * @author 李文龙
 * @date 2021-02-03 05:48:13
 */
public interface IPaymentService {

   String miniProgramPay(String openId,String goodsDetail,String subject);

   String refundByOutTradeNoForAbsentee(User user, Integer Id) throws ParseException;

   String refundStatuSearchByRefundNo(String refundNo);

   String paymentOrderSearchByTime(String billBeginTime,String billEndTime);

   List<Map<String, Object>> refundApplyListForFinanace();
}
