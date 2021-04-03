package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 *  Entity
 *
 * @author hu
 * @date 2021-01-25 11:42:38
 */
@Data
@TableName("t_cost")
public class Cost {

    /**
     * 
     */
    @TableId(value = "COST_ID", type = IdType.AUTO)
    private Integer costId;

    /**
     * 
     */
    @TableField("STUDENT_ID")
    private Integer studentId;

    /**
     * 
     */
    @TableField("COST_TYPE_ID")
    private Integer costTypeId;

    /**
     * 
     */
    @TableField("TYPE_RELEVANCE_ID")
    private Integer typeRelevanceId;

    /**
     * 
     */
    @TableField("COST_TIME")
    private Date costTime;

    /**
     * 
     */
    @TableField("SEAL_ID")
    private Integer sealId;

    /**
     * 
     */
    @TableField("STATUS")
    private Integer status;

}
