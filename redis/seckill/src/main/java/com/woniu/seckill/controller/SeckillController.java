package com.woniu.seckill.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class SeckillController {
    private static AtomicInteger successcount=new AtomicInteger(0);
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private Redisson redisson;
    @GetMapping(value = "/init")
    public String init(){
        //从数据库中取出库存，声明为5个
        redisTemplate.opsForValue().set("stockcount",5);
        //声明卖出个数为0
        successcount=new AtomicInteger(0);
        return "库存初始化成功";
    }
    @GetMapping(value = "/buy")
    public String buy(){
        //获取分布式锁
        RLock lock = redisson.getLock("stockcount");
        try{
            //上分布式锁
            lock.lock();
            Integer count = (Integer)redisTemplate.opsForValue().get("stockcount");
            count--;
            if(count<0){
                return "已售罄，请明天再来";
            }
            successcount.incrementAndGet();
            redisTemplate.opsForValue().set("stockcount",count);
        }finally {
            //解锁
            lock.unlock();
        }
        return "成功卖出"+successcount.get()+"件";
    }
    @GetMapping(value = "/show")
    public String show(){
        return "成功卖出"+successcount.get()+"件";
    }
}
