package com.woniu.orders.controllerexcep;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrdersControllerFallback {
    public static String messageFallback(Throwable t){
        log.error("Throwable:"+t);
        return "message3的后备方法messageFallback";
    }
}
