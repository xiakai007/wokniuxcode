package com.isoftstone.humanresources.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.UserGroupDao;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.service.UserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service(value = "UserGroupService")
public class UserGroupServiceImpl implements UserGroupService {
    private final static Logger logger = LoggerFactory.getLogger(UserGroupService.class);
    @Autowired
    private UserGroupDao userGroupDao;

    @Override
    public PageInfo<UserGroup> queryUserGroup(QueryUserGroupRequest queryUserGroupRequest) {
        logger.info("----------查询用户组列表信息service接入参数------{}", queryUserGroupRequest);
        PageInfo<UserGroup> userGroupsPageInfo = new PageInfo<>();
        try {
            Integer page = queryUserGroupRequest.getPage();                     //当前页
            Integer pageSize = queryUserGroupRequest.getPageSize();          //每页显示的条数
            if (null != page && pageSize != null) {
                PageHelper.startPage(page, pageSize);                       //分页
                //调用dao接口查询用户组分页信息
                List<UserGroup> userGroups = userGroupDao.queryUserGroup(queryUserGroupRequest);
                if (userGroups != null && userGroups.size() > 0) {
                    userGroupsPageInfo = new PageInfo<>(userGroups);
                }
            }
        } catch (Exception e) {
            logger.error("-----查询用户组列表信息异常--------", e);
        }
        logger.info("----------查询用户组信息service返回参数------{}", userGroupsPageInfo);
        return userGroupsPageInfo;
    }

    @Override
    public Result deleteUserGroup(String groupIDs) {
        logger.info("----------删除用户组service接入参数------{}", groupIDs);
        try {
            String[] ids = groupIDs.split(",");
            List<String> groupList = Arrays.asList(ids);
            //调用dao删除用户组
                userGroupDao.deleteUserGroup(groupList);
            return new Result(true,"删除成功");

        } catch (Exception e) {
            logger.error("-----删除用户组异常--------", e);
        }
        return new Result(false,"删除失败");
    }

    @Override
    public Result addUserGroup(UserGroup userGroup) {
        logger.info("----------新增用户组service接入参数------{}", userGroup);
        try {
            String groupName = userGroup.getGroupName();
            if (!StringUtils.isEmpty(groupName)) {

                UserGroup group = userGroupDao.findByName(groupName);
                if (group!=null){
                    return new Result(false,"用户组名已存在");
                }
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(new Date());
            userGroup.setCreatTime(createTime);
            //调用dao新增用户组
            userGroupDao.addUserGroup(userGroup);
            return new Result(true,"新增用户组成功");
        } catch (Exception e) {
            logger.error("-----新增用户组异常--------", e);
        }
        return new Result(false,"新增用户组失败");
    }


    @Override
    public Result updateUserGroup(UserGroup userGroup) {
        logger.info("----------更新用户组service接入参数------{}", userGroup);
        try {
            //调用dao更新用户组
            userGroupDao.updateUserGroup(userGroup);
            return new Result(true,"更新用户组成功");
        } catch (Exception e) {
            logger.error("-----更新用户组异常--------", e);
        }
        return new Result(false,"更新用户组失败");
    }

    @Override
    public PageInfo<User> queryUser(QueryUserParam queryUserParam) {
        logger.info("----------查询用户组下用户列表信息service接入参数------{}", queryUserParam);
        PageInfo<User> userPageInfo = new PageInfo<>();
        try {
            Integer page = queryUserParam.getPage();                     //当前页
            Integer pageSize = queryUserParam.getPageSize();             //每页显示的条数
            if (page != null && pageSize != null) {
                PageHelper.startPage(page, pageSize);
                //调用dao接口查询用户列表
                List<User> userList = userGroupDao.queryUser(queryUserParam);
                if (userList != null && userList.size() > 0) {
                    userPageInfo = new PageInfo<>(userList);
                }
            }
        } catch (Exception e) {
            logger.error("-----查询用户组下用户列表信息异常--------", e);
        }
        logger.info("----------查询用户组下用户信息service返回参数------{}", userPageInfo);
        return userPageInfo;
    }

    @Override
    public List<User> queryOptionUser(QueryUserParam queryUserParam) {
        logger.info("----------查询用户组下可选用户列表信息service接入参数------{}", queryUserParam);
        List<User> userList = null;
        try {
            //调用dao接口查询用户组下可选用户列表
            userList = userGroupDao.queryOptionUser(queryUserParam);
        } catch (Exception e) {
            logger.error("-----查询用户组下可选用户列表信息异常--------", e);
        }
        logger.info("----------查询用户组下可选的用户信息service返回参数------{}", userList);
        return userList;
    }

    @Override
    public Result addUserToGroup(InsertUserToGroupParam insertUserToGroupParam) {
        logger.info("----------用户组新增用户service接入参数------{}", insertUserToGroupParam);
        try {
            Integer groupID = insertUserToGroupParam.getGroupID();
            Integer[] userIDs = insertUserToGroupParam.getUserID();
            if (userIDs.length > 0) {
                for (Integer userID : userIDs) {
                    //调用dao接口用户组新增用户
                    userGroupDao.addUserToGroup(userID, groupID);
                }
            }
            return new Result(true,"新增用户成功");

        } catch (Exception e) {
            logger.error("-----用户组新增用户异常--------", e);
        }
        return new Result(false,"新增用户失败");
    }

    @Override
    public List<Menu> queryMenu(Integer groupID) {
        logger.info("----------查询用户组下已选权限列表service接入参数------{}", groupID);
        List<Menu> menus = null;
        try {
            //调用dao接口查询用户组下已选权限列表
            menus = userGroupDao.queryMenu(groupID);
        } catch (Exception e) {
            logger.info("----------查询用户组下已选权限列表异常}");
        }
        logger.info("----------查询用户组下已选权限列表完成------");
        return menus;
    }

    @Override
    public List<Menu> queryOptionMenu(Integer groupID) {
        logger.info("----------查询用户组下可选权限列表service接入参数------{}", groupID);
        List<Menu> menus = null;
        try {
            //调用dao接口查询用户组下可选权限列表
            menus = userGroupDao.queryOptionMenu(groupID);
        } catch (Exception e) {
            logger.info("----------查询用户组下可选权限列表异常----------");
        }
        logger.info("----------查询用户组下可选权限列表完成------");
        return menus;
    }

    @Override
    public List<Menu> findMenuList() {
        List<Menu> menuList=null;
        try {
            menuList = userGroupDao.findMenuList();
        } catch (Exception e) {
            logger.info("----------查询权限列表异常----------");
        }
        return menuList;
    }

    @Override
    public Result deleteUser(Integer groupID, Integer userID)  {

        try {
            userGroupDao.deleteUser(groupID,userID);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            logger.error("-----删除用户组下用户异常--------", e);
            return new Result(false,"删除失败");
        }

    }

    @Override
    public Result addMenuToGroup(InsertMenuToGroupParam insertMenuToGroupParam) {
        logger.info("----------用户组新增权限接入参数------{}", insertMenuToGroupParam);
        Integer groupID = insertMenuToGroupParam.getGroupID();
        Integer[] menuIDs = insertMenuToGroupParam.getMenuIDs();
        try {
            userGroupDao.deleteMenu(groupID);
            if (menuIDs.length > 0) {
                //先删除用户组下的权限，再新增权限
                for (Integer menuID : menuIDs) {
                    userGroupDao.addMenuToGroup(menuID, groupID);
                }
            }
            return new Result(true,"用户组新增权限成功");
        } catch (Exception e) {
            logger.info("-----------用户组新增权限异常----------------");
        }
        return new Result(false,"用户组新增权限失败");
    }

}
