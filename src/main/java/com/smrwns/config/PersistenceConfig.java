package com.smrwns.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClient;

@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.smrwns.mapper")
@Configuration
public class PersistenceConfig {
    
    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("classpath:data/schema.sql")
        .build();
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setTypeAliasesPackage("com.smrwns.domains");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sqlmap/**/*.xml"));
        sqlSessionFactory.setConfigLocation(new DefaultResourceLoader().getResource("classpath:sqlmap-config.xml"));
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        
        return mongoTemplate;
        
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient("127.0.0.1", 27017), "mydb");
    }
 
    
}
