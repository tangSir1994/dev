package com.dk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dk.mapper")//此注解是将指定包下面的所有接口变成mybatis的mapper
public class springApp {
    public static void main(String[] args) {
        SpringApplication.run(springApp.class,args);
    }
}
