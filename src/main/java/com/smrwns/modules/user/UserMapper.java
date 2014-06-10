package com.smrwns.modules.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smrwns.domains.User;

import java.util.List;

@Repository
public interface UserMapper {

    User getById(@Param("id") String id);

    List<User> getList();

    Integer insert(User user);

    Integer update(User user);
    
   /* @Select("SELECT * FROM users WHERE id=#{userId}")
    User getById(@Param("id") String id);*/
    
}
