package com.smrwns.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smrwns.domains.MongoTestUser;

@Service
public class MongoTestUsersService {

    @Autowired
    MongoTestUsersRepository repository;
    
    public MongoTestUser findOne(String id) {
 
        MongoTestUser user = repository.findOne(id);
        
        return user;
    }
}
