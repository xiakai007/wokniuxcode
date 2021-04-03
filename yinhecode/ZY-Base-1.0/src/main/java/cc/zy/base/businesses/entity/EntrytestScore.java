package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author wangpin
 * @date 2021/02/01
 */
@Data
@TableName("t_entrytest_score")
public class EntrytestScore {

    /**
     * 自增id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 身份证号外键
     */
    @TableId(value = "IDENTITY", type = IdType.AUTO)
    private String identity;

    /**
     * 学习形式外键
     */
    @TableId(value = "STUDY_TYPE_ID", type = IdType.AUTO)
    private Integer studyTypeId;

    /**
     * 批次外键
     */
    @TableId(value = "BATCH_ID", type = IdType.AUTO)
    private Integer batchId;

    /**
     * 添加成绩加分项
     */
    @TableField("ADDSCOREITEM")
    private String addscoreitem;

    /**
     * 总成绩
     */
    @TableField("TOTALSCORE")
    private Double totalscore;

    /**
     * 最终成绩
     */
    @TableField("FINALSCORE")
    private Double finalscore;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

}
