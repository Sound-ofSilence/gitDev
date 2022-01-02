package com.example.login.sercive.UserSerciveImpl;

import com.example.login.domain.User;
import com.example.login.repository.UserDao;
import com.example.login.sercive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    //@Resource
    private UserDao userDao;

    @Override
    public User loginService(String uname, String password) {
        User user = userDao.findByUnameAndPassword(uname,password);
        if(user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        if (userDao.findByUname(user.getUname()) != null) {
            /*无法注册*/
            return null;
        }else {
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }

    }
}
