package ym.springRedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author zjl
 * @Date 2019/6/29 17:29
 */
public class RedisPoolUtil extends Object{
    private static JedisPool jedisPool;
    static {
        String host = "47.102.151.46";
        int port = 6379;
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(2);
        poolConfig.setMaxTotal(5);
        jedisPool = new JedisPool(poolConfig,host,port);
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
}
