package com.woniu.springboot.admin.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Permission {
    private Integer id;
    private Integer pid;
    private String TYPE;
    private String percode;
    private String name;
    private String icon;
    private String href;
    private Integer OPEN;
    /**
     * 一个权限被哪些角色拥有：一对多
     */
    private List<Role> roleList;
}
