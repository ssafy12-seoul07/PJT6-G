package com.ssafy.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.ssafy.mvc.model.dao")
@Configuration
public class dbConfig {
}
