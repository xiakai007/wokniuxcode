package com.woniu.springboot.admin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="部门信息")
@Data
public class Dept {
    @ApiModelProperty(value="[自动增长]部门id")
    private Integer id;
    @ApiModelProperty(value="部门名称")
    private String dname;
}
