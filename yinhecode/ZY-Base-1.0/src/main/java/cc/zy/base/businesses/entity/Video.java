package cc.zy.base.businesses.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author 夏凯
 * @date 2021-01-23 16:12:40
 */
@Data
@TableName("t_video")
public class Video {

    /**
     *视频主键id
     */
    @ApiModelProperty("视频主键id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     *排序字段
     */
    @ApiModelProperty("排序字段")
    @TableField("SORT")
    private Integer sort;

    /**
     *视频名称
     */
    @ApiModelProperty("视频名称")
    @TableField("NAME")
    private String name;

    /**
     *视频存储路径
     */
    @ApiModelProperty("视频存储路径")
    @TableField("VIDEO_URL")
    private String videoUrl;

    /**
     *视频封面的存储路径
     */
    @ApiModelProperty("视频封面的存储路径")
    @TableField("IMG_URL")
    private String imgUrl;

    /**
     *视频简介
     */
    @ApiModelProperty("视频简介")
    @TableField("INFO")
    private String info;

    /**
     *创建人id
     */
    @ApiModelProperty("创建人id")
    @TableField("CREATE_USER_ID")
    private Integer createUserId;

    /**
     *创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     *编辑人id
     */
    @ApiModelProperty("编辑人id")
    @TableField("UPDATE_USER_ID")
    private Integer updateUserId;

    /**
     *编辑人时间
     */
    @ApiModelProperty("编辑人时间")
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     *状态：1为上架，0为下架
     */
    @ApiModelProperty("视频主键id")
    @TableField("STATUS")
    private Integer status;
    /**
     * 视频分类名称
     */
    @ApiModelProperty("视频分类名称")
    private String typeName;
    /**
     * 编辑人名称
     */
    @ApiModelProperty("编辑人名称")
    private String updateName;
    /**
     * 视频分类id
     */
    @ApiModelProperty("视频分类id")
    private Integer typeId;
}
