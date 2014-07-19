package com.smrwns.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages="com.smrwns", excludeFilters ={@ComponentScan.Filter(Configuration.class), @ComponentScan.Filter(Controller.class)})
public class RootConfig {

}
