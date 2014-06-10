package com.smrwns.modules.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smrwns.domains.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public User getById(String id) {
        return userMapper.getById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getList() {
        return userMapper.getList();
    }

    @Transactional
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Transactional
    public Integer update(User user) {
        return userMapper.update(user);
    }

}
