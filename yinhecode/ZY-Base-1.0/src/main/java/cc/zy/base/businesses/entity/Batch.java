package cc.zy.base.businesses.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

/**
 *  Entity
 *
 * @author peizijian
 * @date 2021-01-26 12:01:27
 */
@Data
@TableName("t_batch")
@Excel("批次表")
public class Batch {

    /**
     * 批次主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次名称
     */
    @TableField("BATCH_NAME")
    @ExcelField("批次名称")
    private String batchName;

    /**
     * 批次状态
     */
    @TableField("STATUS")
    @ExcelField("状态")
    private String status;

}
