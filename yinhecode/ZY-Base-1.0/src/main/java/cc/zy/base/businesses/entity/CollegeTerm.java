package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 学期表 Entity
 *
 * @author LiPeng
 * @date 2021-01-27 10:12:27
 */
@Data
@TableName("t_college_term")
public class CollegeTerm {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 学期名称（第1到第10学期）
     */
    @TableField("SEMESTER_NAME")
    private String semesterName;

}
