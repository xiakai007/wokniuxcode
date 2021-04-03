package com.woniu.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo<E> {
    private Integer status;
    private String message;
    private E e;
    public ResultVo(Integer status,String message){
        this.status=status;
        this.message=message;
    }
}
