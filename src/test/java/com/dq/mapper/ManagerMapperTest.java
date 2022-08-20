package com.dq.mapper;

import com.dq.domain.Manager;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 使用真实的数据库，这里我们使用H2内存数据库
// @Rollback(value = false)    // 默认为true，数据库操作会回滚。改为false后，不会回滚
class ManagerMapperTest {
    @Autowired
    ManagerMapper managerMapper;
    @Test
    void selectManager() {
        Manager manager=managerMapper.selectManager("DQ");
        System.out.println(manager);
    }
}