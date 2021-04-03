package com.woniu.springboot.mp.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="layui的表格返回结构")
public class DataGridView {
    @ApiModelProperty(value="状态码")
    private Integer code=0;
    @ApiModelProperty(value="给页面返回的信息")
    private String msg="";
    @ApiModelProperty(value="给页面返回的总记录数")
    private Long count;
    @ApiModelProperty(value="给页面返回的数据")
    private Object data;

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }
}
