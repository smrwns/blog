package com.smrwns.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.web.SessionRepositoryFilter;

import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

@Configuration
public class SessionConfig {
    
    //서블릿 컨테이너에 RedisServer Bean을 로딩시켜 둠.
    @Bean
    public RedisServerBean redisSever() {
        return new RedisServerBean();
    }
        
    //RedisServerBean Bean 생성후에 사용되는 설정과 소멸시에 사용되는 설정을 구현
    class RedisServerBean implements InitializingBean, DisposableBean {

        private RedisServer redisServer;
        
        @Override
        public void afterPropertiesSet() throws Exception {
            redisServer = new RedisServer(Protocol.DEFAULT_PORT);
            redisServer.start();
        }
        
        @Override
        public void destroy() throws Exception {
            if(redisServer != null) redisServer.stop();
        }

    }
    
    //서블릿 컨테이너에 connectionFactory Bean을 로딩시켜 둠.
    @Bean
    public JedisConnectionFactory connectionFactory() throws Exception {
        return new JedisConnectionFactory();
    }
    
    //redis 접근을 위한 template Bean을 로딩시켜 둠. 
    @Bean
    public RedisTemplate<String, Session> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Session> template = new RedisTemplate<String, Session>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    
    //Session Repository Bean을 로딩시켜 둠. 
    @Bean
    public RedisOperationsSessionRepository sessionRepository(RedisTemplate<String, Session> redisTemplate) {
        return new RedisOperationsSessionRepository(redisTemplate);
    }
    
    //Session Repository Filter Bean을 로딩시켜 둠.
    @SuppressWarnings({"unchecked" ,"rawtypes"}) //어노테이션으로 제약시켜야하는 컴파일러 경고들을 정의
    @Bean
    public SessionRepositoryFilter sessionFilter(RedisOperationsSessionRepository sessionRepository) {
        return new SessionRepositoryFilter(sessionRepository);
    }
    
}