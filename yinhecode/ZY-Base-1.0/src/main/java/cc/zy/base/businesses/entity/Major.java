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
 * 专业表 Entity
 *
 * @author guozhikun
 * @date 2021/01/26
 */
@Data
@Excel("院校专业")
@TableName("t_major")
public class Major {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 全称
     */
    @ExcelField(value = "专业名称")
    @TableField("FULL_NAME")
    private String fullName;

    /**
     * 简称
     */
    @ExcelField(value = "简称")
    @TableField("SIMPLE_NAME")
    private String simpleName;

    /**
     * 创建人id
     */
    @ExcelField(value = "创建人")
    @TableField("CREATE_USER_id")
    private Integer createUserId;

    /**
     * 创建时间
     */
    @ExcelField(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 简介
     */
    @ExcelField(value = "简介")
    @TableField("INTRO")
    private String intro;

    /**
     * 备注
     */
    @ExcelField(value = "备注")
    @TableField("REMARK")
    private String remark;

    /**
     * 创建人名称
     */
    @ExcelField(value = "创建人")
    @TableField(exist = false)
    private String userName;

}
