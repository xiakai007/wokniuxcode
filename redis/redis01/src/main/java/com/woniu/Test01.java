package com.woniu;

import redis.clients.jedis.Jedis;

public class Test01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();
        System.out.println(jedis.ping());
        jedis.set("uname","tom");
        jedis.set("password","123456");
        jedis.set("sex","male");
        System.out.println(jedis.get("uname"));
        System.out.println(jedis.get("password"));
        System.out.println(jedis.get("sex"));
    }
}
