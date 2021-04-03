package cc.zy.base.businesses.entity;


import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 广告轮播表 Entity
 *
 * @author lijian
 * @date 2021/01/26
 */
@Data
@TableName("t_advert_loop")
public class AdvertLoop {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告序号，对应轮播图的顺序
     */
    @TableField("ADVERT_ORDER")
    private Integer advertOrder;

    /**
     * 广告id，对应广告表id
     */
    @TableField("ADVERT_ID")
    private Integer advertId;
    /**
     * 创建人名称
     */
    @ExcelField(value = "创建人")
    @TableField(exist = false)
    private String userName;
    /**
     * 创建时间
     */
    @ExcelField(value = "创建时间")
    @TableField(exist = false)
    private Date createTime;
    /**
     * 广告标题
     */
    @ExcelField(value = "广告标题")
    @TableField(exist = false)
    private String title;
    /**
     * 广告图片
     */
    @ExcelField(value = "广告图片")
    @TableField(exist = false)
    private String imgUrl;
}
