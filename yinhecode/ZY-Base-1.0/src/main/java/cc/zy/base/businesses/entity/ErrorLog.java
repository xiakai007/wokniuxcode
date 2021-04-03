package cc.zy.base.businesses.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author Jiangjinlin
 * @date 2021-02-03 15:13:46
 */
@Data
@TableName("t_error_log")
public class ErrorLog {

    /**
     * 主键自增
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 错误列
     */
    @TableField("ERROR_COLUMN")
    private Integer errorColumn;

    /**
     * 错误数据行
     */
    @TableField("ERROR_ROW")
    private Integer errorRow;

    /**
     * 错误原因
     */
    @TableField("REASON")
    private String reason;

    /**
     * 错误时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 文件名称
     */
    @TableField("FILE_NAME")
    private String fileName;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 唯一码
     */
    @TableField("UNIQUE")
    private String unique;

}
