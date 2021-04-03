package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

@Data
@Excel("学生学期成绩表")
public class TermExport {


    /**
     * 批次名
     */
    @TableField("BATCH_NAME")
    @ExcelField("批次")
    private String batchName;
    /**
     * 学生姓名
     */
    @TableField("STU_NAME")
    @ExcelField("学生姓名")
    private String stuName;
    /**
     * 身份证号
     */
    @TableField("IDENTITY")
    @ExcelField("身份证")
    private String identity;

    /**
     * 电话
     */
    @TableField("TEL")
    @ExcelField("电话")
    private String tel;
    /**
     * 学习形式
     */
    @TableField("studyType")
    @ExcelField("学习形式")
    private String studyType;

    /**
     * 学校名
     */
    @TableField("collegeName")
    @ExcelField("院校")
    private String collegeName;

    /**
     * 层次
     */
    @TableField("LEVEL_NAME")
    @ExcelField("层次")
    private String levelName;

    /**
     * 专业名
     */
    @TableField("majorName")
    @ExcelField("专业")
    private String majorName;

    /**
     * 学期
     */
    @TableField("termName")
    @ExcelField("学期")
    private String termName;


    /**
     * 课程名称
     */
    @TableField("COURSE_NAME")
    @ExcelField("课程")
    private String courseName;


    /**
     *
     */
    @TableField("ISEXAM")
    @ExcelField(value = "考察课",writeConverterExp = "1=统考,2=自助考")
    private String isexam;

    /**
     * 课程成绩
     */
    @TableField("SCORE")
    @ExcelField("成绩")
    private Integer score;

    /**
     * 考试状态
     */
    @TableField("STATUS")
    @ExcelField(value = "考试状态",writeConverterExp = "1=通过,2=未过,3=缺考,4=其他")
    private String status;
}
