package com.woniu.springcache.controller;

import com.woniu.springcache.XiaCache;
import com.woniu.springcache.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @GetMapping(value = "/findById")
    @XiaCache
    public User findById(Integer id){
        log.debug("findById查询了数据库");
        User user = new User(id,"xiakai","123456");
        return user;
    }
    @GetMapping(value = "/findById2")
    @Cacheable(value = "user",key = "#userr.id",condition = "#userr.id%2==0")
    public User findById2(User userr){
        log.debug("findById查询了数据库");
        User user = new User(userr.getId(),"xiakai","123456");
        return user;
    }
    @GetMapping(value = "/updateById")
    @CachePut(value = "user",key = "#userr.id")
    public User updateById(User userr){
        log.debug("updateById更新了数据库");
        User user = new User(userr.getId(),"xiakai2222","111111");
        return user;
    }
    @GetMapping(value = "/delete")
    @CacheEvict(value = "user",key = "#userr.id",allEntries = true,beforeInvocation = true)
    public String delete(User userr){
        log.debug("删除元素");
        User user = new User(userr.getId(),"xiakai2222","111111");
        return "删除成功";
    }
}
