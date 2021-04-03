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
 * 班级表 Entity
 *
 * @author hou
 * @date 2021-01-26 09:37:42
 */
@Data
@TableName("t_classes")
@Excel("班级信息表")
public class Classes {

    /**
     * id 主键
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
     * 批次名称
     */
    @ExcelField(value = "批次")
    @TableField(exist = false)
    private String batchName;

    /**
     * 院校id
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;

    /**
     * 院校名称
     */
    @ExcelField(value = "院校")
    @TableField(exist = false)
    private String collegeName;

    /**
     * 层次id
     */
    @TableField("LEVEL_ID")
    private Integer levelId;

    /**
     * 层次名称
     */
    @ExcelField(value = "层次")
    @TableField(exist = false)
    private String levelName;

    /**
     * 专业id
     */
    @TableField("MAJOR_ID")
    private Integer majorId;

    /**
     * 专业名称
     */
    @ExcelField(value = "专业")
    @TableField(exist = false)
    private String majorName;


    /**
     * 班级唯一编码
     */
    @ExcelField(value = "班级唯一编码")
    @TableField("CLASS_NAME")
    private String className;

    /**
     * 班主任id
     */
    @TableField("USER_ID")
    private Long userId;

    /**
     * 班主任姓名
     */
    @ExcelField(value = "班主任")
    @TableField(exist = false)
    private String userName;

    /**
     * 学生数量
     */
    @ExcelField(value = "总人数")
    @TableField(exist = false)
    private Integer stuNum;

    /**
     * 创建人id
     */
    @TableField("CREATE_USER_ID")
    private Long createUserId;

    /**
     * 创建人姓名
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
    @TableField("REMARK")
    private String remark;

}
