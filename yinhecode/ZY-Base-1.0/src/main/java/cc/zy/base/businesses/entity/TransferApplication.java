package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 学籍异动申请表 Entity
 *
 * @author liuheng
 * @date 2021/01/25
 */
@Data
@TableName("t_transfer_application")
public class TransferApplication {

    /**
     *异动申请id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 班主任id
     */
    @TableField("USER_ID")
    private Long userId;

    /**
     * 学生id
     */
    @TableField("STU_ID")
    private Integer stuId;

    /**
     * 学籍异动类型id
     */
    @TableField("TRANSFER_TYPE_ID")
    private Integer transferTypeId;

    /**
     * 申请时间
     */
    @TableField("APPLICATION_TIME")
    private Date applicationTime;

    /**
     * 审批意见
     */
    @TableField("OPINION")
    private String opinion;

    /**
     * 审批状态id
     */
    @TableField("APPROVAL_STATUS_ID")
    private Integer approvalStatusId;

    /**
     * 审批时间
     */
    @TableField("APPROVAL_TIME")
    private Date approvalTime;

    /**
     * 异动申请原因id
     */
    @TableField("APPLICATION_REASON_ID")
    private Integer applicationReasonId;

    /**
     * 其他原因的补充说明
     */
    @TableField("OTHER_REASON")
    private String otherReason;

    @TableField(exist = false)
    private Student student;
}
