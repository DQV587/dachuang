package com.dq.service;

import com.dq.domain.User;
import com.dq.domain.WxUser;
import com.dq.exceptions.UserNotFoundException;
import com.dq.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findUser(String username) throws UserNotFoundException {
        User user=userMapper.findUser(username);
        return user;
    }
    public void insertUser(String username,String password){
        userMapper.insertUser(new User(0,username,null,password));
    }

    public WxUser login(String openid) {
        return null;
    }
}
