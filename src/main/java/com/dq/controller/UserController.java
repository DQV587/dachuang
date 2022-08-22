package com.dq.controller;

import com.dq.domain.Result;
import com.dq.domain.User;
import com.dq.exceptions.UserNotFoundException;
import com.dq.exceptions.passwordIncorrectException;
import com.dq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestParam("username")String username,@RequestParam("password")String password) throws UserNotFoundException, passwordIncorrectException {
        User user=userService.findUser(username);
        if(!user.getPassword().equals(password))
            throw new passwordIncorrectException("密码错误");
        else
            return new Result<>(true,200,"登陆成功",user.getUser_id());
    }
}
