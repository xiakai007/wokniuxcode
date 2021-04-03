package cc.zy.base.common.paymentUtils.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *  Entity在籍退费表实体类，对应t_return_refund表
 *
 * @author Lee
 * @date 2021-02-05 14:13:13
 */
@Data
@TableName("t_absentee_refund")
@Excel("退费表对应的实体类")
public class AbsenteeRefund {
    @TableId(value = "ID", type = IdType.AUTO)
    @ExcelField(value = "主键")
    private Integer id;

    @TableField("REFUND_NO")
    @ExcelField(value = "退款单号")
    private String refundNo;

    @TableField("STU_ID")
    @ExcelField(value = "在籍学生表外键")
    private String stuId;

    @TableField("USER_FINANCE_ID")
    @ExcelField(value = "财务员工id")
    private String userFinanceId;

    @TableField("USER_TEACHER_ID")
    @ExcelField(value = "教师员工id")
    private String userTeacherId;

    @TableField("REFUND_TIME")
    @ExcelField(value = "退款成功时间，来自接口")
    private Timestamp refundTime;

    @TableField("REFUND_MODE")
    @ExcelField(value = "退款渠道")
    private Integer refundMode;

    @TableField("COST_ID")
    @ExcelField(value = "在籍缴费表id")
    private Integer costId;

    @TableField("REFUND_MONEY")
    @ExcelField(value = "退费金额")
    private BigDecimal refundMoney;

    @TableField("APPLY_REFUND_TIME")
    @ExcelField(value = "学生退费申请时间")
    private Timestamp applyRefundTime;

    @TableField("TEACHER_AGREE_TIME")
    @ExcelField(value = "班主任同意退费申请时间")
    private Timestamp teacherAgreeTime;

    @TableField("FINANCE_AGREE_TIME")
    @ExcelField(value = "财务同意退费申请时间")
    private Timestamp financeAgreeTime;

    @TableField("TEACHER_AGREE_STATUS")
    @ExcelField(value = "老师审批状态，0未审批,1同意,2驳回")
    private Integer teacherAgreeStatus;

    @TableField("FINANCE_AGREE_STATUS")
    @ExcelField(value = "财务审批状态，0未审批,1同意,2驳回")
    private Integer financeAgreeStatus;

    @TableField("REFUND_REASON")
    @ExcelField(value = "退费原因")
    private String refundReason;

    @TableField("STATUS")
    @ExcelField(value = "该笔退款申请状态，0未退费，1已退费，联拓富成功退费后修改该状态")
    private Integer status;


}
