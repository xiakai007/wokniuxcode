package cc.zy.base.businesses.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author LiXu
 * @date 2021/01/25
 */
@Data
@TableName("t_resolve_exception")
public class ResolveException {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("REQ_INFO_ID")
    private Integer reqInfoId;

    /**
     * 
     */
    @TableField("EXCEPTION_TIME")
    private Timestamp exceptionTime;

    /**
     * 
     */
    @TableField("EXCEPTION_INFO")
    private String exceptionInfo;

    /**
     * 
     */
    @TableField("REQ_USER_ID")
    private Long reqUserId;

    /**
     * 
     */
    @TableField("TRIGGER_TYPE")
    private Integer triggerType;


    /**
     *联合查询时得到的使用者名称
     */

    private String userName;


    /**
     *联合查询时得到的字典表具体字段信（触发方式）
     */

    private String detail;
}
