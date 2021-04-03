package cc.zy.base.businesses.entity;


import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 *  Entity
 *学生入学成绩实体类
 * @author wangpin
 * @date 2021/02/01
 */
@Data
@TableName("t_entrance_score")
@Excel("学生入参成绩表")
public class EntranceScore {

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    @ExcelField(value = "编号")
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
     * 批次id
     */
    @TableId(value = "BATCH_ID", type = IdType.AUTO)
    private String batchId;

    /**
     * 学习形式
     */
    @TableId(value = "STUDY_TYPE_ID", type = IdType.AUTO)
    private String studyTypeId;

    /**
     * 类别id
     */
    @TableField("SUBTYPE_ID")
    private Integer subtypeId;


    /**
     * 科目id
     */
    @TableField("SUBJECT_ID")
    private Integer subjectId;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;


    /**
     *入学成绩
     */

    private List<EntranceScore> scores;
    /**
     *院校
     */
    @TableField("collegeName")
    @ExcelField(value = "院校")
    private String collegeName;
    /**
     *科目别名
     */
    @TableField("ALIAS")
    private String alias;
    /**
     *科目所在模板的列数
     */
    @TableField("NUM")
    private Integer num;
    /**
     * 科目分数
     */
    @TableField("SCORE")
    private Integer score;


    /**
     *院校名称字段
     */
    @TableField("name")
    private String name;

    /**
     *学院ID
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;
    /**
     *层次ID
     */
    @TableField("LEVEL")
    private Integer levelId;
    /**
     *层次名
     */
    @TableField("levelName")
    @ExcelField(value = "层次")
    private String levelName;
    /**
     *电话号
     */
    @TableField("TEL")
    private String tel;

    /**
     *科目类型
     */
    @TableField("FULL_NAME")
    @ExcelField(value = "科目类型")
    private String fullName;
    /**
     *成绩是否合格(1为通过，2为未过,3为缺考，4为其他)
     */
    @TableField("STATUS")
    @ExcelField("考试状态")
    private String status;

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
     *入学考试科目
     */
    @TableField("SUBJECT")
    private String subject;
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
    private String zhengZhi;
    /**
     *大学语文
     */
    @TableField("daXueYuwen")
    @ExcelField(value = "大学语文")
    private String daXueYuwen;
    /**
     *高数一
     */
    @TableField("gaoShu1")
    @ExcelField(value = "高数一")
    private String gaoShu1;
    /**
     *高数二
     */
    @TableField("gaoShu2")
    @ExcelField(value = "高数二")
    private String gaoShu2;
    /**
     *民法
     */
    @TableField("minFa")
    @ExcelField(value = "民法")
    private String minFa;
    /**
     *教育理论
     */
    @TableField("jiaoYuLiLun")
    @ExcelField(value = "教育理论")
    private String jiaoYuLiLun;
    /**
     *生态学基础
     */
    @TableField("shengTaiXue")
    @ExcelField(value = "生态学基础")
    private String shengTaiXue;
    /**
     *英语(高起专)
     */
    @TableField("yingYu1")
    @ExcelField(value = "英语(高起专)")
    private String yingYu1;
    /**
     *艺术概论
     */
    @TableField("yiShuGaiLun")
    @ExcelField(value = "艺术概论")
    private String yiShuGaiLun;
    /**
     *数学(文)
     */
    @TableField("shuXueWen")
    @ExcelField(value = "数学(文)")
    private String shuXueWen;
    /**
     *数学(理)
     */
    @TableField("shuXueLi")
    @ExcelField(value = "数学(理)")
    private String shuXueLi;
    /**
     *史地综合
     */
    @TableField("shiDiZongHe")
    @ExcelField(value = "史地综合")
    private String shiDiZongHe;
    /**
     *理化综合
     */
    @TableField("liHuaZongHe")
    @ExcelField(value = "理化综合")
    private String liHuaZongHe;
    /**
     *术科
     */
    @TableField("shuKe")
    @ExcelField(value = "术科")
    private String shuKe;
    /**
     *英语(专升本)
     */
    @TableField("yingYu2")
    @ExcelField(value = "英语(专升本)")
    private String yingYu2;

    /**
     *医学综合
     */
    @TableField("yingXueZongHe")
    @ExcelField(value = "医学综合")
    private String yingXueZongHe;
    /**
     *语文
     */
    @TableField("yuWen")
    @ExcelField(value = "语文")
    private String yuWen;

}
