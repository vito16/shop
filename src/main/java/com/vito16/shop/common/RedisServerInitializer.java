package com.vito16.shop.common;

import com.github.fppt.jedismock.RedisServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * redis本地嵌入，方便测试
 */
@Slf4j
@Component
public class RedisServerInitializer implements ApplicationRunner {
    @Autowired
    RedisProperties redisProperties;

    private static RedisServer server = null;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String host = redisProperties.getHost();
        int port = redisProperties.getPort();
        JedisPool pool = new JedisPool(host,port);
        try {
            Jedis jedis = pool.getResource();
            jedis.close();
        } catch (JedisConnectionException e) {
            //TODO 创建本地虚拟Redis
            log.error("redis未启动，使用本地嵌入Redis");
            server = RedisServer.newRedisServer(port);
            server.start();
            log.info("本地虚拟redis已启动完毕");
        }
    }
}
