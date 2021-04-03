package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.util.List;

@Data
@Excel("学生入学成绩表")
public class EntranceExport {

    /**
     * 序号
     */
    @ExcelField(value = "编号")
    @TableField("ID")
    private Integer id;
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
    @TableId(value = "IDENTITY", type = IdType.AUTO)
    @ExcelField(value = "身份证号")
    private String identity;

    /**
     *院校
     */
    @TableField("collegeName")
    @ExcelField(value = "院校")
    private String collegeName;
    /**
     *层次名
     */
    @TableField("levelName")
    @ExcelField(value = "层次")
    private String levelName;

    /**
     *科目类型
     */
    @TableField("FULL_NAME")
    @ExcelField(value = "科目类型")
    private String fullName;

    /**
     * 最终成绩
     */
    @ExcelField(value = "总分")
    @TableField("FINALSCORE")
    private String finalscore;
    /**
     * 总成绩
     */
    @ExcelField(value = "考试成绩")
    private String totalscore;
    /**
     * 添加成绩加分项
     */
    @TableField("ADDSCOREITEM")
    @ExcelField(value = "成绩加分项")
    private String addscoreitem;
    /*****************************************/
    /**
     *政治
     */
    @TableField("zhengZhi")
    @ExcelField(value = "政治")
    private Double zhengZhi;
    /**
     *英语(专升本)
     */
    @TableField("yingYu2")
    @ExcelField(value = "英语(专升本)")
    private Double yingYu2;

    /**
     *医学综合
     */
    @TableField("yingXueZongHe")
    @ExcelField(value = "医学综合")
    private Double yingXueZongHe;
    /**
     *大学语文
     */
    @TableField("daXueYuwen")
    @ExcelField(value = "大学语文")
    private Double daXueYuwen;
    /**
     *高数一
     */
    @TableField("gaoShu1")
    @ExcelField(value = "高数一")
    private Double gaoShu1;
    /**
     *高数二
     */
    @TableField("gaoShu2")
    @ExcelField(value = "高数二")
    private Double gaoShu2;
    /**
     *生态学基础
     */
    @TableField("shengTaiXue")
    @ExcelField(value = "生态学基础")
    private Double shengTaiXue;
    /**
     *民法
     */
    @TableField("minFa")
    @ExcelField(value = "民法")
    private Double minFa;
    /**
     *教育理论
     */
    @TableField("jiaoYuLiLun")
    @ExcelField(value = "教育理论")
    private Double jiaoYuLiLun;
    /**
     *艺术概论
     */
    @TableField("yiShuGaiLun")
    @ExcelField(value = "艺术概论")
    private Double yiShuGaiLun;

    /**
     *术科
     */
    @TableField("shuKe")
    @ExcelField(value = "术科")
    private Double shuKe;


    /**
     *语文
     */
    @TableField("yuWen")
    @ExcelField(value = "语文")
    private Double yuWen;
    /**
     *英语(高起专)
     */
    @TableField("yingYu1")
    @ExcelField(value = "英语(高起专)")
    private Double yingYu1;
    /**
     *数学(理)
     */
    @TableField("shuXueLi")
    @ExcelField(value = "数学(理)")
    private Double shuXueLi;
    /**
     *数学(文)
     */
    @TableField("shuXueWen")
    @ExcelField(value = "数学(文)")
    private Double shuXueWen;

    /**
     *史地综合
     */
    @TableField("shiDiZongHe")
    @ExcelField(value = "史地综合")
    private Double shiDiZongHe;
    /**
     *理化综合
     */
    @TableField("liHuaZongHe")
    @ExcelField(value = "理化综合")
    private Double liHuaZongHe;



}
