package com.dq.mapper;

import com.dq.WxApplication;
import com.dq.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WxApplication.class)
class UserMapperTest {
    @Autowired
    UserMapper um;
    @Test
    void findUser() {
    }

    @Test
    void insertUser() {
        um.insertUser(new User(1,"dq","aaa","dq123456"));
    }
}