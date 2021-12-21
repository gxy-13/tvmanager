package com.study.service;


import com.study.bean.Tv;
import com.study.bean.User;
import com.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class UserMapperImpl  {
     @Autowired
     UserMapper userMapper;
     public User login(String username, String password){
         System.out.println(username);
         System.out.println(password);
         return userMapper.login(username,password);
     }



}

