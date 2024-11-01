package com.ssafy.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//dao와 Mybatis 연결
@MapperScan(basePackages = "com.ssafy.mvc.model.dao")
public class dbConfig {

}
