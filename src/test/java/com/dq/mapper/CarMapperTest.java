package com.dq.mapper;

import com.dq.WxApplication;
import com.dq.domain.Car;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
        Car car=carMapper.findAvailable();
        carMapper.changeStatus(car.getCar_id(), !car.isStatus());
    }

    @Test
    void findAvailable() {
        Car car=carMapper.findAvailable();

        System.out.println(car);
    }
}