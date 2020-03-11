package com.dk.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dk.convertor.DateConvertor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    /*
    * 注入接口DataSource
    * 返回他的实现类DruidDataSource
    * 读取配置文件的内容@ConfigurationProperties
    * */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDruid(){
        return new DruidDataSource();
    }
    //日期转换
    @Bean
    public DateConvertor getConvertor(){
        return new DateConvertor();
    }
}
