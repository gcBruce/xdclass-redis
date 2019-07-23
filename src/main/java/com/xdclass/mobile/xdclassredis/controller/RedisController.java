package com.xdclass.mobile.xdclassredis.controller;

import com.xdclass.mobile.xdclassredis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/redis/setAndGet")
    public String getAndSet(String name,String value){
        redisTemplate.opsForValue().set(name,value);
        return (String)redisTemplate.opsForValue().get(name);
    }

    @RequestMapping("/redis/setAndGet1")
    public String getAndSet1(String name,String value){
        redisService.set(name,value);
        return (String)redisService.get(name);
    }
}
