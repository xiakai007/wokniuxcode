package com.woniu.mybatisinterceptor.cache;

import com.woniu.mybatisinterceptor.config.HottableConfig;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * MyCache类必须在MyContextHolder类之后加载才能正确
 */
public class MyCache implements Cache {
    private RedisTemplate redisTemplate0=null;
    private RedisTemplate redisTemplate1=null;
    private HottableConfig hottableConfig=null;
    private static final int timeoutbase=60;
    //id为命名空间namespace
    private String id;
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private ReentrantLock reentrantLock=new ReentrantLock();
    public MyCache(String id){
        System.out.println("id-=-=-=-=-=>"+id);
        this.id=id;
        redisTemplate0=(RedisTemplate)MyContextHolder.getBean("redisTemplate0");
        System.out.println("redisTemplate0---------->"+redisTemplate0);
        redisTemplate1=(RedisTemplate)MyContextHolder.getBean("redisTemplate1");
        System.out.println("redisTemplate1---------->"+redisTemplate1);
        hottableConfig = (HottableConfig)MyContextHolder.getBean("hottableConfig");
    }
    public boolean isHot(){
        return hottableConfig.getHottables().contains(id);
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
            if(isHot()){
                redisTemplate0.opsForHash().put(id,key,value);
            }else {
                redisTemplate1.opsForHash().put(id,key,value);
                redisTemplate1.expire(id,timeoutbase+new Random().nextInt(60), TimeUnit.SECONDS);
            }
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
            if(isHot()){
                return redisTemplate0.opsForHash().get(id,key);
            }else {
                return redisTemplate1.opsForHash().get(id,key);
            }
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
            if(!isHot()){
                return redisTemplate1.opsForHash().delete(id,key);
            }
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
            if(!isHot()){
                redisTemplate1.opsForHash().delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public int getSize() {
        if(isHot()){
            return redisTemplate0.opsForHash().size(id).intValue();
        }else {
            return redisTemplate1.opsForHash().size(id).intValue();
        }
    }
}
