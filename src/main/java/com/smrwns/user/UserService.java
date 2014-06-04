package com.smrwns.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smrwns.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    
    @Transactional(readOnly=true)
    public User getUser(String id) {
        return userMapper.getUser(id);
    }


    
    @Transactional(readOnly=true)
    public List<User> getList() {
        return null;
    }
    
    @Transactional
    public User add(User user) {
        
        //비지니스 로직 추가 (트랜잭션과 무관)
        this.nonTx();
        
        return null;
    }

    private void nonTx() {
        // TODO Auto-generated method stub
    }

}
