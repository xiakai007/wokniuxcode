package com.woniu.springboot.portals.util;

/**
 * 返回状态码的接口,业务返回码200，错误返回码201
 */
public interface ResultCode {
    public static Integer SUCCESS=200;
    public static Integer ERROR=201;
    public static Integer GRADELISTNULL=203;
    public static Integer FINECOURSENULL=204;
    public static Integer NEWESTCOURSENULL=205;
    public static Integer FAMOUSTEACHERNULL=301;
    public static Integer TEACHERVIEWNULL=302;
    public static Integer USERLOGINSUC=401;
    public static Integer USERLOGINFAIL=402;
    public static Integer NOTOKEN=501;

}
