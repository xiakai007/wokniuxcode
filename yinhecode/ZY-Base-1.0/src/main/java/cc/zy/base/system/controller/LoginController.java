package cc.zy.base.system.controller;

import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.StudentPool;
import cc.zy.base.common.annotation.Limit;
import cc.zy.base.common.authentication.*;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.properties.FebsProperties;
import cc.zy.base.common.service.ValidateCodeService;
import cc.zy.base.common.utils.Md5Util;
import cc.zy.base.monitor.entity.LoginLog;
import cc.zy.base.monitor.service.ILoginLogService;
import cc.zy.base.system.entity.User;
import cc.zy.base.system.service.IUserService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author MrBird
 */
@Validated
@RestController
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final IUserService userService;
    private final ValidateCodeService validateCodeService;
    private final ILoginLogService loginLogService;
    private final FebsProperties properties;
    private static final String ADMIN_LOGIN_TYPE = LoginType.SHIRO.toString();
    private static final String WX_LOGIN_TYPE = LoginType.OPENID.toString();
    //    public static final String WX_SESSION_KEY = LoginController.class.getName() + ".wx_session_key";
    public static final String WX_SESSION_KEY = "JSESSIONID";

    @PostMapping("login")
    @Limit(key = "login", period = 60, count = 10, name = "登录接口", prefix = "limit")
    public FebsResponse login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            @NotBlank(message = "{required}") String verifyCode,
            boolean rememberMe, HttpServletRequest request) throws FebsException {
        HttpSession session = request.getSession();
        validateCodeService.check(session.getId(), verifyCode);
        password = Md5Util.encrypt(username.toLowerCase(), password);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        UserToken token = new UserToken(username, password, rememberMe, ADMIN_LOGIN_TYPE);
        super.login(token);
        // 保存登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setSystemBrowserInfo();
        this.loginLogService.saveLoginLog(loginLog);
        return new FebsResponse().success().data(properties.getShiro().getSuccessUrl());
    }

    @PostMapping("weChatLogin")
    @Limit(key = "weChatLogin", period = 60, count = 10, name = "微信登录接口", prefix = "limit")
    public FebsResponse weChatLogin(@RequestBody WxLoginVo loginVo, HttpServletRequest request) {
        Student stu = new Student();
        Objects.requireNonNull(loginVo, "code Cannot be null");
        //Subject subject = SecurityUtils.getSubject();
        //  获取微信用户相关信息
        WxMaUserService userService
                = WxMaConfiguration.getMaService(loginVo.getAppid()).getUserService();
        WxMaJscode2SessionResult sessionInfo = null;
        try {
            sessionInfo = userService.getSessionInfo(loginVo.getCode());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        if (!userService.checkUserInfo(sessionInfo.getSessionKey(), loginVo.getRawData(), loginVo.getSignature())) {
            return new FebsResponse().fail();
        }
        WxMaUserInfo userInfo = userService.getUserInfo(sessionInfo.getSessionKey(), loginVo.getEncryptedData(), loginVo.getIv());

        UserToken token = new UserToken(userInfo, loginVo.getBatchName(), loginVo.getIdentity(), loginVo.getTel(), loginVo.getStudyTypeName(), WX_LOGIN_TYPE);
        super.login(token);
        super.getSession().setAttribute(LoginController.WX_SESSION_KEY, sessionInfo.getSessionKey());
        Student student;
        StudentPool studentPool;
        if (SecurityUtils.getSubject().getPrincipal().getClass() == stu.getClass()) {
            student = (Student) SecurityUtils.getSubject().getPrincipal();
            return new FebsResponse().success().data(student);
        } else {
            studentPool = (StudentPool) SecurityUtils.getSubject().getPrincipal();
            return new FebsResponse().success().data(studentPool);
        }
    }

    @PostMapping("register")
    public FebsResponse register(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password) throws FebsException {
        User user = userService.findByName(username);
        if (user != null) {
            throw new FebsException("该用户名已存在");
        }
        this.userService.register(username, password);
        return new FebsResponse().success();
    }

    @GetMapping("index/{username}")
    public FebsResponse index(@NotBlank(message = "{required}") @PathVariable String username) {
        // 更新登录时间
        this.userService.updateLoginTime(username);
        Map<String, Object> data = new HashMap<>(5);
        // 获取系统访问记录
        Long totalVisitCount = this.loginLogService.findTotalVisitCount();
        data.put("totalVisitCount", totalVisitCount);
        Long todayVisitCount = this.loginLogService.findTodayVisitCount();
        data.put("todayVisitCount", todayVisitCount);
        Long todayIp = this.loginLogService.findTodayIp();
        data.put("todayIp", todayIp);
        // 获取近期系统访问记录
        List<Map<String, Object>> lastSevenVisitCount = this.loginLogService.findLastSevenDaysVisitCount(null);
        data.put("lastSevenVisitCount", lastSevenVisitCount);
        User param = new User();
        param.setUsername(username);
        List<Map<String, Object>> lastSevenUserVisitCount = this.loginLogService.findLastSevenDaysVisitCount(param);
        data.put("lastSevenUserVisitCount", lastSevenUserVisitCount);
        return new FebsResponse().success().data(data);
    }

    @GetMapping("images/captcha")
    @Limit(key = "get_captcha", period = 60, count = 10, name = "获取验证码", prefix = "limit")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, FebsException {
        validateCodeService.create(request, response);
    }
}
