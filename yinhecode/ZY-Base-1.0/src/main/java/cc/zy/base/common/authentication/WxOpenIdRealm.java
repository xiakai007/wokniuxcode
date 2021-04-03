package cc.zy.base.common.authentication;

import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.StudentPool;
import cc.zy.base.businesses.service.IStudentPoolService;
import cc.zy.base.businesses.service.IStudentService;
import cc.zy.base.monitor.service.ISessionService;
import cc.zy.base.system.entity.User;
import cc.zy.base.system.service.IUserDataPermissionService;
import cc.zy.base.system.service.IUserService;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 自定义实现 ShiroRealm，包含认证和授权两大模块
 *
 * @author MrBird
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WxOpenIdRealm extends AuthorizingRealm {

    private ISessionService sessionService;
    private ShiroLogoutService shiroLogoutService;
    private final IStudentService studentService;
    private final IStudentPoolService studentPoolService;
    private final CacheManager cacheManager;

    @PostConstruct
    private void initConfig() {
        setAuthenticationCachingEnabled(false);
        setAuthorizationCachingEnabled(false);
        setCachingEnabled(false);
        setCacheManager(cacheManager);
    }


    /**
     * 授权模块，获取用户角色和权限
     *
     * @param principal principal
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        try {
            /*Role和Permission逻辑按需添加*/
            SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
            simpleAuthorInfo.addStringPermission("all");
            return simpleAuthorInfo;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * 用户认证
     *
     * @param token AuthenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获得参数
        UserToken userToken = (UserToken) token;
        // 获得微信小程序段传入的参数
        WxMaUserInfo userInfo = userToken.getUserInfo();
        // 获得批次名称
        String batchName = userToken.getBatchName();
        // 获得身份证
        String identity = userToken.getIdentity();
        // 获得手机
        String tel = userToken.getTel();
        // 获得学习形式
        String studyTypeName = userToken.getStudyTypeName();

        StudentPool studentPool = null;
        Student student = null;
        AuthenticationInfo authInfo = null;

        // 根据微信信息和OpenId查询学生信息
        student = studentService.findStudentByWxInfoAndOpenId(batchName, identity, tel, studyTypeName, userInfo.getOpenId());
        if (student == null) {

            // 如果根据微信信息和OpenId查询不到学生就根据学生主要信息进行查询
            student = studentService.findStudentByWxInfo(batchName, identity, tel, studyTypeName);
            if (student == null) {

                // 如果学生里两种查询条件都没有，则根据微信信息和OpenId在学生公海查询学生
                studentPool = studentPoolService.findStudentByWxInfoAndOpenId(batchName, identity, tel, studyTypeName, userInfo.getOpenId());
                if (studentPool == null) {
                    // 如果根据微信信息和Openid查询不到学生就根据学生主要信息在学生公海中进行查询
                    studentPool = studentPoolService.findStudentByWxInfo(batchName, identity, tel, studyTypeName);
                    if (studentPool == null) {
                        throw new IncorrectCredentialsException("没有此用户");
                    } else {
                        // 如果根据微信主要信息查询到学生就同步更新该学生的小程序信息
                        studentPool.setOpenId(userInfo.getOpenId());
                        studentPool.setUnionId(userInfo.getUnionId());
                        studentPool.setNickName(userInfo.getNickName());
                        studentPoolService.updateStudentPool(studentPool);
                        authInfo = new SimpleAuthenticationInfo(studentPool, "ok", getName());
                        return authInfo;
                    }
                } else {
                    authInfo = new SimpleAuthenticationInfo(studentPool, "ok", getName());
                    return authInfo;
                }

            } else {
                // 如果根据微信主要信息查询到学生就同步更新该学生的小程序信息
                student.setOpenId(userInfo.getOpenId());
                student.setUnionId(userInfo.getUnionId());
                student.setNickName(userInfo.getNickName());
                studentService.updateStudent(student);
                authInfo = new SimpleAuthenticationInfo(student, "ok", getName());
                return authInfo;
            }
        } else {
            authInfo = new SimpleAuthenticationInfo(student, "ok", getName());
            return authInfo;
        }
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token != null && token instanceof UserToken;
    }

    /**
     * 认证密码匹配调用方法
     */
    @Override
    protected void assertCredentialsMatch(AuthenticationToken authcToken,
                                          AuthenticationInfo info) throws AuthenticationException {
        return;
    }
}
