package cc.zy.base.businesses.entity;


import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 现场确认地点 Entity
 *
 * @author linan
 * @date 2021-02-01
 */
@Data
@Excel("现场确认地点")
@TableName("t_confirm_address")
public class ConfirmAddress {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 省
     */
    @TableField("province")
    private Integer province;

    /**
     * 市
     */
    @TableField("city")
    private Integer city;

    /**
     * 区
     */
    @TableField("area")
    private Integer area;


    @TableField(exist = false)
    @ExcelField(value = "省")
    private String provinceName;


    @TableField(exist = false)
    @ExcelField(value = "市")
    private String cityName;


    @TableField(exist = false)
    @ExcelField("区/县")
    private String areaName;


    /**
     * 详细地点
     */
    @TableField("specific_location")
    @ExcelField("详细地址")
    private String specificLocation;


    /**
     * 状态
     */
    @ExcelField("状态")
    @TableField("status")
    private String status;






}
