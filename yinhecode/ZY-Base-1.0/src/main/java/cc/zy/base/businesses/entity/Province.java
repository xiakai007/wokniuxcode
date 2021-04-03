package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  省表实体类
 *
 * @author zhaojw
 * @date 2021-01-26 11:49:58
 */
@Data
@TableName("t_province")
public class Province {

    /**
     * 
     */
    @TableField("ID")
    private Integer id;

    /**
     * 
     */
    @TableField("PROVINCE_NAME")
    private String provinceName;

    @TableField("PID")
    private String pid;
}
