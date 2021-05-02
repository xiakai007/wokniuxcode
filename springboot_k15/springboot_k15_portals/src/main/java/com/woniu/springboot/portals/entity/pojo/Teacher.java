package com.woniu.springboot.portals.entity.pojo;

import lombok.Data;

@Data
public class Teacher {
    private Integer id;
    private String name;
    private String education;
    private String career;
    private String isfamous;
    private String avatar;
    private Integer subjectid;
    private String status;
    private String headimg;
    private Subject subject;
}
