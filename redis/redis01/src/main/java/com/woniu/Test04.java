package com.woniu;

import redis.clients.jedis.Jedis;

import java.util.Iterator;

public class Test04 {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();
        //add
        jedis.sadd("students","tom");
        jedis.sadd("students","jack");
        jedis.sadd("students","jackson");
        jedis.sadd("students","李华");
        //delete
        System.out.println(jedis.srem("students", "李华"));
        //集合长度
        System.out.println(jedis.scard("students"));
        Iterator<String> iterator = jedis.smembers("students").iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
