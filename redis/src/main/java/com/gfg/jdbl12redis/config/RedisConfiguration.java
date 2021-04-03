package com.gfg.jdbl12redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {
    @Bean
    RedisTemplate<String, String> redisTemplate(){
        RedisTemplate<String, String> redisTemplate
                = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration
                = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.
                setHostName("127.0.0.1");
        redisStandaloneConfiguration.setDatabase(4);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }
}
