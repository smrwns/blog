package com.smrwns.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smrwns.domains.User;

import java.util.List;

@Repository
public interface UserMapper {

    User getById(@Param("username") String username);

    List<User> getList();

    Integer insert(User user);

    Integer update(User user);
    
}
