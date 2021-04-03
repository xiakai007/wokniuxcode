package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 班主任变更记录表 Entity
 *
 * @author LiPeng
 * @date 2021-01-27 16:44:35
 */
@Data
@TableName("t_teacher_change_log")
public class TeacherChangeLog {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 班级id
     */
    @TableField("CLASS_ID")
    private Integer classId;

    /**
     * 原班主任id
     */
    @TableField("OLD_USER_ID")
    private Long oldUserId;

    /**
     * 新班主任id
     */
    @TableField("USER_ID")
    private Long userId;

    /**
     * 班级接管时间
     */
    @TableField("CHANGE_TIME")
    private Date changeTime;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 新班主任姓名
     */
    @TableField(exist = false)
    private String userName;

}
