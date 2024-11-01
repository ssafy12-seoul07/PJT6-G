package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ssafy.mvc.interceptor.*;
//여기서 인터셉터 연결

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public final userInterceptor userInterceptor;

    @Autowired
    public WebConfig(userInterceptor userInterceptor) {
        this.userInterceptor = userInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // "/api"로 시작하는 모든 요청에 userInterceptor를 적용
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/api/**");
    }
}
