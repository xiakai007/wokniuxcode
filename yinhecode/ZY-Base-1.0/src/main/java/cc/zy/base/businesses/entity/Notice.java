package cc.zy.base.businesses.entity;

import java.util.Date;
import java.util.List;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;

/**
 * 通知表 Entity
 *
 * @author 杨东豪
 * @date 2021-01-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_notice")
@Excel("通知信息")
public class Notice {

    /**
     * 主键
     */
    @ExcelField(value = "编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @ExcelField(value = "标题")
    @TableField("TITLE")
    private String title;

    /**
     * 通知内容
     */
    @ExcelField(value = "通知内容")
    @TableField("CONTENT")
    private String content;

    /**
     * 班级唯一编码
     */
    @ExcelField(value = "班级名称")
    @TableField(exist = false)
    private String className;

    /**
     * 创建人id
     */
    @TableField("CREATE_USER_ID")
    private Integer createUserId;

    /**
     * 创建时间
     */
    @ExcelField(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;


    /**
     * 创建人
     */
    @ExcelField(value = "创建人")
    @TableField(exist = false)
    private String userName;


    /**
     * 通知封面图片
     */
    @TableField("IMG_URL")
    private String imgUrl;

    /**
     * 视频
     */
    @TableField("VIDEO_URL")
    private String videoUrl;

    /**
     * 文件
     */
    @TableField("FILE")
    private String file;

    /**
     * 状态,参考t_dic,通知状态，草稿，已发布
     */
    @TableField("STATUS")
    private String status;

    /**
     * 课程ID
     */
    @TableField("CLASS_ID")
    private String classId;


    /**
     * 批次
     */

    @TableField(exist = false)
    private String batchId;

    /**
     * 院校名字
     */

    @TableField(exist = false)
    private String collegeName;

    /**
     * 专业名字
     */

    @TableField(exist = false)
    private String majorName;

    /**
     * 层次名字
     */

    @TableField(exist = false)
    private String levelName;

    /**
     * 学生id
     */
    @TableField(exist = false)
    private String userId;

    /**
     * 接收前台传来的id数组
     */
    private List<String> userIds;

    /**
     * 应读人数
     */
    @ExcelField(value = "应读人数")
    private Long countShouldRead;

    /**
     * 已读人数
     */
    @ExcelField(value = "已读人数")
    private Integer countRead;


}
