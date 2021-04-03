package com.isoftstone.humanresources.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.EmployeeDao;
import com.isoftstone.humanresources.dao.OrganizationDao;
import com.isoftstone.humanresources.dao.UserDao;
import com.isoftstone.humanresources.domain.*;
import com.isoftstone.humanresources.service.UserService;
import com.isoftstone.humanresources.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private OrganizationDao organizationDao;


    @Autowired
    private SystemConfig systemConfig;


    @Value("${FTP_ADDRESS}")
    private String address;

    @Value("${FTP_PORT}")
    private String port;

    @Value("${VISIT_PORT}")
    private String visitPort;

    @Value("${FTP_BASEPATH}")
    private String path;

    @Value("${FTP_USERNAME}")
    private String username;

    @Value("${FTP_PASSWORD}")
    private String password;

    @Value("${FILE_PATH}")
    private String userPath;

    @Value("${LUCK_PATH}")
    private String luckPath;

    @Override
    public PageInfo<User> queryUser(QueryUserRequest queryUserRequest) {
        logger.info("----------查询用户列表信息service接入参数------{}", queryUserRequest);
        PageInfo<User> userPageInfo = new PageInfo<>();
        try {
            Integer page = queryUserRequest.getPage();                     //当前页
            Integer pageSize = queryUserRequest.getPageSize();             //每页显示的条数
            if (page != null && pageSize != null) {
                PageHelper.startPage(page, pageSize);                     //分页
                //调用dao接口查询用户列表
                List<User> userList = userDao.queryUser(queryUserRequest);
                if (userList != null && userList.size() > 0) {
                    userPageInfo = new PageInfo<>(userList);
                }
            }

        } catch (Exception e) {
            logger.error("-----查询用户列表信息异常--------", e);
        }
        logger.info("----------查询用户信息service返回参数------{}", userPageInfo);
        return userPageInfo;
    }

    @Override
    public User queryUserById(Integer userID) {
        logger.info("----------查询用户列表信息service接入参数------{}", userID);
        User user = null;
        try {
            //调用dao接口查询用户
            user = userDao.queryUserById(userID);
        } catch (Exception e) {
            logger.error("查询用户信息异常", e);
        }
        logger.info("----------查询用户信息service返回参数------{}", user);
        return user;

    }

    @Override
    public Result deleteUser(String userIDs) {
        logger.info("----------删除用户------{}", userIDs);
        try {
            String[] ids = userIDs.split(",");
            List<String> list = Arrays.asList(ids);
            //调用dao接口批量删除
            userDao.deleteUser(list);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            logger.error("-----------删除用户异常------------", e);
            return new Result(false, "删除失败");
        }
    }

    @Override
    public Result updateUser(User user) {
        logger.info("----------更新用户状态------{}", user);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = format.format(new Date());
        user.setUpdateTime(updateTime);
        try {
            //调用dao接口更新用户状态
            userDao.updateUser(user);
            return new Result(true, "更改成功");
        } catch (Exception e) {
            logger.error("更新用户状态", e);
        }
        return new Result(false, "更改失败");
    }

    @Override
    public Result updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        logger.info("----------修改密码接入参数------{}", updatePasswordRequest);

        Integer userID = updatePasswordRequest.getUserID();                        //用户ID
        String repeatPassword = updatePasswordRequest.getRepeatPassword();         //重复旧密码
        String newPassword = updatePasswordRequest.getNewPassword();               // 输入新密码
        String repeatNewPassword = updatePasswordRequest.getRepeatNewPassword();   //确认新密码
        User user = null;
        try {
            //调用dao接口查询用户
            user = userDao.queryUserById(userID);
            if (null != user) {
                String password = user.getPassword();
                String encryptBasedDes = MD5.getMD5Code(repeatPassword);
                //判断输入的密码是否与数据库密码一致
                if (!encryptBasedDes.equals(password)) {
                    return new Result(false, "原始密码错误");
                } else {
                    //判断两次输入的新密码是否一致
                    if (!newPassword.equals(repeatNewPassword)) {
                        return new Result(false, "确认密码错误");
                    } else {
                        String encryptPassword = MD5.getMD5Code(repeatNewPassword);//对密码加密
                        updatePasswordRequest.setRepeatNewPassword(encryptPassword);
                        //调用方法修改密码
                        resetPassword(updatePasswordRequest);
                        return new Result(true, "修改密码成功");
                    }
                }
            }
        } catch (Exception e) {
            logger.error("-----------修改密码异常--------", e);

        }
        return new Result(false, "修改密码失败");

    }

    @Override
    public Result updateUserPassword(Integer userID) {
        logger.info("----------重置密码接入参数------{}", userID);
        try {
            User user = new User();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = format.format(new Date());
            //重置初始化密码，对密码加密
            String password = "Rt123456";
            String encryptPassword = MD5.getMD5Code(password);
            user.setUserID(userID);
            user.setPassword(encryptPassword);
            user.setUpdateTime(updateTime);
            userDao.updateUserPassword(user);
            return new Result(true, "重置密码成功");
        } catch (Exception e) {

            logger.error("-----------重置密码异常--------", e);
            return new Result(false, "重置密码失败");
        }


    }


    @Override
    public Result sendPassword(String username) {
        logger.info("----------发送邮件获取密码的接入参数------{}", username);
        //判断username是员工ID、手机号，还是邮箱
        if (!StringUtil.isNumber(username)) {
            if (!username.toLowerCase().contains(CommonConstant.EMAIL_SUFFIX)) {
                username = username + CommonConstant.EMAIL_SUFFIX;
            }
        }
        //根据userName去查询此员工的信息
        EmployeeInformation employeeInformation = employeeDao.getEmployeeLikeInfo(username);
        if (null == employeeInformation || StringUtil.isEmpty(employeeInformation.getEmail())) {
            return new Result(false, "输入的信息有误，无法查找到员工信息！");
        }
        String emaill = employeeInformation.getEmail();
        Integer employeeID = employeeInformation.getEmployeeID();
        String password = generateWord();
        String title = "用户密码邮件-来自【MAG华为综合业务事业本部】";
        String content = "您好！您的用户密码是：" + password + " ,请您尽快登录系统修改密码。";
        try {

            String from = systemConfig.getFrom();
            String configPassword = systemConfig.getPassword();
            String smtp = systemConfig.getSmtp();
            String configUsername = systemConfig.getUsername();
            //更改用户密码
            User user = new User();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = format.format(new Date());
            user.setUpdateTime(updateTime);
            user.setPassword(MD5.getMD5Code(password));
            user.setEmployeeID(employeeID);
            userDao.updateUserPasswordByMessage(user);
            //发送邮件
            SendMailUtil.send(smtp, from, emaill, title, content, configUsername, configPassword);

            //邮件表存入数据
            SendMessageInfo messageInfo = new SendMessageInfo();
            messageInfo.setTitle(title);
            messageInfo.setContent(content);
            messageInfo.setDealUser(username);
            messageInfo.setToUser(username);
            messageInfo.setToEmail(emaill);
            messageInfo.setStatus(1);
            messageInfo.setCreateTime(new Date());
            messageInfo.setSendTime(new Date());
            messageInfo.setMessageType(2);
            userDao.insertMessage(messageInfo);
            return new Result(true, "请到" + emaill + "邮箱查询密码进行登录！");


        } catch (Exception e) {
            logger.info("----------发送邮件获取密码异常------", e);
            return new Result(false, "发送密码失败");
        }
    }

    //  生成密码
    private String generateWord() {
        String[] beforeShuffle = new String[]{"2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};
        List<String> list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }
        String sb = stringBuilder.toString();
        String result = sb.substring(3, 9);
        return result;
    }
    @Override
    public Result updateSimplePassword(UpdatePasswordRequest updatePasswordRequest) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = format.format(new Date());
        updatePasswordRequest.setUpdateTime(updateTime);
        updatePasswordRequest.setRepeatNewPassword(MD5.getMD5Code(updatePasswordRequest.getRepeatNewPassword()));
        try {
            //调用dao接口修改密码
            userDao.updatePassword(updatePasswordRequest);
        } catch (Exception e) {
            logger.error("-----------修改密码异常--------", e);
            return new Result(false, "修改密码失败");
        }
        return new Result(true, "修改密码成功");
    }

    //修改密码
    public void resetPassword(UpdatePasswordRequest updatePasswordRequest) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = format.format(new Date());
        updatePasswordRequest.setUpdateTime(updateTime);
        try {
            //调用dao接口修改密码
            userDao.updatePassword(updatePasswordRequest);
        } catch (Exception e) {
            logger.error("-----------修改密码异常--------", e);
        }
    }

    /*@Override
    public Result addUser(User user) {
        logger.info("----------注册用户的接入参数------{}", user);
        try {
            String username = user.getUsername();               //用户名
            String password = user.getPassword();               //密码
            String phone = user.getPhone();                     //手机号码
            //用户名校验
            if (!StringUtils.isEmpty(username)) {
                User userInfo = userDao.queryUserByName(username);
                if (userInfo != null) {
                    return new Result(false, "用户名已存在");
                }
            }
            //手机号校验
            if (!StringUtils.isEmpty(phone)) {
                boolean chinaPhoneLegal = PhoneFormatCheckUtils.isChinaPhoneLegal(phone);
                if (chinaPhoneLegal == false) {
                    return new Result(false, "手机号码有误");
                }
            }
            user.setEmail(username + "@isoftstone.com");
            if (!StringUtils.isEmpty(password)) {
                String encryptPassword = AESUtil.encryptBasedDes(password);
                user.setPassword(encryptPassword);  //设置加密密码
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(new Date());
            user.setUpdateTime(time);           //设备更新时间
            user.setRegisterTime(time);         //设置注册时间
            //调用dao接口新增用户
            userDao.addUser(user);
            return new Result(true, "注册成功");
        } catch (Exception e) {
            logger.error("-----------注册用户异常--------", e);
            return new Result(false, "注册失败");
        }

    }
*/
    @Override
    public LoginResult login(User user) {
        logger.info("----------登录用户的接入参数------{}", user);
        User userInfo = null;
        //对登录密码加密
        user.setPassword(MD5.getMD5Code(user.getPassword()));
        //调用dao接口登录
        String userInputName = user.getUsername();
        try {
            if (!StringUtil.isNumber(userInputName)) {
                if (!userInputName.toLowerCase().contains(CommonConstant.EMAIL_SUFFIX)) {
                    user.setUsername(userInputName + CommonConstant.EMAIL_SUFFIX);
                }
            }
            userInfo = userDao.login(user);

            if (userInfo == null) {
                return new LoginResult(false, "登录名或密码错误", null, null);
            } else {
                // 生成token
                String token = TokenProccessor.makeToken();
                if (!StringUtils.isEmpty(token)) {
                    userInfo.setAccessToken(token);
                }
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String lastLoginTime = format.format(new Date());
                userInfo.setLastLoginTime(lastLoginTime);
                userDao.updateUserLoginTime(userInfo);
                EmployeeInformation employeeInformation = userDao.queryEmployeeInfo(userInfo.getUserID());
                return new LoginResult(true, "登录成功", userInfo, employeeInformation);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-----------注册用户异常--------", e);
            return new LoginResult(false, "登录失败", null, null);
        }

    }


    @Override
    public List<Menu> queryMenuListByUserID(Integer userID) {
        logger.info("----------登录菜单列表的接入参数------{}", userID);
        List<Menu> menuList = null;
        try {
            ArrayList<Menu> menus = new ArrayList<>();
            List<Menu> firstMenuList = null;
            //获取一级菜单
            firstMenuList = userDao.queryMenu(userID);
            if (firstMenuList != null && firstMenuList.size() > 0) {
                menus.addAll(firstMenuList);
                for (Menu firstMenu : firstMenuList) {
                    if (null != firstMenu) {
                        //获取二级菜单
                        List<Menu> secondMenuList = userDao.queryMenuByParentID(firstMenu.getMenuCode() + "");
                        if (secondMenuList != null && secondMenuList.size() > 0) {
                            menus.addAll(secondMenuList);

                        }
                    }
                }
                System.out.println(menus);
                //调用方法，菜单列表转化为树形结构的列表
                menuList = getTreeList(menus);
            }
        } catch (Exception e) {
            logger.error("-----------获取菜单列表异常--------", e);
        }
        logger.info("----------获取菜单列表的结果------{}", menuList);
        return menuList;

    }

    /**
     * 获取帮助列表
     *
     * @param userID
     * @return
     */
    @Override
    public List<Menu> queryHelpListByUserID(Integer userID) {
        ArrayList<Menu> menus = new ArrayList<>();
        try {
            List<Menu> firstMenuList = null;
            //获取一级菜单
            firstMenuList = userDao.queryMenu(userID);

            if (firstMenuList != null && firstMenuList.size() > 0) {
                for (Menu firstMenu : firstMenuList) {
                    if (null != firstMenu) {
                        //获取二级菜单
                        List<Menu> secondMenuList = userDao.queryHelpByMenuID(firstMenu.getMenuCode() + "");
                        if (!CollectionUtils.isEmpty(secondMenuList)) {
                            firstMenu.setChildrens(secondMenuList);
                        }
                        menus.add(firstMenu);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("-----------获取帮助列表异常--------", e);
        }
        return menus;

    }

    //菜单列表封装菜单树
    public List<Menu> getTreeList(List<Menu> entityList) {
        List<Menu> resultList = new ArrayList();
        for (Menu entity : entityList) {

            String parentID = entity.getParentCode();
            if ((parentID == null) || ("-1".equals(parentID))) {
                resultList.add(entity);
            }
        }
        for (Menu entity : resultList) {
            entity.setChildrens(getSubList(entity.getMenuCode(), entityList));
        }
        return resultList;
    }

    private List<Menu> getSubList(Integer id, List<Menu> entityList) {
        List<Menu> childList = new ArrayList();
        for (Menu entity : entityList) {
            String menuID = id + "";
            String parent = entity.getParentCode();
            if (menuID.equals(parent)) {
                childList.add(entity);
            }
        }
        for (Menu entity : childList) {
            entity.setChildrens(getSubList(entity.getMenuCode(), entityList));
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }


    @Override
    public OrganizationResult findOrganizationById(Integer userID, Integer employeeID) {
        OrganizationResult organizationResult = new OrganizationResult();
        //默认设置为个人
        String organizationType = "employeeID";

        String organizationProjectValue = CommonConstant.EMPTY_STRING;
        String organizationValue = CommonConstant.EMPTY_STRING;
        try {
            UserGroup group = userDao.queryGroupByUserId(userID);
            EmployeeInformation employeeInformation = userDao.queryEmployeeById(employeeID);
            if (null != group && null != employeeInformation) {
                //对用户的组织进行判断
                organizationType = group.getOrganization();

                if(!StringUtil.isEmpty(organizationType)) {
                    switch (organizationType) {
                        case CommonConstant.ORGANZATION_TYPE_BD:
                            if (StringUtils.isEmpty(employeeInformation.getBD())) {
                                organizationType = "employeeID";
                                break;
                            }
                            organizationValue = employeeInformation.getBD();

                            break;
                        case CommonConstant.ORGANZATION_TYPE_BU:
                            if (StringUtils.isEmpty(employeeInformation.getBU())) {
                                organizationType = "employeeID";
                                break;
                            }
                            organizationValue = employeeInformation.getBU();
                            break;
                        case CommonConstant.ORGANZATION_TYPE_CU:
                            if (StringUtils.isEmpty(employeeInformation.getCU())) {
                                organizationType = "employeeID";
                                break;
                            }
                            organizationValue = employeeInformation.getCU();

                            break;

                        case CommonConstant.ORGANZATION_TYPE_PO:
                            if (StringUtils.isEmpty(employeeInformation.getPO())) {
                                organizationType = "employeeID";
                                break;
                            }
                            organizationValue = employeeInformation.getPO();
                            break;
                        case CommonConstant.LOWER_ORGANZATION_TYPE_PROJECTTEAM:
                            if (StringUtils.isEmpty(employeeInformation.getProjectTeam())) {
                                organizationType = "employeeID";
                                break;
                            }
                            organizationValue = employeeInformation.getProjectTeam();
                            break;
                        default:
                            break;
                    }
                    //把每个基本的名称获取到传给实体
                    organizationResult.setBD(getOrgNameByID(employeeInformation.getBD()));
                    organizationResult.setBU(getOrgNameByID(employeeInformation.getBU()));
                    organizationResult.setCU(getOrgNameByID(employeeInformation.getCU()));
                    organizationResult.setPO(getOrgNameByID(employeeInformation.getPO()));
                    organizationResult.setProjectTeam(getOrgNameByID(employeeInformation.getProjectTeam()));
                }

            }
        } catch (Exception e) {
            logger.error("-----------获取用户组织异常--------", e);
        }
        organizationResult.setOrgName(organizationType);
        organizationResult.setOrgValue(organizationValue);
        return organizationResult;
    }


    /**
     * 根据组织ID获取组织名称
     *
     * @param organizationID
     * @return
     */
    public String getOrgNameByID(String organizationID) {
        String orgName = null;
        OrganizationInformation organizationInfo = null;
        if (!StringUtil.isEmpty(organizationID)) {
            organizationInfo = organizationDao.queryOrganizationByID(organizationID);
        }
        if (null != organizationInfo) {
            orgName = organizationInfo.getOrganizationName();
        }
        return orgName;

    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> uploadFile(MultipartFile file) throws Exception {
        logger.info("----------上传文件的接入参数------{}", file);
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "上传文件失败");
        String fileName = file.getOriginalFilename();
        //获取文件扩展名
        String sname = fileName.substring(fileName.lastIndexOf("."));
        //对文件重命名
        String name = System.currentTimeMillis() + UUID.randomUUID().toString().replaceAll("-", "") + sname;
        InputStream inputStream = file.getInputStream();
        String filePath = null;
        //调用工具类上传文件
        Boolean flag = FtpUtil.uploadFiles(name, inputStream, address, port, username, MD5.getMD5Code(password), path);
        if (flag == true) {
            //filePath ="http://10.61.180.52:8180/organizationimg/"+name;
            filePath = "http://" + address + ":" + visitPort + path + "/" + name;
            map.put("code", "1");
            map.put("msg", "上传文件成功");
        }
        map.put("path", filePath);
        return map; //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
    }

    @Override
    public Map<String, String> fileUpload(MultipartFile file,String filePath) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "上传文件失败");
        String fileName = file.getOriginalFilename();
        //获取文件扩展名
        String sname = fileName.substring(fileName.lastIndexOf("."));

        //重新生成文件名
        fileName = UUID.randomUUID() + sname;
        String newFileName = UUID.randomUUID() + sname;
        //指定本地文件夹存储图片，也可以传入
        String localfilePath = null;
        if(CommonConstant.IMG_LUCK.equals(filePath)){
            localfilePath = luckPath;
        }else if(CommonConstant.IMG_USER.equals(filePath)){
            localfilePath = userPath;
        }
        try {
            Runtime rt = Runtime.getRuntime(); // 运行时系统获取
            //解决windows下权限问题
            Process proc = rt.exec("Icacls " + localfilePath + fileName + " /grant EveryOne:f");//
            //将图片保存到static文件夹里
            file.transferTo(new File(localfilePath + fileName));
            String refilePath = CommonConstant.EMPTY_STRING;
            if(".jpg".equals(sname)||".png".equals(sname)||".gif".equals(sname)||".bmp".equals(sname)) {
                PicUtils.commpressPicForScale(localfilePath + fileName, localfilePath + newFileName, 1000, 0.8, 750, 1334);
                refilePath = "http://" + address + ":" + visitPort + "/"+ filePath +"/"+ newFileName;
            }else{
                refilePath = "http://" + address + ":" + visitPort + "/"+ filePath +"/"+ fileName;
            }
            map.put("code", "1");
            map.put("msg", "上传文件成功");
            map.put("path", refilePath);
        } catch (Exception e) {
            logger.error("上传文件失败", e);
        }
        return map;
    }


}

