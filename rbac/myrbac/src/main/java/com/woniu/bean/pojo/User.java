package com.woniu.bean.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String telephone;
    private String PASSWORD;
    private String realname;
    private Date birthday;
    private String headimg;
    private Integer available;
    private Integer did;
    private Dept dept;
    private List<Role> roleList;
}
