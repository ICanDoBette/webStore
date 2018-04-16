package com.zdj.web.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
@Service
public interface RedisServer {
    Jedis getRedisServer() throws Exception;
}
