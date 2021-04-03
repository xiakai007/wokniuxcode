package com.woniu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String telephone;
    private String PASSWORD;
    private String realname;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String headimg;
    private Integer available;
    private Dept dept;
    private List<Role> roleList;
}
