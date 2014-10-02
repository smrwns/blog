package com.smrwns.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;


@Configuration
public class MongoConfig {
    
    @Bean
    public MongoOperations mongoOperation() {
 
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        
        return mongoOperation;
        
    }
     
}
