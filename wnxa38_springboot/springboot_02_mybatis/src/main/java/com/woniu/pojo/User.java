package com.woniu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@ApiModel(value="用户信息")
public class User {
    @ApiModelProperty(value="[自动增长]用户id")
    private Integer id;
    @ApiModelProperty(value="用户手机号")
    private String telephone;
    @ApiModelProperty(value="用户密码")
    private String PASSWORD;
    @ApiModelProperty(value="用户姓名")
    private String realname;
    @JSONField(format = "yyyy-MM-dd")
    @ApiModelProperty(value="用户生日")
    private Date birthday;
    @ApiModelProperty(value="用户头像地址")
    private String headimg;
    @ApiModelProperty(value="用户状态")
    private Integer available;
    private Dept dept;
    private List<Role> roleList;
}
