package com.woniu.springboot.mp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiakai
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysPermission对象", description="")
public class SysPermission implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    @TableField("TYPE")
    private String type;

    private String percode;

    @TableField("NAME")
    private String name;

    private String icon;

    private String href;

    @TableField("OPEN")
    private Integer open;


}
