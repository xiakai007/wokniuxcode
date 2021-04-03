package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author hu
 * @date 2021-01-26 15:46:52
 */
@Data
@TableName("t_stu_label")
public class StuLabel {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签名
     */
    @TableField("LABEL_NAME")
    private String labelName;

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
