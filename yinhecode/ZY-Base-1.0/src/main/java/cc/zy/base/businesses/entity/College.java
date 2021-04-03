package cc.zy.base.businesses.entity;

import java.util.Date;

import cc.zy.base.common.converter.TimeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author linan
 * @date 2021-01-18 10:51:13
 */
@Data
@TableName("t_college")
@Excel("院校信息表")
public class College {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("name")
    @ExcelField(value = "院校名称")
    private String name;

    /**
     * 
     */
    @TableField("simpleName")
    @ExcelField(value = "院校简称")
    private String simplename;

    /**
     * 
     */
    @TableField("address")
    @ExcelField(value = "院校地址")
    private String address;

    /**
     * 
     */
    @TableField("tel")
    @ExcelField(value = "院校电话")
    private String tel;

    /**
     * 
     */
    @TableField("createUserId")
    private Long createuserid;

    /**
     * 
     */
    @TableField("createDate")
    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "GMT+8")
    private Date createdate;

    /**
     * 
     */
    @TableField("updateUserId")
    private Long updateuserid;

    /**
     * 
     */
    @TableField("updateDate")
    private Date updatedate;

    /**
     * 
     */
    @TableField("imgUrl")
    private String imgurl;

    /**
     * 
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建人名称
     */
    @ExcelField(value = "创建人")
    @TableField(exist = false)
    private String userName;

    /**
     * 更新人名称
     */
    @ExcelField(value = "更新人")
    @TableField(exist = false)
    private String updateUsername;



	/**
     * 图片地址
     */
    @ExcelField(value = "图片地址")
    @TableField(exist = false)
    private String img;
}
