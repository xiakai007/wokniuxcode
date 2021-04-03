package com.woniu;

import redis.clients.jedis.Jedis;

import java.util.Iterator;

public class Test05 {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();
        jedis.zadd("students",1,"tom");
        jedis.zadd("students",2,"jack");
        jedis.zadd("students",3,"mike");
        jedis.zadd("students",4,"mahone");
        jedis.zadd("students",4,"mahone");
        jedis.zrem("students","mahone");
        Iterator<String> iterator = jedis.zrange("students", 0, -1).iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
