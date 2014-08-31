package com.smrwns.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import com.smrwns.config.Interceptor.PostToWallAfterConnectInterceptor;
import com.smrwns.config.Interceptor.TweetAfterConnectInterceptor;


@Configuration
@EnableSocial
public class SocialConfig implements SocialConfigurer {

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        
        cfConfig.addConnectionFactory(
                new FacebookConnectionFactory(
                        env.getProperty("facebook.appKey"),
                        env.getProperty("facebook.appSecret")));
        
        cfConfig.addConnectionFactory(
                new TwitterConnectionFactory(
                        env.getProperty("twitter.appKey"),
                        env.getProperty("twitter.appSecret")));
    }

    
    @Inject
    private DataSource dataSource;
    
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
    }

    @Override
    public UserIdSource getUserIdSource() {
        //AuthenticationNameUserIdSouce
        return new UserIdSource() {
            @Override
            public String getUserId() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication == null) {
                    throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
                }
                return authentication.getName();
            }
        };
    }
    
    
    /* controller */
    //connect
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        ConnectController controller = new ConnectController(connectionFactoryLocator, connectionRepository);
        
        //controller.setApplicationUrl(environment.getProperty("application.url"));
        controller.addInterceptor(new PostToWallAfterConnectInterceptor()); //facebook
        controller.addInterceptor(new TweetAfterConnectInterceptor());      //twitter
        
        return controller;
    }
    
    //signin
    //disconnect
    //reconnect (filter)
    
}
