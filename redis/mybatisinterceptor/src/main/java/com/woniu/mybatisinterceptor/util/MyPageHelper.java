package com.woniu.mybatisinterceptor.util;

public class MyPageHelper {
    private static ThreadLocal<Integer> threadLocaloffset=new ThreadLocal();
    private static ThreadLocal<Integer> threadLocallimit=new ThreadLocal();
    public static void setOffset(int offset){
        threadLocaloffset.set(offset);
    }
    public static void setLimit(int limit){
        threadLocallimit.set(limit);
    }
    public static Integer getOffset(){
        return threadLocaloffset.get();
    }
    public static Integer getLimit(){
        return threadLocallimit.get();
    }
    public static void removeOffsetLimit(){
        threadLocaloffset.remove();
        threadLocallimit.remove();
    }
}
