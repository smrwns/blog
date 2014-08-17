package com.smrwns.domains;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {

    private Long id;            //primary index
    private String username;    //display name, nick name
    private String password;
    private String name;
    private String email;
    private Date registered;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getRegistered() {
        return registered;
    }
    
    public void setRegistered(Date registered) {
        this.registered = registered;
    }
    
}