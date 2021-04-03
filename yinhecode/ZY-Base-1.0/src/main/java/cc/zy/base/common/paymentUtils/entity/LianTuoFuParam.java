package cc.zy.base.common.paymentUtils.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@PropertySource(value = "classpath:application-payment.yml")
@ConfigurationProperties(prefix = "liantuofu")
@Component
@Data
@ToString
public class LianTuoFuParam {
    //合作方标识
    private String appId;

    //商户编号，集合
    private String[] merchantCode;

    //密钥
    private String key;

    //小程序/公众号支付Url
    private String miniProgramUrl;

    //订单批量查询Url
    private String orderSearchUrl;

    //已支付订单进行退款Url
    private String refundUrl;

    //根据退款订单号查询退款状态Url
    private String refundStatuUrl;

    //订单号前缀
    private String prefixOutTradeNo;

    //退款订单号前缀
    private String prefixRefundNo;


}
