package cc.zy.base.businesses.entity;

import java.io.Serializable;
import java.util.Date;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author huangjia
 * @date 2021/02/01
 */
@Data
@TableName("t_papers")
@Excel("论文初稿信息表")
public class Papers implements Serializable, Cloneable{
    private static final long serialVersionUID = -4352868070794165001L;
    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableId(value = "BATCH_ID", type = IdType.AUTO)
    private String batchId;

    /**
     *
     */
    @TableField("BATCH_NAME")
    @ExcelField(value = "批次")
    private String batchName;

    /**
     *
     */
    @TableField("UNIVERSITY")
    @ExcelField(value = "院校")
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
    @ExcelField(value = "学习形式")
    private String studyType;
    /**
     *
     */
    @TableField("COLLEGELEVEL")
    @ExcelField(value = "层次")
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
    @TableId(value = "STUDY_TYPE_ID", type = IdType.AUTO)
    private String studyTypeId;

    /**
     *
     */
    @TableField("tel")
    @ExcelField(value = "学生电话")
    private String tel;

    /**
     *
     */
    @TableField("SEX_ID")
    @ExcelField(value = "学生性别")
    private String sexId;

    /**
     *
     */
    @TableField("USERNAME")
    @ExcelField(value = "班主任")
    private String userName;


    /**
     *
     */
    @TableField("CHECKSTATUS")
    @ExcelField(value = "审批状态")
    private String checkStatus;

    /**
     * 
     */
    @TableField("FILE")
    @ExcelField(value = "论文")
    private String file;

    /**
     * 
     */
    @TableField("UPLOADTIME")
    @ExcelField(value = "上传时间")
    private Date upLoadTime;



    /**
     * 
     */
    @TableField("REMARK")
    @ExcelField(value = "备注")
    private String remark;

    /**
     *
     */
    @TableField("MAJOR_ID")
    private String majorId;


}
