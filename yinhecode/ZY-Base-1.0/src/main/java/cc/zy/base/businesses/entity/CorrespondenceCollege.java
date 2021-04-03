package cc.zy.base.businesses.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 函授站表
 * @author 赵佳伟
 * @date 2021-01-25
 */
@Data
@TableName("t_correspondence_college")
public class CorrespondenceCollege {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 全称
     */
    @TableField("FULL_NAME")
    private String fullName;

    /**
     * 简称
     */
    @TableField("SIMPLE_NAME")
    private String simpleName;

    /**
     * 创建人id
     */
    @TableField("CREATE_USER_ID")
    private Integer createUserId;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 固定电话
     */
    @TableField("FIXED_LINE")
    private String fixedLine;

    /**
     * 地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 创建人姓名
     */

    private String userName;

    /**
     * 省份id
     */

    @TableField("PROVINCE_ID")
    private Integer provinceId;

    /**
     * 市id
     */
    @TableField("CITY_ID")
    private Integer cityId;

    /**
     * 地区id
     */
    @TableField("AREA_ID")
    private Integer areaId;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 地区名称
     */
    private String areaName;





}
