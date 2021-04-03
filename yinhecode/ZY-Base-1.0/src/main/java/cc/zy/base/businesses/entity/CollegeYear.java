package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 学年表 Entity
 *
 * @author LiPeng
 * @date 2021-01-27 10:12:16
 */
@Data
@TableName("t_college_year")
public class CollegeYear {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 学年（第1到第5学年）
     */
    @TableField("YEAR_NAME")
    private String yearName;

}
