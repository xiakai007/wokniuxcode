package cc.zy.base.common.paymentUtils.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  Entity发起退款调用联拓富接口返回json转换实体类，对应t_return_refund表
 *
 * @author Lee
 * @date 2021-02-04 15:51:13
 */
@Data
@TableName("t_return_refund_statu_search")
@Excel("接口返回退费结果明细表")
public class RefundDetail {
    @TableId(value = "ID", type = IdType.AUTO)
    @ExcelField(value = "主键")
    private Integer id;

    @TableField("OUT_TRADE_NO")
    @ExcelField(value = "商户订单号")
    private String outTradeNo;

    @TableField("REFUND_NO")
    @ExcelField(value = "退款订单号")
    private String refundNo;

    @TableField("REFUND_AMOUNT")
    @ExcelField(value = "退款金额")
    private BigDecimal refundAmount;

    @TableField("REFUND_FEE")
    @ExcelField(value = "第三方手续费退款金额")
    private BigDecimal refundFee;

    @TableField("TIME")
    @ExcelField(value = "退费完成时间，交易完成时间,格式为 yyyyMMddHHmmss")
    private String time;

    @TableField("CODE")
    @ExcelField(value = "结果，退款结果 SUCCESS：表示退款申请成功 FAILED：表示退款申请失败")
    private String code;

    @TableField("MSG")
    @ExcelField(value = "结果描述，无论是成功或者失败，message都会针对于当前的结果返回响应的结果描述")
    private String msg;

    @TableField("SIGN")
    @ExcelField(value = "请求时传递的sign，md5生成")
    private String sign;

    @TableField("EXT1")
    @ExcelField(value = "备用列1")
    private String ext1;

    @TableField("EXT2")
    @ExcelField(value = "备用列2")
    private String ext2;

    @TableField("EXT3")
    @ExcelField(value = "备用列3")
    private String ext3;

    @TableField("EXT4")
    @ExcelField(value = "备用列4")
    private String ext4;

    @TableField("EXT5")
    @ExcelField(value = "备用列5")
    private String ext5;

    @TableField("EXT6")
    @ExcelField(value = "备用列6")
    private String ext6;

    @TableField("EXT7")
    @ExcelField(value = "备用列7")
    private String ext7;

    @TableField("EXT8")
    @ExcelField(value = "备用列8")
    private String ext8;

    @TableField("EXT9")
    @ExcelField(value = "备用列9")
    private String ext9;

    @TableField("EXT10")
    @ExcelField(value = "备用列10")
    private String ext10;



}
