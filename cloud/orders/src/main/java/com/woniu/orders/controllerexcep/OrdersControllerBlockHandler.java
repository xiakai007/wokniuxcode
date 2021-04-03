package com.woniu.orders.controllerexcep;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrdersControllerBlockHandler {
    public static String messageBlockHandler(BlockException e){
        log.error("BlockException:"+e);
        return "message3的后备方法messageBlockHandler";
    }
}
