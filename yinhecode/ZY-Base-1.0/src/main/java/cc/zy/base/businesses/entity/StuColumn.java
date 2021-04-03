package cc.zy.base.businesses.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  Entity
 *
 * @author zzz
 * @date 2021-01-29 16:15:15
 */
@Data
@TableName("t_stu_column")
public class StuColumn {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签名
     */
    @TableField("COLUMN_NAME")
    private String columnName;

    /**
     * 标签创建人id
     */
    @TableField("CREATE_USER_ID")
    private Integer createUserId;

    /**
     * 查询条件（json）
     */
    @TableField("CONDITION_CONTENT")
    private String conditionContent;

}
