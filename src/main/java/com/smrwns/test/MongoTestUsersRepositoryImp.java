package com.smrwns.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.smrwns.domains.MongoTestUser;

@Repository
public class MongoTestUsersRepositoryImp implements MongoTestUsersRepository {

    @Autowired
    MongoOperations mongoOperation;
    
    public static final String COLLECTION_NAME = "users";
    
    @Override
    public MongoTestUser findOne(String id) {

        Object obj = mongoOperation.findOne(Query.query(Criteria.where("id").is(id)), Object.class, COLLECTION_NAME);
        System.out.println(obj.getClass());
        System.out.println(obj);

        Object user = mongoOperation.findOne(Query.query(Criteria.where("id").is(id)), MongoTestUser.class, COLLECTION_NAME);
        System.out.println(user);
        
//        System.out.println("=======================");
//        
//        MongoTestUser mUser = new MongoTestUser("최성균2", "29");
//        mongoOperation.save(mUser, COLLECTION_NAME);
//        System.out.println("=======================");
        
        MongoTestUser mUser = mongoOperation.findOne(Query.query(Criteria.where("age").is("29")), MongoTestUser.class, COLLECTION_NAME);
        System.out.println(mUser);
        System.out.println(mUser.getClass());
        System.out.println(mUser.getName());

        return null;
    }

    @Override
    public <S extends MongoTestUser> S save(S s) {
        mongoOperation.insert(s, COLLECTION_NAME);
        return null;
    }

    @Override
    public List<MongoTestUser> findAll() {
        return null;
    }

    @Override
    public List<MongoTestUser> findAll(Sort arg0) {
        return null;
    }

    @Override
    public <S extends MongoTestUser> List<S> save(Iterable<S> arg0) {
        return null;
    }

    @Override
    public Page<MongoTestUser> findAll(Pageable arg0) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String arg0) {

    }

    @Override
    public void delete(MongoTestUser arg0) {

    }

    @Override
    public void delete(Iterable<? extends MongoTestUser> arg0) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean exists(String arg0) {
        return false;
    }

    @Override
    public Iterable<MongoTestUser> findAll(Iterable<String> arg0) {
        return null;
    }



}
