package com.woniu.mybatiscache.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
    private String phone;

}
