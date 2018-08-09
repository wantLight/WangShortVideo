package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.service.UserService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xyzzg on 2018/8/9.
 */
@RestController
@Api(value = "用户注册登陆的接口",tags = {"注册与登陆的controller"})
public class RegistLoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    @ApiOperation(value = "用户注册",notes = "注册用滴")
    public IMoocJSONResult regist(@RequestBody Users users) throws Exception {
        //判断用户名密码不为空
        if (StringUtils.isBlank(users.getUsername()) || StringUtils.isBlank(users.getPassword())){
            return IMoocJSONResult.errorMsg("用户名或密码不能为空");
        }
        //用户名存在？
        boolean usernameflag = userService.queryUsernameIsExist(users.getUsername());

        //保存用户
        if (!usernameflag){
            users.setNickname(users.getUsername());
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            users.setFansCounts(0);
            users.setReceiveLikeCounts(0);
            users.setFollowCounts(0);
            userService.saveUser(users);
        } else {
            return IMoocJSONResult.errorMsg("用户名已存在");
        }
        return IMoocJSONResult.ok();
    }
}
