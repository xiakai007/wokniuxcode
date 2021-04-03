package com.woniu.cachea.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache implements Cache {
    private RedisTemplate redisTemplate=null;
    private String id;
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public MyCache(String id){
        System.out.println("id-=-=-=-=-=>"+id);
        this.id=id;
        redisTemplate=(RedisTemplate)MyContextHolder.getBean("redisTemplate");
        System.out.println("redisTemplate---------->"+redisTemplate);
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        try {
            //添加写锁
            lock.writeLock().lock();
            redisTemplate.opsForHash().put(id,key,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            lock.readLock().lock();
            return redisTemplate.opsForHash().get(id,key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        try {
            lock.writeLock().lock();
            return redisTemplate.opsForHash().delete(id,key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return null;
    }

    @Override
    public void clear() {
        try {
            lock.writeLock().lock();
            redisTemplate.opsForHash().delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public int getSize() {
        return redisTemplate.opsForHash().size(id).intValue();
    }
}
