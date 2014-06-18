package com.smrwns.domains;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {

    private String id;
    private String passwd;
    private String name;
    private String nick;
    private String type;
    private String group;
    private String email;

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getPasswd() {
        return passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNick() {
        return nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", passwd=" + passwd + ", name=" + name
                + ", nick=" + nick + ", type=" + type + ", group=" + group
                + ", email=" + email + "]";
    }

}