package com.isoftstone.humanresources.service;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


public interface UserService {

    /**
     * 分页查询用户列表
     * @param queryUserRequest
     * @return
     */
    PageInfo<User> queryUser(QueryUserRequest queryUserRequest) throws  Exception;

    /**
     * 查询用户
     */

    User queryUserById(Integer userID) throws Exception;

    /**
     * 删除用户组
     * @param userIDs
     */
    Result deleteUser(String userIDs)  throws Exception;

    /**
     * 更改用户状态
     * @param user
     * @throws Exception
     */
    Result updateUser(User user) throws Exception;


    /**
     * 修改密码
     * @param updatePasswordRequest
     * @throws Exception
     */
    Result updatePassword(UpdatePasswordRequest updatePasswordRequest) throws Exception;

    /**
     * 重置用户密码
     * @param userID
     * @return
     * @throws Exception
     */
    Result updateUserPassword(Integer userID) throws Exception;

    /* *//**
     * 注册用户
     * @param user
     * @throws Exception
     *//*
    Result addUser(User user) throws Exception;
*/

    /**
     * 发送密码
     * @param username
     * @return
     * @throws Exception
     */
    Result sendPassword(String username) throws Exception;

    Result updateSimplePassword(UpdatePasswordRequest updatePasswordRequest)  throws Exception;

    /**
     * 登录用户
     * @param user
     * @return
     * @throws Exception
     */
    LoginResult login(User user) throws Exception;

    /**
     * 根据用户查询菜单列表
     * @param userID
     * @return
     */
    List<Menu> queryMenuListByUserID(Integer userID) throws Exception;

    /**
     * 根据用户查询帮助列表
     * @param userID
     * @return
     */
    List<Menu> queryHelpListByUserID(Integer userID) throws Exception;
    /**
     * 用户查询组织
     * @param userID
     * @param employeeID
     * @return
     * @throws Exception
     */
    OrganizationResult findOrganizationById(Integer userID,Integer employeeID) throws  Exception;


    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */
    Map<String, String> uploadFile(MultipartFile file) throws Exception;

    /**
     * 上传文件到本地
     * @param file
     * @return
     * @throws Exception
     */
    Map<String, String> fileUpload(MultipartFile file,String filePath) throws Exception;





}
