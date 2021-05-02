package com.woniu.springboot.portals.entity.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private Integer id;
    private String account;
    private String password;
    private String email;
    private String telphone;
    private String avatar;
    private Timestamp regtime;
    private String status;

}
