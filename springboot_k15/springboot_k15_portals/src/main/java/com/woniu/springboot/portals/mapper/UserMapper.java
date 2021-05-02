package com.woniu.springboot.portals.mapper;

import com.woniu.springboot.portals.entity.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User selectUserByAccPwd(@Param("account") String account, @Param("password")String password);
}
