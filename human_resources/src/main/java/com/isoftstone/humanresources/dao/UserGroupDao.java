package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserGroupDao {
    /**
     * 分页查询用户组列表
     * @param queryUserGroupRequest
     * @return
     * @throws Exception
     */
    List<UserGroup> queryUserGroup(QueryUserGroupRequest queryUserGroupRequest) throws Exception;

    /**
     * 删除用户组
     * @param groupList
     */
    void deleteUserGroup(@Param("groupList") List<String> groupList)throws Exception;

    /**
     * 新增用户组
     * @param userGroup
     * @throws Exception
     */
    void addUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 根据用户组名查询用户组
     * @param groupName
     * @return
     * @throws Exception
     */
    UserGroup findByName(@Param("groupName")String groupName) throws Exception;

    /**
     * 更新用户组
     * @param userGroup
     * @throws Exception
     */
    void updateUserGroup(UserGroup userGroup)throws Exception;


    /**
     * 分页查询用户组下用户列表
     * @param queryUserParam
     * @return
     */
    List<User> queryUser(QueryUserParam queryUserParam) throws Exception;


    /**
     * 查询用户组下可选用户列表
     * @param
     * @return
     * @throws Exception
     */
    List<User> queryOptionUser(QueryUserParam queryUserParam) throws Exception;

    /**
     * 用户组新增用户
     * @param userID
     * @param groupID
     * @throws Exception
     */
    void addUserToGroup(@Param("userID") Integer userID ,@Param("groupID")Integer groupID) throws Exception;


    /**
     * 删除用户组下的用户
     * @param groupID
     * @param userID
     * @throws Exception
     */
    void deleteUser(@Param("groupID")Integer groupID,@Param("userID")Integer userID)throws Exception;


    /**
     * 查询用户组下的所属权限
     * @param groupID
     * @return
     * @throws Exception
     */
    List<Menu> queryMenu(@Param("groupID") Integer groupID) throws Exception;


    /**
     * 查询用户组下的可选权限
     * @param groupID
     * @return
     * @throws Exception
     */
    List<Menu> queryOptionMenu(@Param("groupID") Integer groupID) throws Exception;

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    List<Menu> findMenuList() throws Exception;


    /**
     * 删除用户组下的权限
     * @param groupID
     * @throws Exception
     */
    void deleteMenu(@Param("groupID") Integer groupID) throws Exception;


    /**
     * 用户组新增权限
     * @param menuID
     * @param groupID
     * @throws Exception
     */
    void addMenuToGroup(@Param("menuID") Integer menuID ,@Param("groupID")Integer groupID) throws Exception;

}
