package com.example.login.repository;

import com.example.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository <User, Long>{
    User findByUname(String uname);
    User findByUnameAndPassword(String uname,String password);
}
