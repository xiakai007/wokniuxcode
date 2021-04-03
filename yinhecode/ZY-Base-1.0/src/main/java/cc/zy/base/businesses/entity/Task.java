package cc.zy.base.businesses.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  待办任务类
 *
 * @author 刘润雨
 * @date 2021-01-28 17:29:15
 */
@Data
@TableName("t_task")
public class Task {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生表主键id
     */
    @TableField("STU_ID")
    private Integer stuId;

    /**
     * 被修改信息的类型（1：身份证、2：毕业证书、3：照片、4：报考信息）
     */
    @TableField("TYPE_ID")
    private Integer typeId;

    /**
     * 被修改信息的字段。1:报考院校 2：报考类型 3：批次 4：层次 5：专业
     */
    @TableField("FIELD")
    private Integer field;

    /**
     * 字段修改后信息，保存json
     */
    @TableField("AFTER_UPDATE")
    private String afterUpdate;

    /**
     * 学生修改时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 审核时间
     */
    @TableField("AUDIT_TIME")
    private Date auditTime;

    /**
     * 状态 （0：待审核，1审核通过、2审核不通过）
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 记录驳回意见，同意默认显示同意。
     */
    @TableField("REMARK")
    private String remark;

    @TableField(exist = false)
    private String jsonParseInfo;

    @TableField(exist = false)
    private String jsonParseName;
}
