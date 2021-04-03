package com.woniu.bean.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String rolename;
    /**
     * 一个角色有哪些权限:一对多
     */
    private List<Permission> permissionList;
    private List<User> userList;
}
