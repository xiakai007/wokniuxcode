package cc.zy.base.businesses.entity;

import java.util.Date;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  广告信息表 Entity
 *
 * @author lijian
 * @date 2021/01/25
 */
@Data
@TableName("t_advert")
@Excel("广告信息表")
public class Advert {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("TITLE")
    @ExcelField(value = "广告标题")
    private String title;

    /**
     * 
     */
    @TableField("COMPANY")
    @ExcelField(value = "公司")
    private String company;

    /**
     * 
     */
    @TableField("CREATE_USER_ID")
    private Integer createUserId;

    /**
     * 
     */
    @TableField("IMG_URL")
    private String imgUrl;



    /**
     * 
     */
    @TableField("VIDEO_URL")
    private String videoUrl;

    /**
     * 创建人名称
     */
    @ExcelField(value = "创建人")
    @TableField(exist = false)
    private String userName;
    /**
     *
     */
    @TableField("CREATE_TIME")
    @ExcelField(value = "创建时间")
    private Date createTime;

    /**
     *
     */
    @TableField("STATUS_ID")
    @ExcelField(value = "广告状态", writeConverterExp = "1=上架,2=下架,3=草稿")
    private Integer statusId;

    /**
     *
     */
    @TableField("CONTENT")
//    @ExcelField(value = "广告内容")
    private String content;


}
