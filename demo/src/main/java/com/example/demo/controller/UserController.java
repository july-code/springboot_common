package com.example.demo.controller;

import com.example.demo.constant.ErrorCode;
import com.example.demo.entity.User;
import com.example.demo.model.RestResponse;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 *测试数据库连接
 * 测试swagger
 */
@Api(value = "user")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取数据库所有信息", notes = "简单SpringMVC请求")
    @GetMapping("/selectAll")
    public RestResponse selectAll(){
        RestResponse restResponse = new RestResponse(ErrorCode.Error);
        List<User> list = userService.selectAll();
        restResponse.setErrorCode(ErrorCode.NoError);
        restResponse.setData(list);
        return restResponse;
    }

    @ApiOperation(value = "根据主键获取用户信息")
    @GetMapping("getUser/{id}")
    public RestResponse GetUser(@PathVariable int id){
        RestResponse restResponse = new RestResponse(ErrorCode.Error);
        String userInfo = userService.sel(id).toString();
        restResponse.setErrorCode(ErrorCode.NoError);
        restResponse.setData(userInfo);
        return restResponse;
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public RestResponse login(@RequestBody User user) throws UnsupportedEncodingException {
        return userService.login(user.getUserName(),user.getPassWord());
    }
}
