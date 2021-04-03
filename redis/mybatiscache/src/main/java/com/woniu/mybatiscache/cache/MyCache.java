package com.woniu.mybatiscache.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

public class MyCache implements Cache {
    private RedisTemplate redisTemplate=null;
    private String id;
    public MyCache(String id){
        System.out.println("id:"+id);
        this.id=id;
        redisTemplate = (RedisTemplate)MyContextHolder.getBean("redisTemplate");
        System.out.println("redisTemplate:"+redisTemplate);
    }
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object key, Object value) {
        redisTemplate.opsForHash().put(id,key,value);
    }

    @Override
    public Object getObject(Object key) {
        return redisTemplate.opsForHash().get(id,key);
    }

    @Override
    public Object removeObject(Object key) {
        return redisTemplate.opsForHash().delete(id,key);
    }

    @Override
    public void clear() {
        redisTemplate.opsForHash().delete(id);
    }

    @Override
    public int getSize() {
        return redisTemplate.opsForHash().size(id).intValue();
    }
}
