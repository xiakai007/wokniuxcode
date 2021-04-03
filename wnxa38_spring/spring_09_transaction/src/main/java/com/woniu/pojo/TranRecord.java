package com.woniu.pojo;

import lombok.Data;

@Data
public class TranRecord {
    private Integer id;
    private Integer type;
    private Float money;
    private String message;
}
