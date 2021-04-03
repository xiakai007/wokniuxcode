package com.woniu.mybatisinterceptor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class MyRedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Bean
    public RedisTemplate redisTemplate0(RedisConnectionFactory redisConnectionFactory0){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory0);
        System.out.println("0:"+redisTemplate);
        return redisTemplate;
    }
    @Bean
    public RedisConnectionFactory redisConnectionFactory0(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
        configuration.setDatabase(0);
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration);
        return factory;
    }
    @Bean
    public RedisTemplate redisTemplate1(RedisConnectionFactory redisConnectionFactory1){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory1);
        System.out.println("1:"+redisTemplate);
        return redisTemplate;
    }
    @Bean
    public RedisConnectionFactory redisConnectionFactory1(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
        configuration.setDatabase(1);
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration);
        return factory;
    }
}
