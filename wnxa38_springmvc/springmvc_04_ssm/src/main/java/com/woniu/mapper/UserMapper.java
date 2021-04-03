package com.woniu.mapper;

import com.woniu.pojo.User;
import com.woniu.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> selectUserAll();
    public List<User> selectUserByDid(@Param("did") Integer did);
    public List<User> selectUserByRid(@Param("rid") Integer rid);
    public User selectUserByRealname(@Param("realname") String realname);
    public User selectUserByTelAndPwd(@Param("telephone")String telephone,@Param("password")String password);
    public int insertUser(User user);
    public int insertUserAndRole(@Param("uid")Integer uid,@Param("rid")Integer rid);
    public List<User> selectUserByProperty(User user);
    public int deleteUserById(@Param("id")Integer id);
    public User selectUserById(@Param("id")Integer id);
    public int updateUser(User user);
}
