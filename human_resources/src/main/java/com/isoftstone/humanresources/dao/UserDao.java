package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.*;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserDao {

    /**
     * 分页查询用户列表
     * @param queryUserRequest
     * @return
     */
    List<User> queryUser(QueryUserRequest queryUserRequest) throws Exception;


    /**
     * 查询用户
     * @param userID
     * @return
     * @throws Exception
     */

    User queryUserById(@Param("userID") Integer userID) throws Exception;

    /**
     * 删除用户组
     * @param list
     */
    void deleteUser(@Param("list") List<String> list)  throws Exception;

    /**
     * 更新用户
     * @param user
     * @throws Exception
     */
    void updateUser(User user) throws Exception;

    /**
     * 修改密码
     * @param updatePasswordRequest
     * @throws Exception
     */
    void updatePassword(UpdatePasswordRequest updatePasswordRequest) throws Exception;


    /**
     * 重置密码
     * @param user
     * @throws Exception
     */
    void updateUserPassword(User user) throws Exception;

    /**
     *发送邮件修改密码
     * @param user
     * @throws Exception
     */
    void updateUserPasswordByMessage(User user)throws Exception;



    /**
     * 查询用户
     * @param username
     * @return
     */
    User queryUserByName(@Param("username") String username)throws Exception;
    /**
     * 注册用户
     * @param user
     * @throws Exception
     */
    void addUser(User user) throws Exception;

    /**
     * 登录用户
     * @param user
     * @return
     * @throws Exception
     */
    User login(User user) throws Exception;

    void updateUserLoginTime(User user)throws Exception;
    /**
     * 根据用户ID查询员工信息
     * @param userID
     * @return
     */
    EmployeeInformation queryEmployeeInfo(@Param("userID") Integer userID)throws Exception;

    /**
     * 根据用户ID查询权限信息
     * @param userID
     * @return
     */

    List<Menu> queryMenu(@Param("userID") Integer userID)throws Exception;

    /**
     * 获取菜单的下级菜单
     * @param parentID
     * @return
     * @throws Exception
     */
    List<Menu> queryMenuByParentID(@Param("parentID") String parentID) throws Exception;

    /**
     * 获取菜单的下级菜单
     * @param parentID
     * @return
     * @throws Exception
     */
    List<Menu> queryHelpByMenuID(@Param("parentID") String parentID) throws Exception;

    /**
     * 根据用户查询用户组信息
     */

    UserGroup queryGroupByUserId(@Param("userID") Integer userID) throws Exception;


    /**
     * 查询员工信息
     * @param employeeID
     * @return
     */
    EmployeeInformation queryEmployeeById(@Param("employeeID") Integer employeeID);

    /**
     * 新增邮件信息
     * @param messageInfo
     * @throws Exception
     */
    void insertMessage(SendMessageInfo messageInfo) throws Exception;
}
