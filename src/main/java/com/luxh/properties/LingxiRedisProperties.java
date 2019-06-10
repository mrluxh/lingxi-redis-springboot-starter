package com.luxh.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description TODO
 * @Author luxiaohua
 * @Date 2019/6/10
 */

@ConfigurationProperties(prefix = "lingxi.redis")
public class LingxiRedisProperties {

    private String host = "127.0.0.1";

    private int port = 6379;

    private int db;

    private String password;

    private int timeout = 2000;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
