package com.woniu.springboot.admin.realm;

import com.woniu.springboot.admin.pojo.User;
import com.woniu.springboot.admin.service.PermissionService;
import com.woniu.springboot.admin.service.RoleService;
import com.woniu.springboot.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Override
    public String getName(){
        return "UserRealm";
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo授权时调用");
        //获取用户手机号
        String telephone = (String)principalCollection.getPrimaryPrincipal();
        //通过手机号获取用户对象
        User user = userService.selectUserByTel(telephone);
        //通过用户id获取角色名称集合
        Set<String> roleNames = roleService.selectRolenamesByUid(user.getId());
        //通过用户id获取权限percode集合
        Set<String> percodes = permissionService.selectPercodesByUid(user.getId());
        SimpleAuthorizationInfo simpleInfo = new SimpleAuthorizationInfo();
        simpleInfo.addRoles(roleNames);
        simpleInfo.addStringPermissions(percodes);
        return simpleInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthenticationInfo ainfo=null;
        log.debug("用户认证时调用");
        //获取电话号码
        String telephone = (String) authenticationToken.getPrincipal();
        User user = userService.selectUserByTel(telephone);
        if(user!=null){
            ainfo = new SimpleAuthenticationInfo(telephone, user.getPASSWORD(), this.getName());
        }
        return ainfo;
    }
}
