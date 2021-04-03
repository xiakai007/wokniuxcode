package com.woniu.bootrediss;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class BootredissApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootredissApplication.class, args);
	}
	//RedisTemplate序列化
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer valueRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		//设置Redis的value为json格式,并存储对象信息的序列化类型
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance ,
				ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
		valueRedisSerializer.setObjectMapper(objectMapper);

		RedisSerializer keyRedisSerializer = new StringRedisSerializer();
		template.setKeySerializer(keyRedisSerializer);
		template.setValueSerializer(valueRedisSerializer);
		template.setHashKeySerializer(keyRedisSerializer);
		template.setHashValueSerializer(valueRedisSerializer);
		template.setConnectionFactory(redisConnectionFactory);
		template.afterPropertiesSet();

		return template;
	}

}
