package com.woniu.mymall.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MymallException extends RuntimeException {
    private Integer code;
    private String msg;
}
