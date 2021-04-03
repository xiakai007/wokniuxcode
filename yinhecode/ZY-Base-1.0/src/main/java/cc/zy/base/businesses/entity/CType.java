package cc.zy.base.businesses.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author quxiaolong
 * @date 2021-01-26 11:45:08
 */
@Data
@TableName("t_type")
public class CType {

    /**
     * 视频分类主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    @TableField("PID")
    private Integer pid;

    /**
     * 分类的名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 一级分类的排序字段
     */
    @TableField("SORT1")
    private Integer sort1;

    /**
     *
     */
    @TableField("SORT1")
    private String sort;
    /**
     * 二级分类的排序字段
     */
    @TableField("SORT2")
    private Integer sort2;

    /**
     * 
     */
    @TableField("INFO")
    private String info;

    /**
     * 
     */
    @TableField("IMG_URL")
    private String imgUrl;

    /**
     * 
     */
    @TableField("CREATE_USER_ID")
    private Integer createUserId;

    /**
     * 
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 
     */
    @TableField("UPDATE_USER_ID")
    private Integer updateUserId;

    /**
     * 
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 
     */
    @TableField("STATUS")
    private Integer status;
    /**
     *
     */
    @TableField("NAME")
    private String userName;
    /**
     *
     */
    @TableField("NAME")
    private String updateName;


}
