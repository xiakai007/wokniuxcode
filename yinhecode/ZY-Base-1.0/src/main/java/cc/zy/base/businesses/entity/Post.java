package cc.zy.base.businesses.entity;


import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author 杨东豪
 * @date 2021-01-22
 */
@Data
@TableName("t_post")
@Excel("岗位信息表")
public class Post {

    /**
     * 岗位id，主键自增
     */
    @TableId(value = "POST_ID", type = IdType.AUTO)
    private Long postId;

    /**
     * 岗位名称
     */
    @TableField("POST_NAME")
    private String postName;

}
