package com.woniu.gateway.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 自定义MyRequest，用于脏字过滤
 */
public class MyRequest extends HttpServletRequestWrapper{
    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    //getParameter只对servlet的requestparameter方法有效，对springmvc无效
    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        String dwfname = DirtyWordFilter(parameter);
        return dwfname;
    }
    //springmvc的脏字过滤
    @Override
    public String[] getParameterValues(String name) {
        String[] parameterValues = super.getParameterValues(name);
        if(parameterValues!=null&&parameterValues.length>0){
            for (int i = 0; i < parameterValues.length; i++) {
                parameterValues[i]=DirtyWordFilter(parameterValues[i]);
            }
        }
        return parameterValues;
    }

    public String DirtyWordFilter(String name){
        if(name!=null){
            name = name.replaceAll("<", "&lt;");
            name = name.replaceAll(">", "&gt;");
            name = name.replaceAll("fuck", "*");
            name = name.replaceAll("bitch", "*");
        }
        return name;
    }
}
