package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  Entity
 *
 * @author zzz
 * @date 2021-01-30 15:58:27
 */
@Data
@TableName("t_other_payment")
public class OtherPayment {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次，t_batch批次id外键
     */
    @TableField("BATCH_ID")
    private Integer batchId;

    /**
     * 培养方式，t_dic表外键
     */
    @TableField("CULTIVATE")
    private Integer cultivate;

    /**
     * 院校信息，t_college学校外键
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;

    /**
     * 层次（高起专，专升本），t_study_level层次外键
     */
    @TableField("STUDY_LEVEL_ID")
    private Integer studyLevelId;

    /**
     * 院校类别(文史/理工..)，t_subject_category外键
     */
    @TableField("SUBJECT_CATEGORY_ID")
    private Integer subjectCategoryId;

    /**
     * 专业，t_marjor外键
     */
    @TableField("MAJOR_ID")
    private Integer majorId;

    /**
     * 学生信息,t_student外键
     */
    @TableField("STU_ID")
    private Integer stuId;

    /**
     * 支付说明/备注
     */
    @TableField("PAYMENT_EXPLAIN")
    private String paymentExplain;

    /**
     * 应缴金额
     */
    @TableField("ORIGINAL_PRICE")
    private BigDecimal originalPrice;
    /**
     * 状态值（0：已删；1：位未删），如果已缴费，不删
     */
    @TableField("STATUS")
    private Integer status;
        /**
     *
     */
    @ExcelField(value = "批次名称")
    @TableField(exist = false)
    private String batchname;
          /**
     *
     */
    @ExcelField(value = "院校名称")
    @TableField(exist = false)
    private String collegeName;
          /**
     *
     */
    @ExcelField(value = "层次名称")
    @TableField(exist = false)
    private String levelName;
          /**
     *
     */
    @ExcelField(value = "培养方式名称")
    @TableField(exist = false)
    private String cultivateName;
           /**
     *
     */
    @ExcelField(value = "类别名称")
    @TableField(exist = false)
    private String subjectcategoryName;

            /**
     *
     */
    @ExcelField(value = "专业名称")
    @TableField(exist = false)
    private String majorname;


           /**
     *
     */
    @ExcelField(value = "学生姓名")
    @TableField(exist = false)
    private String stuName;

               /**
     *
     */
    @ExcelField(value = "身份证号")
    @TableField(exist = false)
    private String identitys;

               /**
     *
     */
    @ExcelField(value = "手机号")
    @TableField(exist = false)
    private String tel;





}
