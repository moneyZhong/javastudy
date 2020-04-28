package com.study.javastudy.jredis;

import redis.clients.jedis.Jedis;

/**
 * @author G7
 */
public class RedisOper {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.16.1.44", 6379);
        System.out.println(jedis.ping("hahah"));


        jedis.set("zq","zhongqian");
        System.out.println(jedis.get("zq"));
        jedis.append("zq","89");
        System.out.println(jedis.get("zq"));


        jedis.close();
    }
}
