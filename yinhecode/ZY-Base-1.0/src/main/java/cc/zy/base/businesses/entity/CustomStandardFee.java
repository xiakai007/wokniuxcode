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
 * @date 2021-01-29 13:11:58
 */
@Data
@TableName("t_custom_standard_fee")
public class CustomStandardFee {

    /**
     * 自定义套内缴费表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 外键（批次表t_batch批次id）
     */
    @TableField("BATCH_ID")
    private Integer batchId;

    /**
     * 外键（字典表t_dic培养方式id）
     */
    @TableField("CULTIVATE")
    private Integer cultivate;

    /**
     * 外键（学校表t_college学校id）
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;

    /**
     * 外键（层次表t_study_level层次id）
     */
    @TableField("STUDY_LEVEL_ID")
    private Integer studyLevelId;

    /**
     * 外键（院校类别表t_subject_category类别id）
     */
    @TableField("SUBJECT_CATEGORY_ID")
    private Integer subjectCategoryId;

    /**
     * 外键（专业表t_marjor专业id）
     */
    @TableField("MAJOR_ID")
    private Integer majorId;

    /**
     * 费用说明（给什么缴费）
     */
    @TableField("PAYMENT_EXPLAIN")
    private String paymentExplain;

    /**
     * 应缴金额
     */
    @TableField("ORIGINAL_PRICE")
    private BigDecimal originalPrice;

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


}
