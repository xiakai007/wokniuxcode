package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  区表实体类
 *
 * @author zhaojw
 * @date 2021-01-26
 */
@Data
@TableName("t_area")
public class Area {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("AREA_NAME")
    private String areaName;

    /**
     * 
     */
    @TableField("CID")
    private String cid;

    @TableField("AID")
    private String aid;

}
