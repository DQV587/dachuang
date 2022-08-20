package com.dq.mapper;

import com.dq.WxApplication;
import com.dq.domain.Item;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
//@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = WxApplication.class)
class ItemMapperTest {
    @Autowired
    ItemMapper im;
    @Test
    void getAllItems() {
    }

    @Test
    void insertItem() {
        im.insertItem(new Item(1,3,1,false,"qsq"));
    }

    @Test
    void getItemsByOwnerID() {
        System.out.println(im.getItemsByOwnerID(2));
    }
}