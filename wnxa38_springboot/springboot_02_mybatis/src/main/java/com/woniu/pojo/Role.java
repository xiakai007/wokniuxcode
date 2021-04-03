package com.woniu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@ApiModel(value="角色信息")
@Data
public class Role {
    @ApiModelProperty(value="[自动增长]角色id")
    private Integer id;
    @ApiModelProperty(value="角色名称")
    private String rolename;
    private List<User> userList;
}
