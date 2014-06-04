package com.smrwns.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smrwns.model.User;

@Service
//@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;
    
    @Transactional(readOnly=true)
    public List<User> getList() {
        return repository.getList();
    }
    
    @Transactional
    public void add(User user) {
        
        //비지니스 로직 추가 (트랜잭션과 무관)
        this.nonTx();
        
        repository.add(user);
    }

    private void nonTx() {
        // TODO Auto-generated method stub
    }
}
