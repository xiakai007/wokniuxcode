package com.woniu.springboot.portals.interceptor;

import com.woniu.springboot.portals.exception.K15Exception;
import com.woniu.springboot.portals.util.Constaint;
import com.woniu.springboot.portals.util.JwtUtil;
import com.woniu.springboot.portals.util.ResultCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("******preHandle******");
        /*设置如下代码以从header中取出token信息，缺失的话取不出token信息*/
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String token = request.getHeader("token");
        log.info("token:"+token);
        if(token==null){
            throw new K15Exception(ResultCode.NOTOKEN, Constaint.NOTOKEN);
        }
        try{
            Claims claims = JwtUtil.parseJwt(token);
            return true;
        }catch (ExpiredJwtException e){
            throw new K15Exception(ResultCode.ERROR,Constaint.ERROR);
        }catch(Exception e){
            throw new K15Exception(ResultCode.ERROR,Constaint.ERROR);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
