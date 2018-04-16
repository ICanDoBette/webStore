package com.zdj.web.service;

import redis.clients.jedis.Jedis;

public interface RedisServer {
    Jedis getRedisServer() throws Exception;
}
