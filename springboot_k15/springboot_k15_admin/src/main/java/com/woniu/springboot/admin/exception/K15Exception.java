package com.woniu.springboot.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class K15Exception extends RuntimeException {
    private Integer code;
    private String msg;
}
