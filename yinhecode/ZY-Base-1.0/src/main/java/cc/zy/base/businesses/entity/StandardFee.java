package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  Entity
 *
 * @author Jiangjinlin
 * @date 2021-01-26 15:28:26
 */
@Data
@TableName("t_standard_fee")
@Excel("套内缴费表")
public class StandardFee {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("BATCH_ID")
    private Integer batchId;

    /**
     * 
     */
    @TableField("CULTIVATE")
    private Integer cultivate;

    /**
     * 
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;

    /**
     * 
     */
    @TableField("STUDY_LEVEL_ID")
    private Integer studyLevelId;

    /**
     * 
     */
    @TableField("SUBJECT_CATEGORY_ID")
    private Integer subjectCategoryId;

    /**
     * 
     */
    @TableField("MAJOR_ID")
    private Integer majorId;

    /**
     * 
     */
    @TableField("PAYMEN_EXPLAIN")
    private String paymenExplain;

    /**
     * 
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

                /**
     *
     */
    @ExcelField(value = "报名费")
    @TableField(exist = false)
    private BigDecimal entryFee;
                /**
     *
     */
    @ExcelField(value = "第一学年学费")
    @TableField(exist = false)
    private BigDecimal firstFee;
                /**
     *
     */
    @ExcelField(value = "第二学年学费")
    @TableField(exist = false)
    private BigDecimal secondFee;
                /**
     *
     */
    @ExcelField(value = "第三学年学费")
    @TableField(exist = false)
    private BigDecimal thirdlyFee;
                    /**
     *
     */
    @ExcelField(value = "第四学年学费")
    @TableField(exist = false)
    private BigDecimal fourthlyFee;
                    /**
     *
     */
    @ExcelField(value = "第五学年学费")
    @TableField(exist = false)
    private BigDecimal fifthFee;
//
//                        /**
//     *
//     */
//    @ExcelField(value = "第五学年学费")
//    @TableField(exist = false)
//    private String[] strs;

}
