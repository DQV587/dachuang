package com.dq.service;

import com.dq.domain.Manager;
import com.dq.exceptions.managerNotFoundException;
import com.dq.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    ManagerMapper managerMapper;
    public Manager findManager(String username) throws managerNotFoundException {
        Manager manager=managerMapper.findManager(username);
        if(manager==null)
            throw new managerNotFoundException("管理员账号未找到");
        else return manager;
    }
}
