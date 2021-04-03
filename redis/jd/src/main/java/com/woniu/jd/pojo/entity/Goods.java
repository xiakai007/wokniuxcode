package com.woniu.jd.pojo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Goods {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String shop;
    private String img;
    private Timestamp marktime;
    private Integer statuss;

}
