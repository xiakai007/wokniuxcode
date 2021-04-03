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
 * 通知人表 Entity
 *
 * @author guozhikun
 * @date 2021/01/27
 */
@Data
@Excel("通知详情")
@TableName("t_notice_user")
public class NoticeUser {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 外键通知表id, 表名t_notice
     */
    @TableField("NOTICE_ID")
    private Integer noticeId;

    /**
     * 关联学生id, 表 t_student的id
     */
    @TableField("USER_ID")
    private Integer userId;

    /**
     * 阅读时间
     */
    @TableField("READ_TIME")
    private Date readTime;

    /**
     * 阅读状态，字典表t_dic,1.已阅读，2.未阅读
     */
    @TableField("READ_STATUS_ID")
    private Integer readStatusId;


    @ExcelField(value = "学生名字")
    @TableField(exist = false)
    private String stuName;

    @ExcelField(value = "学生电话")
    @TableField(exist = false)
    private String tel;

    @ExcelField(value = "状态名字")
    @TableField(exist = false)
    private String detail;

    /**
     * 班级唯一编码
     */
    @ExcelField(value = "班级唯一编码")
    @TableField(exist = false)
    private String className;

    @ExcelField(value = "邮箱")
    @TableField(exist = false)
    private String ematl;

    @ExcelField(value = "身份证号")
    @TableField(exist = false)
    private String identity;

    @ExcelField(value = "地址")
    @TableField(exist = false)
    private String address;

}
