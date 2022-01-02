package com.example.login.controller;

import com.example.login.domain.User;
import com.example.login.sercive.UserService;
import com.example.login.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
   // @Resource
    private UserService userService;


    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String uname,@RequestParam String password){
        User user = userService.loginService(uname, password);
        if(user!=null){
            return Result.success(user,"登录成功！");
        }else{
            return Result.error("123","账号或密码错误！");
        }

    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user!=null){
            return Result.success(user,"注册成功！");
        }else{
            return Result.error("456","用户名已存在！");
        }
    }

}
