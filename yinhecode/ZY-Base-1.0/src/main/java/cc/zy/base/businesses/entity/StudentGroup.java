package cc.zy.base.businesses.entity;

import cc.zy.base.common.converter.TimeConverter;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.util.Date;

/**
 * 学生组表	 Entity
 *
 * @author LiPeng
 * @date 2021-01-25 15:01:47
 */
@Data
@TableName("t_student_group")
@Excel("学生组信息表")
public class StudentGroup {

    /**
     * id,主键
     */
    @ExcelField(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 批次id
     */
    @TableField("BATCH_ID")
    private Integer batchId;

    /**
     * 批次名
     */
    @ExcelField(value = "批次")
    @TableField(exist = false)
    private String batchName;

    /**
     * 班级编号
     */
    @ExcelField(value = "组名")
    @TableField("GROUP_NO")
    private String groupNo;

    /**
     * 招生老师id
     */
    @TableField("USER_ID")
    private Long userId;

    /**
     * 招生老师名称
     */
    @ExcelField(value = "招生老师")
    @TableField(exist = false)
    private String userName;


    /**
     * 学生数量
     */
    @ExcelField(value = "学生数量")
    @TableField(exist = false)
    private Integer stuNum;

    /**
     * 创建人id
     */
    @TableField("CREATE_USER_ID")
    private Long createUserId;

    /**
     * 创建人名称
     */
    @ExcelField(value = "创建人")
    @TableField(exist = false)
    private String createUserName;

    /**
     * 创建时间
     */
    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "GMT+8")
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 备注
     */
    @ExcelField(value = "备注")
    @TableField("REMARK")
    private String remark;

}
