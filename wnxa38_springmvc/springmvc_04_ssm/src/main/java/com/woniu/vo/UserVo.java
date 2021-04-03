package com.woniu.vo;

import com.woniu.pojo.User;
import lombok.Data;

@Data
public class UserVo extends User {
    /**
     * 当前页
     */
    private Integer currentPage=1;
    /**
     * 每页记录数
     */
    private Integer pageSize=2;
}
