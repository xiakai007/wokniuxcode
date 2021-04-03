package cc.zy.base.businesses.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 广告日志
 * @author 赵佳伟
 * @date 2021/01/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Excel("广告日志信息")
public class AdvertLog {

    @TableField("ID")
    @ExcelField(value = "编号")
    private Integer id;

    /**
     * 广告标题
     */
    @ExcelField(value = "广告标题")
    private String title;

    /**
     * 浏览用户
     */
    @ExcelField(value = "浏览用户")
    private String stuName;

    @TableField("ADVERT_ID")
    private Integer adverId;

    @TableField("USER_ID")
    private Integer userId;

    @TableField("ENTER_TIME")
    @ExcelField(value = "进入时间")
    private Timestamp enterTime;

    @TableField("EXIT_TIME")
    @ExcelField(value = "退出时间")
    private Timestamp exitTime;

    /**
     * 做广告的公司
     */
    private String company;

    /**
     * 广告创建时间
     */
    private Timestamp createTime;

    /**
     * 创建广告的用户id
     */
    private Integer createUserId;

    /**
     * 创建广告的人
     */
    private String userName;

    /**
     * 阅读时长
     */
    @ExcelField(value = "浏览时长(秒)")
    private Long time;
}