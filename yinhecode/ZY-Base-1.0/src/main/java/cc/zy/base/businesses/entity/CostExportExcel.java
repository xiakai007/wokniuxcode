package cc.zy.base.businesses.entity;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

/**
 * 该类主要cost.html客户选择条件导出excel的封装
 *
 * @author guozhaodi
 * @date 2021-02-04 11:45:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Excel("缴费信息表")
public class CostExportExcel {

    /**
     * 批次
     */
    @ExcelField(value = "批次")
    private String batchname;
    /**
     * 学生姓名
     */
    @ExcelField(value = "学生姓名")
    private String stuname;
    /**
     * 性别
     */
    @ExcelField(value = "性别")
    private String sex;
    /**
     * 院校
     */
    @ExcelField(value = "院校")
    private String collegename;

    /**
     * 层次
     */
    @ExcelField(value = "层次")
    private String level;
    /**
     * 类别
     */
    @ExcelField(value = "类别")
    private String category;
    /**
     * 专业
     */
    @ExcelField(value = "专业")
    private String profession;
    /**
     * 班级
     */
    @ExcelField(value = "班级")
    private String classname;
    //学籍状态
    //类型（报名费）
    //是否交费
    /**
     * 优惠套餐
     */
    @ExcelField(value = "优惠套餐")
    private String promotionname;

    /**
     * 优惠金额
     */
    @ExcelField(value = "优惠金额")
    private String policy;

    /**
     * 实缴金额
     */
    @ExcelField(value = "实缴金额")
    private Double costmoney;
    /**
     * 缴费日期
     */
    @ExcelField(value = "缴费日期")
    private String costtime;
    /**
     * 学生电话
     */
    @ExcelField(value = "学生电话")
    private String tel;

    /**
     * 紧急联系电话
     */
    @ExcelField(value = "紧急联系电话")
    private String urgencytel;
    /**
     * 学习形式
     */
    @ExcelField(value = "学习形式")
    private String waysoflearning;
    /**
     * 原价
     */
    @ExcelField(value = "原价")
    private Double originalprice;










}
