package cc.zy.base.businesses.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Entity
 *
 * @author hu
 * @date 2021-01-26 15:46:52
 */
@Data
@TableName("t_stu_label")
public class StuLabelContent {
    private String mediaLabelName;
    private String batchId;
    private String collegeId;
    private String majorId;
    private String level;
    private String stageId;
    private String stuName;
    private String identity;
    private String tel;
}
