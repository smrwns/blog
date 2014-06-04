package com.smrwns.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.smrwns.model.User;

@Repository
public interface UserMapper {

    public User getUser(@Param("id") String id);
    
   /* @Select("SELECT * FROM users WHERE id=#{userId}")
    User getUser(@Param("id") String id);*/
    
}
