package com.woniu.springboot.admin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.woniu.springboot.admin.realm.UserRealm;
import lombok.Data;
import net.sf.ehcache.Ehcache;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Data
@ConfigurationProperties(prefix = "shiro")
public class ShiroAutoJavaConfig {
    private String loginUrl;
    private String unauthorizedUrl;
    private String successUrl;
    private String[] anonUrls;
    private String[] authcUrls;

    /**
     * 定义UserRealm
     * @return
     */
    @Bean
    public UserRealm userRealm(HashedCredentialsMatcher credentialsMatcher){
        UserRealm userRealm=new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    /**
     * DefaultWebSecurityManager是SecurityManager的一个子类
     * @param userRealm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(UserRealm userRealm,
                                                     EhCacheManager ehCacheManager,
                                                     CookieRememberMeManager cookieRememberMeManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        //设置缓存后导致自我分配权限不能及时更新，必须重启服务器;或安全退出
        securityManager.setCacheManager(ehCacheManager);
        ThreadContext.bind(securityManager);
        securityManager.setRememberMeManager(cookieRememberMeManager);
        return securityManager;
    }

    /**
     * 方法名必须为shiroFilter；如果是其他名称，必须使用@Bean(name="shiroFilter")指定
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /*设置安全管理器;将securityManager对象注入到shiroFilterFactoryBean中*/
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登录页放行---login-url
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        //设置未登录页面跳转至登录页面---unauthorized-url
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
        //设置成功登录后的页面跳转路径---success-url
        shiroFilterFactoryBean.setSuccessUrl(successUrl);
        //定义认证规则
        Map<String,String> map=new HashMap<>();
        if (anonUrls != null&&anonUrls.length>0) {
            for (String anonUrl : anonUrls) {
                map.put(anonUrl,"anon");//anon-urls:无需登录即放行
            }
        }
        if (authcUrls != null&&authcUrls.length>0) {
            for (String authcUrl : authcUrls) {
                map.put(authcUrl,"user");//authc-urls:必须登录
            }
        }
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    /**
     * 在thymeleaf中shiro自定义的tag起效
     */
    @Bean("shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hcmatcher = new HashedCredentialsMatcher();
        hcmatcher.setHashAlgorithmName("md5");
        hcmatcher.setHashIterations(1024);
        return hcmatcher;
    }
    @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
        return ehCacheManager;
    }
    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(7*24*3600);
        return simpleCookie;
    }
    @Bean
    public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie);
        return rememberMeManager;
    }
}
