package com.isoftstone.humanresources.service;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserGroupService {

    /**
     * 分页查询用户组列表
     * @param queryUserGroupRequest
     * @return
     * @throws Exception
     */
    PageInfo<UserGroup> queryUserGroup(QueryUserGroupRequest queryUserGroupRequest) throws Exception;


    /**
     * 删除用户组
     * @param groupIDs
     */
    Result deleteUserGroup(String groupIDs)  throws Exception;



    /**
     * 新增用户组
     * @param userGroup
     * @throws Exception
     */
    Result addUserGroup(UserGroup userGroup) throws Exception;




    /**
     * 更新用户组
     */
    Result updateUserGroup(UserGroup userGroup)throws Exception;


    /**
     * 分页查询用户组下用户列表
     * @param queryUserParam
     * @return
     */
    PageInfo<User> queryUser(QueryUserParam queryUserParam) throws  Exception;


    /**
     * 查询用户组下可选用户列表
     * @param
     * @return
     * @throws Exception
     */
    List<User> queryOptionUser(QueryUserParam queryUserParam) throws Exception;


    /**
     * 用户组添加用户
     * @param insertUserToGroupParam
     */
    Result addUserToGroup( InsertUserToGroupParam insertUserToGroupParam)throws Exception;


    /**
     * 查询用户组所属的权限
     * @param groupID
     * @return
     * @throws Exception
     */
    List<Menu> queryMenu(Integer groupID) throws Exception;


    /**
     * 查询用户组下的可选权限
     * @param groupID
     * @return
     * @throws Exception
     */
    List<Menu> queryOptionMenu(Integer groupID) throws Exception;


    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    List<Menu> findMenuList() throws Exception;


    /**
     * 删除用户组下的用户
     * @param groupID
     * @param userID
     * @return
     * @throws Exception
     */
    Result deleteUser(Integer groupID,Integer userID)throws Exception;

    /**
     * 用户组添加权限
     * @param insertMenuToGroupParam
     * @throws Exception
     */
    Result addMenuToGroup(InsertMenuToGroupParam insertMenuToGroupParam)throws Exception;

}
