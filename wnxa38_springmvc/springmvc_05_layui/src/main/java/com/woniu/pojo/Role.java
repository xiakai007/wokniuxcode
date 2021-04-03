package com.woniu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String rolename;
    private List<User> userList;
}
