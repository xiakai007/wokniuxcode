package com.woniu;

import redis.clients.jedis.Jedis;

import java.util.List;

public class Test03 {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();
        //add元素
        jedis.rpush("students","tom");
        jedis.rpush("students","jack");
        jedis.rpush("students","ming");
        jedis.rpush("students","李华");
        jedis.rpush("students","李华");
        //-1取出集合中的所有元素
//        List<String> students = jedis.lrange("students", 0, -1);
//        for (String student : students) {
//            System.out.println(student);
//        }
        //delete,0代表全部删除,删除1个李华
        jedis.lrem("students",1,"李华");
        System.out.println("返回指定下标的数据:"+jedis.lindex("students",3));
        Long length=jedis.llen("students");
        System.out.println("当前集合长度为："+length);
        //update
        jedis.lset("students",0,"aaaaaaaa");
        //List<String> students = jedis.lrange("students", 0, -1);
       for(Long i=0L;i<length;i++){
           System.out.println(jedis.lindex("students",i));
       }
    }
}
