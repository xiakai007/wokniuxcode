package cc.zy.base.businesses.entity;

import java.util.Date;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 学科类别表 Entity
 *
 * @author guozhikun
 * @date 2021/01/25
 */
@Data
@Excel("专业类别")
@TableName("t_subject_category")
public class SubjectCategory {

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 全称
     */
    @ExcelField(value = "类别全称")
    @TableField("FULL_NAME")
    private String fullName;

    /**
     * 简称
     */
    @ExcelField(value = "简称")
    @TableField("SIMPLE_NAME")
    private String simpleName;

    /**
     * 创建人id，关联t_user的id
     */
    @TableField("CREATE_USER_ID")
    private Integer createUserId;

    /**
     * 创建时间
     */
    @ExcelField(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 备注
     */
    @ExcelField(value = "备注")
    @TableField("REMARK")
    private String remark;


    /**
     * 创建人名称
     */
    @ExcelField(value = "创建人名称")
    @TableField(exist = false)
    private String userName;
}
