package com.imooc.controller;

import com.imooc.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xyzzg on 2018/8/10.
 */
@RestController
public class BasicController {

    @Autowired
    public RedisOperator redis;

    public static final String USER_REDIS_SESSION = "user-redis-session";
}
