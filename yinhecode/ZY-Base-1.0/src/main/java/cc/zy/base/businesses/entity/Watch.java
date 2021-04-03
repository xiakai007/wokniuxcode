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
 * @date 2021-01-25 15:11:02
 */
@Data
@TableName("t_watch")
public class Watch {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("VIDEO_ID")
    private Integer videoId;

    /**
     * 
     */
    @TableField("STU_ID")
    private Integer stuId;

    /**
     * 
     */
    @TableField("START_TIME")
    private Date startTime;

    /**
     * 
     */
    @TableField("END_TIME")
    private Date endTime;

}
