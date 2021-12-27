package com.study.service.impl;


import com.study.pojo.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class UserServiceImpl implements UserService {
     @Autowired
     UserMapper userMapper;
     public User login(String username, String password){
         System.out.println(username);
         System.out.println(password);
         return userMapper.login(username,password);
     }



}

