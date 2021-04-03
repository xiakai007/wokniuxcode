package cc.zy.base.businesses.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 首页栏位表 Entity
 *
 * @author linan
 * @date 2021-02-01
 */
@Data
@TableName("t_home_page")
public class HomePage {

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型，四种类型（233，学位英语，医学，精品课程）
     */
    @TableField("TYPE")
    private String type;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 详细介绍
     */
    @TableField("INTRO")
    private String intro;

    /**
     * 封面图片的路径
     */
    @TableField("IMG_URL")
    private String imgUrl;

}
