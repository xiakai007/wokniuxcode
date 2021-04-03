package com.woniu.mapper;

import com.woniu.bean.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> selectUserAll();
    public List<User> selectUserByDid(@Param("did") Integer did);
    public List<User> selectUserByRid(@Param("rid") Integer rid);
    public User selectUserByRealname(@Param("realname") String realname);
}
