package com.isoftstone.humanresources.controller;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.service.UserService;
import com.isoftstone.humanresources.util.CommonConstant;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping(value = "/hr_manager/user")
@Api(value = "用户管理API")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 分页查询用户列表
     *
     * @param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_user", method = RequestMethod.POST)
    public ResponseEntity<PageInfo<User>> queryUser(@RequestBody QueryUserRequest queryUserRequest) {
        logger.info("- - -查询用户列表的请求参数- - -{}", queryUserRequest);
        PageInfo<User> userPageInfo = null;
        try {
            if (null == queryUserRequest) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户列表
            userPageInfo = userService.queryUser(queryUserRequest);
            if (null == userPageInfo) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
        }
        logger.info("- - -查询用户列表的结果- - -{}", userPageInfo);
        return new ResponseEntity<>(userPageInfo, HttpStatus.OK);
    }

    /**
     * 查询用户
     *
     * @param userID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_user_by_id", method = RequestMethod.GET)
    public ResponseEntity<User> queryUserById(@RequestParam(name = "userID") Integer userID) {
        logger.info("- - -查询用户的请求参数- - -{}", userID);
        User user = null;
        try {
            if (userID == null) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //调用查询用户接口查询用户
            user = userService.queryUserById(userID);
            if (null == user) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            logger.error("查询用户异常", e);
        }
        logger.info("- - -查询用户的结果- - -{}", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 删除及批量用户
     *
     * @param userIDs
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteUsers(@RequestParam(name = "userIDs") String userIDs) {
        Result result = null;
        try {
            if (StringUtils.isEmpty(userIDs)) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logger.info("- - -删除用户的请求参数- - -{}", userIDs);
            //调用删除用户列表删除用户
            result = userService.deleteUser(userIDs);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----删除用户异常-------", e);
        }
        logger.info("- - -删除用户- - -{}", result);
        return new ResponseEntity(result, HttpStatus.OK);

    }

    /**
     * 更改用户
     *
     * @param user
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public ResponseEntity<Result> updateUser(@RequestBody User user) {
        Result result = null;
        try {
            if (null == user) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logger.info("- - -更新用户的请求参数- - -{}", user);
            //调用更新用户列表更新用户
            result = userService.updateUser(user);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----更新用户异常-------", e);
        }
        logger.info("- - -更新用户- - -{}", result);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    /**
     * 修改密码
     *
     * @param updatePasswordRequest
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_password", method = RequestMethod.POST)
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        logger.info("- - -修改密码的请求参数- - -{}", updatePasswordRequest);
        Result result = null;
        try {
            if (null == updatePasswordRequest) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userService.updatePassword(updatePasswordRequest);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----修改密码异常--------", e);
        }
        logger.info("- - -修改密码的结果- - -{}", result);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 修改密码
     *
     * @param updatePasswordRequest
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update_simple_password", method = RequestMethod.POST)
    public ResponseEntity<String> updateSimplePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        logger.info("- - -修改密码的请求参数- - -{}", updatePasswordRequest);
        Result result = null;
        try {
            if (null == updatePasswordRequest) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userService.updateSimplePassword(updatePasswordRequest);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----修改密码异常--------", e);
        }
        logger.info("- - -修改密码的结果- - -{}", result);
        return new ResponseEntity(result, HttpStatus.OK);
    }


    /**
     * 重置密码
     *
     * @param userID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/reset_password", method = RequestMethod.GET)
    public ResponseEntity<Result> resetPassword(@RequestParam(name = "userID") Integer userID) {
        logger.info("- - -重置密码的请求参数- - -{}", userID);
        Result result = null;
        try {
            if (null == userID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userService.updateUserPassword(userID);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----重置密码异常-------", e);
        }
        logger.info("- - -重置密码- - -{}", result);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /* *//**
     * 注册用户
     *
     * @param user
     * @return
     *//*
    @CrossOrigin
    @RequestMapping(value = "/register_user", method = RequestMethod.POST)
    public ResponseEntity<Result> registerUser(@RequestBody User user) {
        logger.info("- - -注册用户的请求参数- - -{}", user);
        Result result = null;
        try {
            if (null == user) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            result = userService.addUser(user);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----注册用户异常--------", e);
        }
        logger.info("- - -注册用户的结果- - -{}", result);
        return new ResponseEntity(result, HttpStatus.OK);
    }*/

    /**
     * 发送邮件获取密码
     * @param username
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/send_message", method = RequestMethod.GET)
    public ResponseEntity<Result> sendMessage(@RequestParam(name = "username")String username){
        logger.info("- - -发送邮件获取密码的请求参数- - -{}", username);
        Result result=null;
        try {
            if (StringUtils.isEmpty(username)) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

           result = userService.sendPassword(username);
            if (null == result) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            logger.error("-----发送密码异常异常--------", e);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 登录用户
     *
     * @param user
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/login_user", method = RequestMethod.POST)
    public ResponseEntity<Result> loginUser(@RequestBody User user, HttpServletRequest request) {
        logger.info("- - -登录用户的请求参数- - -{}", user);
        LoginResult login = null;
        try {
            if (null == user) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            login = userService.login(user);
            User userInfo = login.getUser();
            request.getSession().setAttribute("session_user", userInfo);//登录成功，将用户数据放入到Session
            request.getSession().setMaxInactiveInterval(3600);//设置session存储时间，
            if (null == login) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----登录用户异常--------", e);
        }
        logger.info("- - -登录用户的结果- - -{}", login);
        return new ResponseEntity(login, HttpStatus.OK);
    }

    /**
     * 用户登出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //获取当前session
        if (session != null) {
            User user = (User) session.getAttribute("session_user");
            session.removeAttribute("session_user");
            session.invalidate(); //关闭session
        }
        return new Result(true, "退出成功");
    }


    /**
     * 查询用户的菜单列表
     *
     * @param userID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_menu_list_by_userID", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> queryMenuListByUserID(@RequestParam("userID") Integer userID) {
        logger.info("- - -获取菜单列表的请求参数- - -{}", userID);
        List<Menu> menuList = null;
        try {
            if (null == userID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            menuList = userService.queryMenuListByUserID(userID);
            if (CollectionUtils.isEmpty(menuList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            logger.error("-----获取菜单列表异常--------", e);

        }
        logger.info("- - -获取菜单列表的结果- - -{}", menuList);
        return new ResponseEntity(menuList, HttpStatus.OK);
    }

    /**
     * 查询用户的帮助列表
     *
     * @param userID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/query_help_list_by_userID", method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> queryHelpListByUserID(@RequestParam("userID") Integer userID) {
        logger.info("- - -获取菜单列表的请求参数- - -{}", userID);
        List<Menu> menuList = null;
        try {
            if (null == userID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            menuList = userService.queryHelpListByUserID(userID);
            if (CollectionUtils.isEmpty(menuList)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            logger.error("-----获取菜单列表异常--------", e);

        }
        logger.info("- - -获取菜单列表的结果- - -{}", menuList);
        return new ResponseEntity(menuList, HttpStatus.OK);
    }

    /**
     * 查询用户的组织
     *
     * @param userID
     * @param employeeID
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/find_organization_by_id", method = RequestMethod.GET)
    public ResponseEntity<OrganizationResult> findOrganizationById(@RequestParam(name = "userID") Integer userID, @RequestParam(name = "employeeID") Integer employeeID) {
        logger.info("- - -获取组织的请求参数- - -{}，{}", userID, employeeID);
        OrganizationResult organization = null;
        try {
            if (null == userID && null == employeeID) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            organization = userService.findOrganizationById(userID, employeeID);
            if (null == organization) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("-----获取用户组织异常--------", e);
        }
        logger.info("- - -获取用户组织的结果- - -{}", organization);
        return new ResponseEntity(organization, HttpStatus.OK);
    }


    /**
     * 文件上传到本地服务器
     *
     * @param file
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> file_upload(@RequestParam("file") MultipartFile file) {
        logger.info("- - -获取上传文件的请求参数- - -{}", file);
        Map<String, String> map = new HashMap<>();
        try {
            if (null == file) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            map = userService.fileUpload(file, CommonConstant.IMG_USER);

            if (null == map) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("上传文件失败", e);
        }
        return new ResponseEntity(map, HttpStatus.OK);
    }


    /**
     * 上传文件
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    /*@CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> uploadImg1(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        logger.info("- - -获取上传文件的请求参数- - -{}", file);
        Map<String, String> map = new HashMap<>();
        try {
            if (null == file) {
                logger.error("request param is null !");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            map = userService.uploadFile(file);
            if (null == map) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            logger.error("上传文件失败", e);
        }
        return new ResponseEntity(map, HttpStatus.OK);
    }
*/

}
