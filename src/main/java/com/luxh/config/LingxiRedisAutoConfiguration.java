package com.luxh.config;

import com.luxh.properties.LingxiRedisProperties;
import com.luxh.service.LingxiRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ConditionalOnClass(LingxiRedisService.class)
@EnableConfigurationProperties(LingxiRedisProperties.class)
public class LingxiRedisAutoConfiguration {

    @Autowired
    private LingxiRedisProperties lingxiRedisProperties;


    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);

        JedisPool jedisPool = null;

        String password = lingxiRedisProperties.getPassword();
        if(password != null && !"".equals(password)) {
            jedisPool = new JedisPool(jedisPoolConfig,
                    lingxiRedisProperties.getHost(),
                    lingxiRedisProperties.getPort(),
                    lingxiRedisProperties.getTimeout());
        }else {
            jedisPool = new JedisPool(jedisPoolConfig,
                    lingxiRedisProperties.getHost(),
                    lingxiRedisProperties.getPort(),
                    lingxiRedisProperties.getTimeout(),
                    lingxiRedisProperties.getPassword());
        }
        return jedisPool;
    }


    @Bean
    public LingxiRedisService lingxiRedisService() {
        LingxiRedisService lingxiRedisService = new LingxiRedisService();
        lingxiRedisService.setJedisPool(jedisPool());
        return lingxiRedisService;
    }
}
