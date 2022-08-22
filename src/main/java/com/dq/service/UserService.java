package com.dq.service;

import com.dq.domain.User;
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
        if(user==null){
            throw new UserNotFoundException(username+":用户不存在");
        }
        return user;
    }
}
