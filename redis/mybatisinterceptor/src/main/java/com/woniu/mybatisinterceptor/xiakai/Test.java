package com.woniu.mybatisinterceptor.xiakai;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,5,10, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3));
    }
}
