package cc.zy.base.businesses.entity;


import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 印章信息表
 * @author guozhaodi
 * @date 2021-01-27 09:56:39
 */
@Data
@TableName("t_seal")
@Excel("印章信息表")
public class Seal {

    /**
     *
     */
    @TableId(value = "ID", type = IdType.AUTO)
    @ExcelField(value = "主键id")
    private Integer id;

    /**
     *
     */
    @TableField("COLLEGE_ID")
    @ExcelField(value = "关联学校id")
    private Integer collegeid;

    /**
     * 印章存储地址（阿里云存储地址）
     */
    @TableField("IMG_URL")
    @ExcelField(value = "印章存储地址")
    private String imgurl;
}
