package com.dq.mapper;

import com.dq.domain.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagerMapper {
    public Manager findManager(String name);
}
