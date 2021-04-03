package cc.zy.base.businesses.entity;


import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  Entity
 *
 * @author peizijian
 * @date 2021-01-25 09:38:13
 * * @author huangjia
 *  * @date 2021/02/01
 */
@Data
@TableName("t_teach_program")
@Excel("教学计划表")
public class TeachProgram {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次外键
     */
    @TableField("BATCH_ID")
    private Integer batchId;
    /**
     * 批次名称
     */
    @TableField("batchName")
    @ExcelField(value = "批次")
    private String batchName;
    /**
     * 批次状态
     */
    @TableField("bStatus")
    private String bStatus;

    /**
     * 院校名字
     */
    @ExcelField(value = "院校")
    @TableField(exist = false)
    private String collegeName;
    /**
     * 层次外键
     */
    @TableField("LEVEL_ID")
    private Integer levelId;
    /**
     * 层次名称
     */
    @TableField("LEVEL_NAME")
    @ExcelField(value = "层次")
    private String level;
    /**
     * 类别外键
     */
    @TableField("TYPE_ID")
    private Integer typeId;
    /**
     * 专业类别
     */
    @TableField("typeName")
    @ExcelField(value = "专业类别")
    private String typeName;
    /**
     * 培养方式外键
     */
    @TableField("MODE_ID")
    private Integer modeId;
    /**
     * 培养方式名称
     */
    @TableField("studyMode")
    @ExcelField(value = "培养方式")
    private String studyMode;
    /**
     * 院校外键
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;
  
    /**
     * 专业外键
     */
    @TableField("MAJOR_ID")
    private Integer majorId;


    /**
     * 专业名字
     */
    @ExcelField(value = "专业")
    @TableField(exist = false)
    private String majorName;
    /**
     * 学制外键
     */
    @TableField("SCHOOLING_ID")
    private Integer schoolingId;
    /**
     * 学制名称
     */
    @TableField("school")
    @ExcelField(value = "学制")
    private String school;
    /**
     * 绝对学年外键
     */
    @TableField("ABSO_YEAR_ID")
    private Integer absoYearId;
    /**
     * 绝对学年名称
     */
    @TableField("year")
    @ExcelField(value = "绝对学年")
    private String year;
    /**
     * 绝对学期外键
     */
    @TableField("ABSO_SEM_ID")
    private Integer absoSemId;
    /**
     * 绝对学期名称
     */
    @TableField("semester")
    @ExcelField(value = "绝对学期")
    private String semester;
    /**
     * 课程名称
     */
    @TableField("COURSE_NAME")
    @ExcelField(value = "课程名称")
    private String courseName;

    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 信息拼接
     */
    @TableField("INFO")
    private String info;



}
