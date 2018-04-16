package com.zdj.web.service.impl;

import com.zdj.web.service.RedisServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisServerImpl implements RedisServer {
    private final static Logger logger = LoggerFactory.getLogger(RedisServerImpl.class);
    private String redisIP;
    private Jedis redisServer;

    public String getRedisIP() {
        return redisIP;
    }

    public void setRedisIP(String redisIP) {
        this.redisIP = redisIP;
    }

    @Override
    public Jedis getRedisServer() throws Exception {
        if (redisServer != null) {
            try {
                redisServer.get("abc");
            } catch (Exception e) {
                logger.error("缓存数据库链接出错，连接IP为" + redisIP, e);
                throw e;
            }
            return redisServer;
        } else {
            try {
                redisServer = new Jedis(redisIP);
                //测试是否连接成功
                redisServer.get("abc");
            } catch (Exception e) {
                logger.error("缓存数据库链接出错，连接IP为" + redisIP, e);
                throw e;
            }
            logger.info("缓存数据库链接成功，连接IP为{}", redisIP);
            return redisServer;
        }
    }
}
