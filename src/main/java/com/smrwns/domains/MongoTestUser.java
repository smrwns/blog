package com.smrwns.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class MongoTestUser {
    
    @Id
    private String id;
    
    private String name;
    private String age;
    
    public MongoTestUser(){}
    public MongoTestUser(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    

    
}
