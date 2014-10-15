package com.smrwns.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
public class SocialConfig {
    
    //개발자 앱 연결 정보가 기록된 빈 
    public ConnectionFactoryLocator connectionFactoryLocator() {
        
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        
        registry.addConnectionFactory(
                new FacebookConnectionFactory(
                env.getProperty("facebook.appKey"),
                env.getProperty("facebook.appSecret")));
        registry.addConnectionFactory(
                new TwitterConnectionFactory(
                env.getProperty("twitter.appKey"),
                env.getProperty("twitter.appSecret")));
        
        return registry;
    }
    
    //유저 컨넥션 데이터를 유지하기 위한 레파지토리
    /*  TODO : connection sign up inst
    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        JdbcUsersConnectionRepository repository = null;
        repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), Encryptors.noOpText());
        repository.setConnectionSignUp(new SimpleConnectionSignUp());   //TODO : connection sign up inst
    }
    */
    
    // 작성 중...
    
    @Inject
    private Environment env;
    
    @Inject
    private DataSource dataSource;
    
}
