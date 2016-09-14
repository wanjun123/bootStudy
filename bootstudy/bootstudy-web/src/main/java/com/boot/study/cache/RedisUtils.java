package com.boot.study.cache;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    @Resource
    private RedisTemplate redisTemplate;

    private ValueOperations valueOperations;

    @PostConstruct
    public void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    public void removePattern(final String pattern) {
        Set keys = redisTemplate.keys(pattern);
        if (!keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }

    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public Object get(final String key) {
        return valueOperations.get(key);
    }

    public boolean set(final String key, Object value) {
        boolean flag = false;
        valueOperations.set(key, value);
        flag = true;
        return flag;
    }

    public boolean set(final String key, Object value, long timeSeconds) {
        boolean flag = false;
        valueOperations.set(key, value);
        redisTemplate.expire(key, 10, TimeUnit.SECONDS);
        flag = true;
        return flag;
    }

}
