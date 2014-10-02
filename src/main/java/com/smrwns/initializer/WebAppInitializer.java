package com.smrwns.initializer;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.mongodb.Mongo;
import com.smrwns.config.MongoConfig;
import com.smrwns.config.PersistenceConfig;
import com.smrwns.config.RootConfig;
import com.smrwns.config.SessionConfig;
import com.smrwns.config.WebMvcConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[]{RootConfig.class, SessionConfig.class, MongoConfig.class};
        return new Class<?>[]{RootConfig.class, PersistenceConfig.class, SessionConfig.class, MongoConfig.class};
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
        servletContext.addFilter("sessionFilter", DelegatingFilterProxy.class).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
    }
    
}