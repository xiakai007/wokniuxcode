package com.woniu.springboot.admin.util;

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
    /**
     * 用户业务状态码405：用户登录成功
     */
    public static Integer USERLOGINSUCCESS=405;
    /**
     * 用户业务状态码406：用户名或密码错误
     */
    public static Integer USERLOGINFAILURE=406;
    /**
     * 用户业务状态码407：用户安全退出
     */
    public static Integer USERSAFEEXIT=407;
    /**
     * 角色业务状态码501：角色信息为空
     */
    public static Integer ROLELISTNULL=501;
    /**
     * 角色业务状态码502：分配角色成功
     */
    public static Integer ROLEASSIGNSUC=502;
    /**
     * 角色业务状态码503：分配角色失败
     */
    public static Integer ROLEASSIGNFAIL=503;
    /**
     * 权限业务状态码601：权限信息为空
     */
    public static Integer PERMSISNULL=601;
    /**
     * 权限业务状态码602：分配权限成功
     */
    public static Integer PERMASSIGNSUC=602;
    /**
     * 权限业务状态码603：分配权限失败
     */
    public static Integer PERMASSIGNFAIL=603;
}
