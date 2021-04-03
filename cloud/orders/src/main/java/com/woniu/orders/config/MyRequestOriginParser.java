package com.woniu.orders.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义来源处理规则
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser{
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String comefrom = request.getParameter("comefrom");
        return comefrom;
    }
}
