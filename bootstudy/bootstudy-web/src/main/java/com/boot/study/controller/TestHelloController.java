package com.boot.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.bean.Demo;
import com.boot.study.cache.RedisUtils;

@RestController
public class TestHelloController {

    @Autowired
    private RedisUtils redisUtil;

    @RequestMapping("/")
    public String hello() {
        return "hello world!!";
    }

    @RequestMapping("/getDemo")
    public Demo getDemo() {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("测试demo");

        return demo;
    }

    @RequestMapping("/cache")
    public String getCache(@RequestParam String key, String value) {
        redisUtil.set(key, value);
        System.out.println("come in");
        String obj = redisUtil.get(key).toString();
        return obj;
    }

    @RequestMapping("/delcache")
    public String deleteCache() {
        redisUtil.remove("123456");
        return "ok";
    }
}
