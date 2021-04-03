package com.woniu.springboot.mp.vo;

import com.woniu.springboot.mp.pojo.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="用户搜索")
public class UserVo extends SysUser {
    /**
     * 当前页
     */
    @ApiModelProperty(value="[必须为page]layui当前页")
    private Integer page=1;
    /**
     * 每页记录数
     */
    @ApiModelProperty(value="[必须为limit]layui每页记录数")
    private Integer limit=4;
}
