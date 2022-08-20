package com.dq.mapper;

import com.dq.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper

public interface UserMapper {
    public User findUser(String wx_id);
    public void insertUser(User user);
}

