package com.smrwns.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class, PersistenceConfig.class, SessionConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFileter = new CharacterEncodingFilter();
        encodingFileter.setEncoding("UTF-8");
        encodingFileter.setForceEncoding(true);
        
        return new Filter[]{encodingFileter, new HiddenHttpMethodFilter()};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //Proxy for a standard Servlet 2.3 Filter
        //filter를 위임할 프록시를 생성한 후에 url pattern들에 대한 mapping 설정을 추가.
        //mapping 설정 내용은 dispatcher type(FORWARD, INCLUDE, REQUEST, ASYNC, ERROR), isMatchAfter(정의된 어느 필터 매핑 후에 매핑을 할것인가를 정의), urlPatterns 
        servletContext.addFilter("sessionFilter", DelegatingFilterProxy.class).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
        //SessionRepositoryFilter를 SessionConfig의 sessionFilter메소드를 통해 가져옮.
    }
    
}