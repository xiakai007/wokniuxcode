package com.woniu.springboot.portals.entity.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
public class Course {
    private Integer id;
    private String name;
    private String cover;
    private String description;
    private Integer lessonnum;
    private BigDecimal price;
    private Integer viewnum;
    private Integer buynum;
    private Integer gradeid;
    private Integer subjectid;
    private Integer teacherid;
    private Timestamp pubtime;
    private Integer expiry;
    private String isfine;
    private String isfree;
    private String status;

}
