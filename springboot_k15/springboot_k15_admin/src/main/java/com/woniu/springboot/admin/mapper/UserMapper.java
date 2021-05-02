package com.woniu.springboot.admin.mapper;


import com.woniu.springboot.admin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> selectUserAll();
    public List<User> selectUserByDid(@Param("did") Integer did);
    public List<User> selectUserByRid(@Param("rid") Integer rid);
    public User selectUserByRealname(@Param("realname") String realname);
    public User selectUserByTelAndPwd(@Param("telephone") String telephone, @Param("password") String password);
    public int insertUser(User user);
    public List<User> selectUserByProperty(User user);
    public int deleteUserById(@Param("id") Integer id);
    public User selectUserById(@Param("id") Integer id);
    public int updateUser(User user);
    /**
     * 软删除，只改变用户available的值
     * @param id
     * @return
     */
    public int removeUser(@Param("id") Integer id);
    public int deleteUserAndRoleByUid(@Param("uid") Integer uid);
    public int insertUserAndRole(@Param("uid")Integer uid,@Param("rid")Integer rid);
    public User selectUserByTel(@Param("telephone")String telephone);
}
