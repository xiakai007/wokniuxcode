package cc.zy.base.businesses.entity;

import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author zzz
 * @date 2021-02-03 16:29:47
 */
@Data
@TableName("t_absentee_cost")
public class AbsenteeCost {

    /**
     * 缴费表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户订单号，由商户生成的该笔交易的全局唯一ID，商户需确保其唯一性，重新发起一笔支付要使用新订单号，避免重复支付。后续可通过该ID查询对应订单信息。 建议值：公司简称+门店编号+时间戳+序列 支持8-64位数字、英文字母、“-”及“_”，其他字符不支持
     */
    @TableField("OUT_TRADE_NO")
    private String outTradeNo;

    /**
     * 学生表t_student外键
     */
    @TableField("STU_ID")
    private Integer stuId;

    /**
     * 套内、自定义套内、其他缴费3选1，1套内，2自定义套内，3其他
     */
    @TableField("COST_TYPE_ID")
    private Integer costTypeId;

    /**
     * 关联对应表的id列,根据cost_type_id列进行筛选
     */
    @TableField("DATA_ID")
    private Integer dataId;

    /**
     * 实缴金额
     */
    @TableField("COST_MONEY")
    private BigDecimal costMoney;
    /**
     * 支付时间
     */
    @TableField("COST_TIME")
    private Date costTime;

    /**
     * 外键，缴费状态，字典表t_dic
     */
    @TableField("STATUS")
    private Integer status;

}
