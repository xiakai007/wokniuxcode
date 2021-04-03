package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

@Data
@Excel("学生作业信息表")
public class HomeworkExport {


    /**
     *批次名
     */
    @TableField("BATCH_NAME")
    @ExcelField(value = "批次")
    private String batchName;
    /**
     *学生姓名
     */
    @TableField("STU_NAME")
    @ExcelField(value = "姓名")
    private String stuName;
    /**
     * 身份证号
     */
    @TableId(value = "IDENTITY")
    @ExcelField(value = "身份证")
    private String identity;
    /**
     * 学习形式
     */
    @TableField("studyType")
    @ExcelField("学习形式")
    private String studyType;

    /**
     * 电话
     */
    @TableField("TEL")
    @ExcelField(value = "电话")
    private String tel;

    /**
     *院校
     */
    @TableField("collegeName")
    private String collegeName;
    /**
     *层次名
     */
    @TableField("levelName")
    private String levelName;

    /**
     * 专业名
     */
    @TableField("majorName")
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
     * 是否通过
     */
    @TableField("ispassName")
    @ExcelField(value = "是否通过（通过/未过）")
    private String ispassName;
    /**
     * 备注
     */
    @TableField("remark")
    @ExcelField(value = "备注")
    private String remark;

}
