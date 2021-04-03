package com.isoftstone.humanresources.controller;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.service.UserGroupService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hr_manager/userGroup")
@Api(value = "用户组管理API")
public class UserGroupController {
    private final static Logger logger = LoggerFactory.getLogger(UserGroupController.class);
    @Autowired
    private UserGroupService userGroupService;

    /**
     * 分页查询用户组列表
     *
     * @param queryUserGroupRequest
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_userGroup", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<UserGroup>> queryUserGroup(@RequestBody QueryUserGroupRequest queryUserGroupRequest) {
        logger.info("- - -查询用户组列表的请求参数- - -{}", queryUserGroupRequest);
        PageInfo<UserGroup> userGroupPageInfo = null;
        try {
            if (null == queryUserGroupRequest) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户列表
            userGroupPageInfo = userGroupService.queryUserGroup(queryUserGroupRequest);
            if (null == userGroupPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户组列表异常", e);
        }
        logger.info("- - -查询用户组列表的结果- - -{}", userGroupPageInfo);
        return new ResponseEntity<>(userGroupPageInfo, HttpStatus.OK);
    }

    /**
     * 删除及批量删除用户组
     *
     * @param groupIDs
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_userGroup", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteUserGroup(@RequestParam(name="groupIDs") String groupIDs) {
        logger.info("- - -删除用户组请求参数- - -{}", groupIDs);
        Result result = null;
        try {
            if (StringUtils.isEmpty(groupIDs)) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userGroupService.deleteUserGroup(groupIDs);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除用户组列表异常", e);
        }
        logger.info("- - -删除用户组结束- - -{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 新增用户组
     *
     * @param userGroup
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_userGroup", method = RequestMethod.POST)
    public ResponseEntity<Result> addUserGroup(@RequestBody UserGroup userGroup) {
        logger.info("- - -新增用户组请求参数- - -{}", userGroup);
        Result result = null;
        try {
            if (null == userGroup) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userGroupService.addUserGroup(userGroup);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("新增用户组异常", e);
        }
        logger.info("- - -新增用户组结束- - -{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 更新用户组（状态）
     *
     * @param userGroup
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_userGroup", method = RequestMethod.POST)
    public ResponseEntity<Result> updateUserGroup(@RequestBody UserGroup userGroup) {
        logger.info("- - -更新用户组请求参数- - -{}", userGroup);
        Result result = null;
        try {
            if (null == userGroup) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userGroupService.updateUserGroup(userGroup);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("更新用户组异常", e);
        }
        logger.info("- - -更新用户组结束- - -{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    /**
     * 分页查询用户组下的用户列表
     *
     * @param QueryUserParam
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_user", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<User>> queryUser(@RequestBody QueryUserParam QueryUserParam) {
        logger.info("- - -查询用户组下用户列表的请求参数- - -{}", QueryUserParam);
        PageInfo<User> userPageInfo = null;
        try {
            if (null == QueryUserParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户列表
            userPageInfo = userGroupService.queryUser(QueryUserParam);
            if (null == userPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户组下用户列表异常", e);
        }
        logger.info("- - -查询用户列表的结果- - -{}", userPageInfo);
        return new ResponseEntity<>(userPageInfo, HttpStatus.OK);
    }

    /**
     * 查询用户组下可选的用户列表
     *
     * @param queryUserParam
     * @return
     */
    @RequestMapping(value = "/query_option_user", method = RequestMethod.POST)
    public ResponseEntity<List<User>> queryOptionUser(@RequestBody QueryUserParam queryUserParam) {
        logger.info("- - -查询用户组下可选用户列表的请求参数- - -{}", queryUserParam);
        List<User> userList = null;
        try {
            if (null == queryUserParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户列表
            userList = userGroupService.queryOptionUser(queryUserParam);
            if (CollectionUtils.isEmpty(userList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户组下用户列表异常", e);
        }
        logger.info("- - -查询用户列表的结果- - -{}", userList);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * 删除用户组下的用户
     * @param groupID
     * @param userID
     * @return
     */
    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteUser(@RequestParam(name = "groupID") Integer groupID,@RequestParam(name = "userID") Integer userID){
        Result result=null;
        logger.info("- - -删除用户组下的用户请求参数- - -{}.{}",groupID,userID);
        try {
            if (null == groupID || null==userID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userGroupService.deleteUser(groupID, userID);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("删除用户组下的用户异常",e);
        }
        logger.info("- - -删除用户组下的用户结束- - -{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 用户组新增用户
     *
     * @param insertUserToGroupParam
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_user_to_group", method = RequestMethod.POST)
    public ResponseEntity<Result> addUserToGroup(@RequestBody InsertUserToGroupParam insertUserToGroupParam) {
        logger.info("- - -用户组新增用户的请求参数- - -{}", insertUserToGroupParam);
        Result result = null;
        try {
            if (null == insertUserToGroupParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            result = userGroupService.addUserToGroup(insertUserToGroupParam);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("用户组新增用户异常", e);
        }
        logger.info("- - -用户组新增用户结束- - -{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 查询用户组下已选权限列表
     *
     * @param groupID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_menu", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> queryMenu(@RequestParam(name = "groupID") Integer groupID) {
        logger.info("- - -查询用户组下已选权限列表的请求参数- - -{}", groupID);
        List<Menu> menuList = null;
        try {
            if (null == groupID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询权限接口查询权限（菜单)列表
            menuList = userGroupService.queryMenu(groupID);
            if (CollectionUtils.isEmpty(menuList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户组下已选权限列表异常", e);
        }
        logger.info("- - -查询用户组下已选权限列表的结果- - -{}", menuList);
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }

    /**
     * 查询用户组下可选权限列表
     *
     * @param groupID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_option_menu", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> queryOptionMenu(@RequestParam(name="groupID") Integer groupID) {
        logger.info("- - -查询用户组下可选权限列表的请求参数- - -{}", groupID);
        List<Menu> menuList = null;
        try {
            if (null == groupID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询权限接口查询权限列表
            menuList = userGroupService.queryOptionMenu(groupID);
            if (CollectionUtils.isEmpty(menuList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户组下可选权限列表异常", e);
        }
        logger.info("- - -查询用户组下可选权限列表的结果- - -{}", menuList);
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }


    /**
     * 查询所有权限列表
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/find_menu_list", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> findMenuList(){
        List<Menu> menuList=null;
        try {
           menuList = userGroupService.findMenuList();
            if (CollectionUtils.isEmpty(menuList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询权限列表异常", e);
        }
        logger.info("- - -查询权限列表的结果- - -{}", menuList);
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }


    /**
     * 用户组新增权限
     *
     * @param insertMenuToGroupParam
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add_menu_to_group", method = RequestMethod.POST)
    public ResponseEntity<Result> addMenuToGroup(@RequestBody InsertMenuToGroupParam insertMenuToGroupParam) {
        logger.info("- - -用户组新权限的请求参数- - -{}", insertMenuToGroupParam);
        Result result = null;
        try {
            if (null == insertMenuToGroupParam) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userGroupService.addMenuToGroup(insertMenuToGroupParam);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("用户组新增权限异常", e);
        }
        logger.info("- - -用户组新增权限结果- - -{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
