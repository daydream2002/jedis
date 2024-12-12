package com.heima.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Author daydream
 * Description
 * Date 2024/12/12 16:56
 */
public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        jedis = new Jedis("10.0.12.205", 6379);
    }

    @Test
    void test() {
        jedis.hset("user:1", "name", "Jack");
        jedis.hset("user:1", "age", "56");
        Map<String, String> stringStringMap = jedis.hgetAll("user:1");
        System.out.println(stringStringMap);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
