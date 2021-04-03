package cc.zy.base.businesses.entity;


import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import io.swagger.models.auth.In;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author peizijian
 * @date 2021-01-30 15:54:27
 */
@Data
@TableName("t_homework")
@Excel("学生作业信息表")
public class Homework {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 联合主键_批次
     */
    @TableId(value = "BATCH_ID", type = IdType.AUTO)
    private String batchId;

    /**
     * 学校ID
     */
    @TableField("collegeId")
    private String collegeId;
    /**
     * 层次id
     */
    @TableField("levelId")
    private String levelId;
    /**
     * 学习形式
     */
    @TableField("studyType")
    private String studyType;
    /**
     * 批次名
     */
    @TableField("BATCH_NAME")
    @ExcelField(value = "批次")
    private String batchName;
    /**
     * 学生姓名
     */
    @TableField("STU_NAME")
    @ExcelField(value = "姓名")
    private String stuName;

    /**
     * 联合主键_学生身份证
     */
    @TableId(value = "IDENTITY")
    @ExcelField(value = "身份证号")
    private String identity;
    /**
     * 电话
     */
    @TableField("TEL")
    @ExcelField(value = "手机号")
    private String tel;
    /**
     * 学校名
     */
    @TableField("collegeName")
    @ExcelField(value = "院校")
    private String collegeName;
    /**
     * 层次
     */
    @TableField("LEVEL_NAME")
    @ExcelField(value = "层次")
    private String levelName;
    /**
     * 专业名Id
     */
    @TableField("majorId")
    private String majorId;
    /**
     * 专业名
     */
    @TableField("majorName")
    @ExcelField(value = "专业")
    private String majorName;
    /**
     * 作业科目名称
     */
    @TableField("COURSE_NAME")
    @ExcelField(value = "科目")
    private String courseName;
    /**
     * 学年名称
     */
    @TableField("yearName")
    @ExcelField(value = "学年")
    private String yearName;
    /**
     * 学期
     */
    @TableField("termName")
    @ExcelField(value = "学期")
    private String termName;
    /**
     * 联合主键_学习类型
     */
    @TableId(value = "STUDY_TYPE_ID", type = IdType.AUTO)
    private String studyTypeId;

    /**
     * 学生表外键
     */
    @TableField("STUDENT_ID")
    private Integer studentId;



    /**

     * 作业科目外键
     */
    @TableField("COURSE_ID")
    private Integer courseId;



    /**
     * 线上视频应看次数
     */
    @TableField("VIDEO_SH")
    @ExcelField(value = "线上视频总次数")
    private Integer videoSh;

    /**
     * 线上视频已看次数
     */
    @TableField("VIDEO_AL")
    @ExcelField(value = "线上视频已看次数")
    private Integer videoAl;

    /**
     * 线上视频已看次数
     */
    @TableField("VIDEO_SCORE")
    @ExcelField(value = "线上视频分数")
    private Integer videoScore;

    /**
     * 课后答题总次数
     */
    @TableField("TEST_SH")
    @ExcelField(value = "课后答题总次数")
    private Integer testSh;

    /**
     * 课后答题总次数
     */
    @TableField("TEST_AL")
    @ExcelField(value = "课后答题已答次数")
    private Integer testAl;

    /**
     * 课后答题分数
     */
    @TableField("TEST_SCORE")
    @ExcelField(value = "课后答题分数")
    private Integer testScore;

    /**
     * 纸质作业总次数
     */
    @TableField("WRI_SH")
    @ExcelField(value = "纸质作业总次数")
    private Integer wriSh;

    /**
     * 纸质作业已完成次数
     */
    @TableField("WRI_AL")
    @ExcelField(value = "纸质作业已完成次数")
    private Integer wriAl;

    /**
     * 纸质作业分数
     */
    @TableField("WRI_SCORE")
    @ExcelField(value = "纸质作业分数")
    private Integer wriScore;

    /**
     * 学年外键
     */
    @TableField("YEAR_ID")
    private Integer yearId;

    /**
     * 学期外键
     */
    @TableField("TERM_ID")
    private Integer termId;

    /**
     * 是否通过外键
     */
    @TableField("ISPASS")
    private Integer ispass;
    /**
     * 是否通过
     */
    @TableField("ispassName")
    @ExcelField(value = "是否通过")
    private String ispassName;

    /**
     * 是否通过
     */
    @TableField("REMARK")
    @ExcelField(value = "备注")
    private String remark;

    /**
     * 在线答题数量
     */
    @TableField("ONLINE_WORK_COUNT")
    private Integer onlineWorkCount;

    /**
     * 已看视频课数量
     */
    @TableField("VIDEO_COUNT")
    private Integer videoCount;
    /**
     * excel表格行号
     */
    private Integer row;

}
