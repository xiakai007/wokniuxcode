package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 层次表 Entity
 *
 * @author LiPeng
 * @date 2021-01-27 18:42:21
 */
@Data
@TableName("t_level")
public class Level {

    /**
     * 主键自增
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 层次
     */
    @TableField("LEVEL_NAME")
    private String levelName;

}
