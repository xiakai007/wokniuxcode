package com.woniu;

import redis.clients.jedis.Jedis;

import java.util.Iterator;

public class Test06 {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();
        jedis.hset("person","uname","tom");
        jedis.hset("person","upass","123456");
        jedis.hset("person","age","18");
        System.out.println(jedis.hget("person","uname"));
        System.out.println(jedis.hget("person","upass"));
        System.out.println(jedis.hget("person","age"));
        System.out.println(jedis.hexists("person","age"));
        System.out.println(jedis.hlen("person"));
        //获得field和value值
        Iterator<String> iterator = jedis.hkeys("person").iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+"\t"+jedis.hget("person",key));
        }
        //获得value值
        Iterator<String> iterator1 = jedis.hvals("person").iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
