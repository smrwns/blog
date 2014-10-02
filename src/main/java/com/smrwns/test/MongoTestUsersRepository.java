package com.smrwns.test;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smrwns.domains.MongoTestUser;

public interface MongoTestUsersRepository extends MongoRepository<MongoTestUser, String> {
    public MongoTestUser findOne(String id);
    public <S extends MongoTestUser> S save(S s);
}
