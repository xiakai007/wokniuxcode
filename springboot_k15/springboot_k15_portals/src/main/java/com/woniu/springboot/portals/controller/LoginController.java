package com.woniu.springboot.portals.controller;

import com.woniu.springboot.portals.entity.pojo.User;
import com.woniu.springboot.portals.entity.vo.LoginVo;
import com.woniu.springboot.portals.exception.K15Exception;
import com.woniu.springboot.portals.service.UserService;
import com.woniu.springboot.portals.util.*;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Slf4j
@CrossOrigin
@RestController
/*使用token解决跨域session不一致问题*/
public class LoginController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    /*post请求必须使用@RequestBody注解进行参数传递*/
    public R login(@RequestBody LoginVo loginVo,HttpSession session){
        User loginUser = userService.login(loginVo.getAccount(), loginVo.getPassword());
        if(loginUser!=null){
            log.info("登录时的sessionId值："+session.getId());
            JwtInfo jwtInfo = new JwtInfo(loginVo.getAccount());
            String token = JwtUtil.getJwt(jwtInfo);
            return R.ok().code(ResultCode.USERLOGINSUC).message(Constaint.USERLOGINSUC).data("token",token);
        }else{
            throw new K15Exception(ResultCode.USERLOGINFAIL,Constaint.USERLOGINFAIL);
        }
    }
    @ApiOperation("获取登录用户信息")
    @GetMapping(value = "/getUserInfo")
    public R getUserInfo(HttpServletRequest request,HttpSession session){
        log.info("获取登录用户信息时的sessionId值："+session.getId());
        String token = request.getHeader("token");
        Claims claims = JwtUtil.parseJwt(token);
        String account = (String)claims.get("account");
        if(account!=null){
            JwtInfo jwtInfo = new JwtInfo(account);
            return R.ok().data("userInfo",jwtInfo);
        }else{
            return R.error();
        }
    }
}
