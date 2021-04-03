package com.woniu.k15admin.util;

/**
 * 返回状态码的接口,业务返回码200，错误返回码201
 */
public interface ResultCode {
    public static Integer SUCCESS=200;
    public static Integer ERROR=201;
    /**
     * 部门业务状态码301:成功获取所有部门
     */
    public static Integer DEPTALLSECCESS=301;
    /**
     * 用户业务状态码401：成功移除用户
     */
    public static Integer USERREMOVESUCCESS=401;
    /**
     * 用户业务状态码402：用户集合为空
     */
    public static Integer USERLISTNULL=402;
    /**
     * 用户业务状态码403：用户删除失败
     */
    public static Integer USERREMOVEFAIL=403;
}
