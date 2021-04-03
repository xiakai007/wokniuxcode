package com.woniu.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用@InitBinder注解设置时间格式："yyyy-MM-dd"
 */
public class BaseController{
    /**
     * 使用@InitBinder注解实现时间转换
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor
                (new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
