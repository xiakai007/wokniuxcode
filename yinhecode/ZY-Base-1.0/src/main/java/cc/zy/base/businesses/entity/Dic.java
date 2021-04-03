package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 字典表 Entity
 *
 * @author LiPeng
 * @date 2021-01-27 19:34:24
 */
@Data
@TableName("t_dic")
public class Dic {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("SID")
    private Integer sid;

    /**
     * 
     */
    @TableField("TYPE")
    private String type;

    /**
     * 
     */
    @TableField("NAME")
    private String name;

    /**
     * 
     */
    @TableField("DETAIL")
    private String detail;

}
