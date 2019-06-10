package com.luxh.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class LingxiRedisService {

    private JedisPool jedisPool;


    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String reply = jedis.set(key, value);
        jedis.close();
        return reply;
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String reply = jedis.get(key);
        jedis.close();
        return reply;
    }



    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
