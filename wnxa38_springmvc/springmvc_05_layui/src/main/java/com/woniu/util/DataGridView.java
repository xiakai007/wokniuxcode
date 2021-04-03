package com.woniu.util;

import lombok.Data;

/**
 * 必须符合layui数据接口的规范！！！
 */
@Data
public class DataGridView {
    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data;

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }
}
