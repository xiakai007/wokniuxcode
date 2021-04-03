package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  市表实体类
 *
 * @author zhaojw
 * @date 2021-01-26
 */
@Data
@TableName("t_city")
public class City {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("CITY_NAME")
    private String cityName;

    /**
     * 
     */
    @TableField("PID")
    private String pid;

    @TableField("CID")
    private String cid;

}
