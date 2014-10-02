package com.smrwns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages="com.smrwns", excludeFilters ={@ComponentScan.Filter(Configuration.class), @ComponentScan.Filter(Controller.class)})
@PropertySource("classpath:social.xml")
public class RootConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigrConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
}
