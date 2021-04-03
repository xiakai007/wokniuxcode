package com.woniu.autha.controller;

import com.woniu.autha.mbg.model.Userinfo;
import com.woniu.autha.service.UserinfoService;
import com.woniu.product.tools.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserinfoController {
    @Autowired
    public UserinfoService userinfoService;

    @RequestMapping("/login")
    public String login(Userinfo userinfo, HttpServletResponse response, HttpSession session,String backurl){
        Userinfo userinfoLogin = userinfoService.login(userinfo);
        System.out.println("userinfoLogin:"+userinfoLogin);
        if(userinfoLogin==null){
            System.out.println("************");
            return "redirect:http://localhost:8061/auth?backurl="+backurl;
        }else {
            String token = JwtUtils.createToken(userinfo.getUsername(), 3600);
            System.out.println("token:"+token);
            log.info("生成的token为{}",token);
            Cookie tokenCookie = new Cookie("token",token);
            log.info("登录成功，令牌为{}",token);
            response.addCookie(tokenCookie);
            return "redirect:"+backurl+"?token="+token;
        }
    }
    @GetMapping("/auth")
    public String auth(String backurl, Model model,@CookieValue(value = "token",required = false) String token){
        if(!StringUtils.isEmpty(token)){
            boolean flag = JwtUtils.verifyToken(token);
            if(!flag){
                model.addAttribute("backurl",backurl);
                return "login";
            }
            return "redirect:"+backurl+"?token="+token;
        }
        model.addAttribute("backurl",backurl);
        return "login";
    }
}
