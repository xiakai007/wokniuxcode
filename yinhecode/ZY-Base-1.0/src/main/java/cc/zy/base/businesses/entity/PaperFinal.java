package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity
 *
 * * @author huangjia
 *  * @date 2021/02/01
 */
@Data
@TableName("t_paperfinal")
@Excel("论文终稿信息表")
public class PaperFinal implements Serializable, Cloneable {
    private static final long serialVersionUID = -4352868070794165001L;
    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次ID
     */
    @TableId(value = "BATCH_ID", type = IdType.AUTO)
    private String batchId;


    /**
     *
     */
    @TableField("BATCH_NAME")
    @ExcelField("批次")
    private String batchName;

    /**
     *
     */
    @TableField("UNIVERSITY")
    @ExcelField("院校")
    private String university;
    /**
     *
     */
    @TableField("COLLEGE_ID")
    private String collegeId;
    /**
     *
     */
    @TableField("STUDYTYPE")
    @ExcelField("学习形式")
    private String studyType;

    /**
     * 学习形式id
     */
    @TableId(value = "STUDY_TYPE_ID", type = IdType.AUTO)
    private String studyTypeId;
    /**
     *
     */
    @TableField("COLLEGELEVEL")
    @ExcelField("层次")
    private String collegeLevel;
    /**
     *
     */
    @TableField("LEVEL")
    @ExcelField(value = "层次Id")
    private String levelId;
    /**
     *
     */
    @TableField("MAJOR_ID")
    private String majorId;


    @TableField("FULL_NAME")
    @ExcelField(value = "专业")
    private String majorName;
    /**
     *
     */
    @TableField("STU_NAME")
    @ExcelField(value = "学生姓名")
    private String stuName;
    /**
     *
     */
    @TableField(value = "IDENTITY")
    @ExcelField(value = "身份证证号")
    private String identity;

    /**
     *
     */
    @TableField("TEL")
    @ExcelField(value = "手机号")
    private String tel;

    /**
     *
     */
    @TableField("SEX_ID")
    @ExcelField(value = "性别")
    private String sexId;

    /**
     *
     */
    @TableField("USERNAME")
    @ExcelField(value = "班主任")
    private String userName;

    /**
     * 文件地址
     */
    @TableField("FILE")
    private String file;

    /**
     * 论文状态
     */
    @TableField("PASSSTATUS")
    @ExcelField(value = "审核状态")
    private String passStatus;

    /**
     * 上传日期
     */
    @TableField("UPDATETIME")
    @ExcelField(value = "上传时间")
    private Date updatetime;

    /**
     * 审核日期
     */
    @TableField("CHECKTIME")
    @ExcelField(value = "审批时间")
    private Date checktime;


    /**
     * 备注
     */
    @TableField("REMARK")
    @ExcelField(value = "备注")
    private String remark;
}
