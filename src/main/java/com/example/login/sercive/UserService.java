package com.example.login.sercive;


import com.example.login.domain.User;

public interface UserService {

    /*登录业务*/
    User loginService(String uname,String password);
    /*
    * 注册业务*/
    User registService(User user);
}
