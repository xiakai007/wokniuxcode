package com.woniu;

import redis.clients.jedis.Jedis;

public class Test02 {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.setex("temp",10,"asdf");
        System.out.println(jedis.get("temp"));
        Thread.sleep(11000);
        System.out.println(jedis.get("temp"));
    }
}
