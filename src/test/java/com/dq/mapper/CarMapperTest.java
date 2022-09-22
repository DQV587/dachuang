package com.dq.mapper;

import com.dq.WxApplication;
import com.dq.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = WxApplication.class)
class CarMapperTest {
    @Autowired
    CarMapper carMapper;
    @Test
    void updatePosition() {
    }

    @Test
    void findById() {
    }

    @Test
    void lookUpStatus() {
    }

    @Test
    void changeStatus() {
    }

    @Test
    void findAvailable() {
        Car car=carMapper.findAvailable();

        System.out.println(car);
    }
}